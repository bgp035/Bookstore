package Schoolproject.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	private String title;
	private String author;
	private int year;
	@Id
	private String isbn;
	private double price;
	@ManyToOne
	@JoinColumn(name = "id")
	private Category id;
	

	public Book() {
		super();
	}

	public Book(String title, String author, int year, String isbn, double price, Category id) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.id = id;
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

	

	public Category getId() {
		return id;
	}


	public void setId(Category id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
				+ ", id=" + id + "]";
	}

	
}
