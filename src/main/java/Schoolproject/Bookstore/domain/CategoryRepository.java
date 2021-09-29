package Schoolproject.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String>{
	List<Category> findByName(String name);
	void deleteById(int id);
}
