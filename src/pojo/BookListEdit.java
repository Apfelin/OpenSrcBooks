package pojo;

import java.sql.SQLException;

import application.DBOperations;
import application.Edit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookListEdit extends VBox {
	
	private String title;
	private String isbn;
	private int pages;
	private String a_fn;
	private String a_ln;
	private String genre;
	private String publisher;
	
	Label titleL;
	Label authorL;
	
	public BookListEdit(String _title, String _isbn, int _pages, String _a_fn, String _a_ln, String _genre, String _publisher) {
		
		super();
		
		this.title = _title;
		this.isbn = _isbn;
		this.pages = _pages;
		this.a_fn = _a_fn;
		this.a_ln = _a_ln;
		this.genre = _genre;
		this.publisher = _publisher;
		
		titleL = new Label(title);
		authorL = new Label(a_fn + " " + a_ln);
		
		HBox hbox = new HBox();
		VBox vbox = new VBox();
		HBox container = new HBox();
		
		Button edit = new Button("Edit");
		edit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Stage editStage = new Stage();
				Scene editScene = new Scene(new Edit(title, isbn, pages, a_fn, a_ln, genre, publisher), 800, 600);
				
				editStage.setTitle("Edit Book");
				editStage.setScene(editScene);
				editStage.show();
			}
		});
		
		Button delete = new Button("Delete");
		delete.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				try {
					
					DBOperations DBOp = new DBOperations();
					DBOp.removeBook(isbn, a_fn, a_ln, publisher);
				}catch(SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		vbox.setSpacing(5);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(titleL, authorL);
		
		container.getChildren().add(vbox);
		container.setAlignment(Pos.CENTER);
		
		hbox.getChildren().addAll(container, edit, delete);
		hbox.setAlignment(Pos.CENTER);
		HBox.setHgrow(container, Priority.ALWAYS);
		hbox.setSpacing(10);
		
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(hbox);
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