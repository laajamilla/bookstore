package spring22.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import spring22.bookstore.domain.Book;
import spring22.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
    
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			log.info("save books");
			
			repository.save(new Book("Viisikko", "Enid Blyton", 1986, "951-30-6520-0", 12.34));
			repository.save(new Book("Keittokirja", "Kinuski Kissa", 2012, "321-44-2342-1", 23.56));
			repository.save(new Book("Kissakirja", "Maija Mirri", 2020, "123-56-7896-2", 25.99));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}

}
