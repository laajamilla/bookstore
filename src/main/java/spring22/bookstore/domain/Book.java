package spring22.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;


@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(min=1, max=40)
	private String title, author;
	
	private int bookyear;
	private String isbn;
	private double price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super();
		this.title = title;
	}
	
	// tässä konstruktorissa ei kategoriaa, tarvitaan, jos kateg ei vielä käytetty muualla ohjelmassa
	// tällä konstruktorilla kategorian arvo = null tietokannassa
	public Book(String title, String author, int bookyear, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.bookyear = bookyear;
		this.isbn = isbn;
		this.price = price;
		
	}
	// tässä konstruktorissa kategoria
	public Book(String title, String author, int bookyear, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.bookyear = bookyear;
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

	public int getBookyear() {
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
	

	public Long getId() {
		return id;
	}
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", bookyear=" + bookyear + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}
	
	
	
}
