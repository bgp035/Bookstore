package Schoolproject.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
	private String title;
	private String author;
	private int year;
	@Id
	private String isbn;
	private double price;
	@ManyToOne
	@JsonIgnoreProperties("books")
	@JoinColumn(name = "id")
	private Category category;
	

	public Book() {
		super();
	}

	public Book(String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	

	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
				+ ", category=" + category + "]";
	}

	
}
