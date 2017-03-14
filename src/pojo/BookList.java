package pojo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BookList extends VBox {
	
	private String title;
	private String isbn;
	private int pages;
	private String a_fn;
	private String a_ln;
	private String genre;
	private String publisher;
	
	Label titleL;
	Label authorL;
	
	public BookList(String title, String isbn, int pages, String a_fn, String a_ln, String genre, String publisher) {
		
		super();
		
		this.title = title;
		this.isbn = isbn;
		this.pages = pages;
		this.a_fn = a_fn;
		this.a_ln = a_ln;
		this.genre = genre;
		this.publisher = publisher;
		
		titleL = new Label(title);
		authorL = new Label(a_fn + " " + a_ln);
		
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(titleL, authorL);
	}

	public String getTitle() {
		
		return title;
	}

	public String getIsbn() {
		
		return isbn;
	}

	public int getPages() {
		
		return pages;
	}

	public String getA_fn() {
		
		return a_fn;
	}

	public String getA_ln() {
		
		return a_ln;
	}

	public String getGenre() {
		
		return genre;
	}

	public String getPublisher() {
		
		return publisher;
	}
}
