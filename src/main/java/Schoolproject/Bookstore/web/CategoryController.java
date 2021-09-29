package Schoolproject.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Schoolproject.Bookstore.domain.Category;
import Schoolproject.Bookstore.domain.CategoryRepository;

@Controller

public class CategoryController {
	

	@Autowired
	private CategoryRepository repository;
	
	@RequestMapping(value="/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", repository.findAll());
		return "categorylist";
	}
	

	@RequestMapping(value="/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}

	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String save(Category Category) {
		repository.save(Category);
		return "redirect:categorylist";
	}
	
}
