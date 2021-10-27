package Schoolproject.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Schoolproject.Bookstore.domain.Book;
import Schoolproject.Bookstore.domain.BookRepository;
import Schoolproject.Bookstore.domain.Category;
import Schoolproject.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTests {

	@Autowired
    private BookRepository bookRepository;
	@Autowired
	private CategoryRepository crepository;
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bookRepository.findByTitle("Oppi");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Ope");	
	}

	@Test
	public void createCategory() {
		Category category = new Category(3, "Testing");
		crepository.save(category);
		assertThat(category.getId()).isNotNull();
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Test", "Testaaja", 2021,"TS404040", 12.99, null);
		bookRepository.save(book);
		assertThat(book.getIsbn()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		Book book = new Book("Test", "Testaaja", 2021,"TS404040", 12.99, null);
		bookRepository.deleteByTitle(book.getTitle());
		assertThat(book.getIsbn()).isNull();
	}
	
	
}
