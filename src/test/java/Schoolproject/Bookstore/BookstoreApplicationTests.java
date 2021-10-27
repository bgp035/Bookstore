package Schoolproject.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Schoolproject.Bookstore.web.BookController;
import Schoolproject.Bookstore.web.CategoryController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	
	@Test
    public void contextLoads1() throws Exception {
        assertThat(bookController).isNotNull();
    }
	
	@Autowired
	private CategoryController categoryController;
	
	@Test
    public void contextLoads2() throws Exception {
        assertThat(categoryController).isNotNull();
    }
}
