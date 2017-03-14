package application;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Edit extends GridPane {
	
	Text confirmText;
	
	public Edit(String _title, String _isbn, int _pages, String _a_fn, String _a_ln, String _genre, String _publisher) {
		
		String origTitle = _title;
		String origAFN = _a_fn;
		String origALN = _a_ln;
		String origGenre = _genre;
		String origPub = _publisher;
		
		Text prompt = new Text("Edit book details");
		Text prompt2 = new Text("Please fill in all the fields!");
		Label title = new Label("Title: ");
		TextField titleField = new TextField(_title);
		Label isbn = new Label("ISBN: ");
		TextField isbnField = new TextField(_isbn);
		Label pages = new Label("Pages: ");
		TextField pagesField = new TextField(Integer.toString(_pages));
		Label a_fn = new Label("Author First Name: ");
		TextField a_fnField = new TextField(_a_fn);
		Label a_ln = new Label("Author Last Name: ");
		TextField a_lnField = new TextField(_a_ln);
		Label genre = new Label("Genre: ");
		TextField genreField = new TextField(_genre);
		Label publisher = new Label("Publisher: ");
		TextField publisherField = new TextField(_publisher);
		
		Button confirm = new Button("Edit book info");
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				if((titleField.getText() != null && !titleField.getText().isEmpty()) &&
						(isbnField.getText() != null && !isbnField.getText().isEmpty()) &&
						(pagesField.getText() != null && !pagesField.getText().isEmpty()) &&
						(a_fnField.getText() != null && !a_fnField.getText().isEmpty()) &&
						(a_lnField.getText() != null && !a_lnField.getText().isEmpty()) &&
						(genreField.getText() != null && !genreField.getText().isEmpty()) &&
						(publisherField.getText() != null && !publisherField.getText().isEmpty())) {
					
					try {
						
						DBOperations DBOp = new DBOperations();
						DBOp.editBook(titleField.getText(), isbnField.getText(), pagesField.getText(), a_fnField.getText(), a_lnField.getText(), genreField.getText(), publisherField.getText(),
								origTitle, origAFN, origALN, origGenre, origPub);
					}catch(SQLException e1) {
						
						e1.printStackTrace();
					}
					
					confirmText.setText("Book added succesfully!");
				}
				else {
					
					confirmText.setText("Please fill in all the fields!");
				}
			}
		});
		
		Button close = new Button("Close");
		close.setOnAction(new EventHandler<ActionEvent> () {
			
			@Override
			public void handle(ActionEvent e) {
				
				((Node)(e.getSource())).getScene().getWindow().hide();
			}
		});
		
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(5);
		this.setPadding(new Insets(25));
		
		GridPane.setHalignment(prompt, HPos.CENTER);
		this.add(prompt, 0, 0, 4, 1);
		
		GridPane.setHalignment(prompt2, HPos.CENTER);
		this.add(prompt2, 0, 1, 4, 1);
		
		HBox center1 = new HBox();
		center1.getChildren().addAll(title, titleField);
		center1.setSpacing(10);
		center1.setAlignment(Pos.CENTER);
		this.add(center1, 0, 2, 4, 1);
		
		this.add(a_fn, 0, 3);
		GridPane.setHalignment(a_fn, HPos.CENTER);
		
		this.add(a_fnField, 1, 3);
		GridPane.setHalignment(a_fnField, HPos.CENTER);
		
		this.add(a_ln, 2, 3);
		GridPane.setHalignment(a_ln, HPos.CENTER);
		
		this.add(a_lnField, 3, 3);
		GridPane.setHalignment(a_lnField, HPos.CENTER);
		
		this.add(isbn, 0, 4);
		GridPane.setHalignment(isbn, HPos.CENTER);
		
		this.add(isbnField, 1, 4);
		GridPane.setHalignment(isbnField, HPos.CENTER);
		
		this.add(pages, 2, 4);
		GridPane.setHalignment(pages, HPos.CENTER);
		
		this.add(pagesField, 3, 4);
		GridPane.setHalignment(pagesField, HPos.CENTER);
		
		this.add(publisher, 0, 5);
		GridPane.setHalignment(publisher, HPos.CENTER);
		
		this.add(publisherField, 1, 5);
		GridPane.setHalignment(publisherField, HPos.CENTER);
		
		this.add(genre, 2, 5);
		GridPane.setHalignment(genre, HPos.CENTER);
		
		this.add(genreField, 3, 5);
		GridPane.setHalignment(genreField, HPos.CENTER);
		
		this.add(confirm, 3, 6);
		GridPane.setHalignment(confirm, HPos.CENTER);
		
		this.add(close, 0, 6);
		
		confirmText = new Text(" ");
		this.add(confirmText, 3, 7);
		GridPane.setHalignment(confirmText, HPos.CENTER);
	}
}
