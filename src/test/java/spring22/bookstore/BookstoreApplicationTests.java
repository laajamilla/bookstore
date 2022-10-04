package spring22.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring22.bookstore.web.BookController;
import spring22.bookstore.web.BookstoreRestController;

@SpringBootTest
class BookstoreApplicationTests {
	
	// smoke test
	
	@Autowired
	BookController bookController;
	
	@Autowired
	BookstoreRestController bookstoreRestController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(bookstoreRestController).isNotNull();
	}

}
