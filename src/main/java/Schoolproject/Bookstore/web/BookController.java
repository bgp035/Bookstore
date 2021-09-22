package Schoolproject.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Schoolproject.Bookstore.domain.BookRepository;

@Controller

public class BookController {
	
	@RequestMapping(value= "/index", method= RequestMethod.GET)
	public String index() {
		return "index";
	}
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
}
