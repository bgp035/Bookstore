package Schoolproject.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Schoolproject.Bookstore.domain.Book;
import Schoolproject.Bookstore.domain.BookRepository;
import Schoolproject.Bookstore.domain.CategoryRepository;
@CrossOrigin
@Controller

public class BookController {
	
	@RequestMapping(value= "/index", method= RequestMethod.GET)
	public String index() {
		return "index";
	}
	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	@RequestMapping(value="/books/{isbn}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("isbn") String isbn) {
		return repository.findById(isbn);
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public @ResponseBody Book saveBookRest(@RequestBody Book book) {
		return repository.save(book);
	}
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book Book) {
		repository.save(Book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value = "/delete/{isbn}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("isbn") String bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

	@RequestMapping(value= "/edit/{isbn}")
	public String addBook(@PathVariable("isbn") String bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	
}
