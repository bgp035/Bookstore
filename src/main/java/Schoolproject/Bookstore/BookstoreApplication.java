package Schoolproject.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Schoolproject.Bookstore.domain.Book;
import Schoolproject.Bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); 
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository) { 
		return (args) -> {
			log.info("Tallenna kirjat");
			Book book1 = new Book("Oppi", "Ope", 2015,"BN29292", 12.99);
			Book book2 = new Book("Kirja", "Taija", 2020,"IS313131", 29.99);
			bookRepository.save(book1);
			bookRepository.save(book2);	
			
			log.info("Hae kirjat");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
