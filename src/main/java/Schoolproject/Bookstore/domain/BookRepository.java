package Schoolproject.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
	List<Book> findByTitle(String title);
	void deleteByTitle(String title);
}
