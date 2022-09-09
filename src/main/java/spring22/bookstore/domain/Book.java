package spring22.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title, author;
	private int bookyear;
	private String isbn;
	private double price;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super();
		this.title = title;
	}

	public Book(String title, String author, int bookyear, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.bookyear = bookyear;
		this.isbn = isbn;
		this.price = price;
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
		return bookyear;
	}

	public void setBookyear(int bookyear) {
		this.bookyear = bookyear;
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

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", bookyear=" + bookyear + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}
	
	
	
}
