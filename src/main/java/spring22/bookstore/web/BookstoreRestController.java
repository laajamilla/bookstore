package spring22.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring22.bookstore.domain.Book;
import spring22.bookstore.domain.BookRepository;

@RestController
public class BookstoreRestController {

	@Autowired
	BookRepository bookRepository;
	
	// return list of books -> toimii posmanissa
	@GetMapping("/books")
	public Iterable<Book> getBooks(){
		return bookRepository.findAll();
	}
	
	// add new car -> toimii postmanissa, kun pyyntö JSON- muodossa
	@PostMapping("/books")
	Book newBook(@RequestBody Book newBook) {
		return bookRepository.save(newBook);
	}
	
	// find one book by id -> toimii postmanissa
	@GetMapping("/books/{id}")
	Optional<Book> getBook(@PathVariable Long id) {
		return bookRepository.findById(id);
	}
	
	// edit existing book information -> Postmanissa editoi bodyn dataa
	@PutMapping("/books/{id}")
	Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
		editedBook.setId(id);
		return bookRepository.save(editedBook);
	}
	
	// delete one car (id)
	@DeleteMapping("/books/{id}")
	public Iterable<Book> deleteCar(@PathVariable Long id) {
		bookRepository.deleteById(id);
		return bookRepository.findAll();
	}
	
	
}
