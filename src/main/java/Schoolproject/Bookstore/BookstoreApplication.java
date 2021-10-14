package Schoolproject.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Schoolproject.Bookstore.domain.Book;
import Schoolproject.Bookstore.domain.BookRepository;
import Schoolproject.Bookstore.domain.Category;
import Schoolproject.Bookstore.domain.CategoryRepository;
import Schoolproject.Bookstore.domain.User;
import Schoolproject.Bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); 
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository urepository) { 
		return (args) -> {
			Category category1 = new Category(1, "Romance");
			categoryRepository.save(category1);
			Category category2 = new Category(2, "Thriller");
			categoryRepository.save(category2);	
			
			
			log.info("Tallenna kirjat");
			Book book1 = new Book("Oppi", "Ope", 2015,"BN29292", 12.99, category1);
			Book book2 = new Book("Kirja", "Taija", 2020,"IS313131", 29.99, category2);
			
			bookRepository.save(book1);
			bookRepository.save(book2);	
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("Hae kirjat");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	/*@Bean
	public CommandLineRunner categoryDemo(CategoryRepository categoryRepository) { 
		return (args) -> {
			log.info("Tallenna kategoriat");
			
			log.info("Hae Kategoriat");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

		};
	}*/
	
}
