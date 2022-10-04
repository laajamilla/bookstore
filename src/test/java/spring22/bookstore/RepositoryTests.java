package spring22.bookstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import spring22.bookstore.domain.Book;
import spring22.bookstore.domain.BookRepository;

@DataJpaTest
class RepositoryTests {
	
	@Autowired
	BookRepository bookRepository;

	// testaa create, delete ja search
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void findById() {
		
		Book book = bookRepository.findById((long) 1).get();
		assertEquals(book.getTitle(), "Viisikko");
			
		}
	
	@Test
	public void createNewBook() {
		//Book book = new Book("Maameren tarinat", "Ursula Le Guin", 1976, "951-0-27186-1");
		
	}
	
	
}
	
	

	
	
	

