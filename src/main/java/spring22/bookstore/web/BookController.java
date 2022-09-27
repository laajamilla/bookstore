package spring22.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring22.bookstore.BookstoreApplication;
import spring22.bookstore.domain.Book;
import spring22.bookstore.domain.BookRepository;
import spring22.bookstore.domain.CategoryRepository;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
public class BookController {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository categoryrepository;

	@RequestMapping(value= {"/", "booklist"})
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value= "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryrepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("some error happened");
			//kategoriat vietävä uudelleen, koska ei kuljeta add- endpointin kautta
			//muutoin kategorioita ei ole listattuna
			model.addAttribute("categories", categoryrepository.findAll());
			return "addbook";
		}
		
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		log.info("id");
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", categoryrepository.findAll());
		return "editbook";
	}
}
