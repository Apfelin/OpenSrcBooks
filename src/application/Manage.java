package application;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import pojo.BookListEdit;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Manage extends BorderPane {
	
	BorderPane center;
	ListView<BookListEdit> listview;
	VBox middleSide;
	HBox topMiddle;
	TextField search;
	Button btnSearch;
	Text confirmText;
	
	Manage() {
		
		VBox leftSide = addLeft();
		
		middleSide = new VBox();
		topMiddle = new HBox();
		search = new TextField();
		search.setPromptText("Search...");
		btnSearch = new Button("Go");
		btnSearch.setOnAction(new EventHandler<ActionEvent> () {
			
			@Override
			public void handle(ActionEvent e) {
				
				if((search.getText() != null && !search.getText().isEmpty())) {
					
					ArrayList<BookListEdit> bookList = new ArrayList<BookListEdit>();
					
					try {
						
						DBOperations DBOp = new DBOperations();
						bookList = DBOp.searchDBEdit(search.getText());
					}catch(SQLException e1) {
						
						e1.printStackTrace();
					}
					
					ObservableList<BookListEdit> obsList = FXCollections.observableList(bookList);
					listview.setItems(obsList);
					middleSide.getChildren().setAll(topMiddle, listview);
				}
			}
		});
		
		topMiddle.getChildren().addAll(search, btnSearch);
		topMiddle.setSpacing(10);
		
		listview = new ListView<BookListEdit>();
		
		VBox.setVgrow(listview, Priority.ALWAYS);
		middleSide.setPadding(new Insets(10));
		middleSide.setSpacing(10);
		
		this.setLeft(leftSide);
		this.setCenter(middleSide);
	}
	
	private VBox addLeft() {
		
		VBox left = new VBox();
		left.setPadding(new Insets(10));
		left.setSpacing(5);
		
		Text prompt = new Text("Manage Books");
		
		Button add = new Button("Add Book");
		add.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Text prompt = new Text("Add a new book");
				Text prompt2 = new Text("Please fill in every field!");
				Label title = new Label("Title: ");
				TextField titleField = new TextField();
				Label isbn = new Label("ISBN: ");
				TextField isbnField = new TextField();
				Label pages = new Label("Pages: ");
				TextField pagesField = new TextField();
				Label authorFN = new Label("Author First Name: ");
				TextField authorFNField = new TextField();
				Label authorLN = new Label("Author Last Name: ");
				TextField authorLNField = new TextField();
				Label genre = new Label("Genre: ");
				TextField genreField = new TextField();
				Label publisher = new Label("Publisher: ");
				TextField publisherField = new TextField();
				
				Button confirm = new Button("Add to database");
				confirm.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent e) {
						
						if((titleField.getText() != null && !titleField.getText().isEmpty()) &&
								(isbnField.getText() != null && !isbnField.getText().isEmpty()) &&
								(pagesField.getText() != null && !pagesField.getText().isEmpty()) &&
								(authorFNField.getText() != null && !authorFNField.getText().isEmpty()) &&
								(authorLNField.getText() != null && !authorLNField.getText().isEmpty()) &&
								(genreField.getText() != null && !genreField.getText().isEmpty()) &&
								(publisherField.getText() != null && !publisherField.getText().isEmpty())) {
							
							try {
								
								DBOperations DBOp = new DBOperations();
								DBOp.addBook(titleField.getText(), isbnField.getText(), pagesField.getText(), authorFNField.getText(), authorLNField.getText(), genreField.getText(), publisherField.getText());
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
				
				GridPane addView = new GridPane();
				addView.setAlignment(Pos.CENTER);
				addView.setHgap(10);
				addView.setVgap(10);
				
				addView.add(prompt, 0, 0, 4, 1);
				GridPane.setHalignment(prompt, HPos.CENTER);
				
				addView.add(prompt2, 0, 1, 4, 1);
				GridPane.setHalignment(prompt2, HPos.CENTER);
				
				HBox center1 = new HBox();
				center1.getChildren().addAll(title, titleField);
				center1.setSpacing(10);
				center1.setAlignment(Pos.CENTER);
				addView.add(center1, 0, 2, 4, 1);
				
				addView.add(authorFN, 0, 3);
				GridPane.setHalignment(authorFN, HPos.CENTER);
				
				addView.add(authorFNField, 1, 3);
				GridPane.setHalignment(authorFNField, HPos.CENTER);
				
				addView.add(authorLN, 2, 3);
				GridPane.setHalignment(authorLN, HPos.CENTER);
				
				addView.add(authorLNField, 3, 3);
				GridPane.setHalignment(authorLNField, HPos.CENTER);
				
				addView.add(isbn, 0, 4);
				GridPane.setHalignment(isbn, HPos.CENTER);
				
				addView.add(isbnField, 1, 4);
				GridPane.setHalignment(isbnField, HPos.CENTER);
				
				addView.add(pages, 2, 4);
				GridPane.setHalignment(pages, HPos.CENTER);
				
				addView.add(pagesField, 3, 4);
				GridPane.setHalignment(pagesField, HPos.CENTER);
				
				addView.add(publisher, 0, 5);
				GridPane.setHalignment(publisher, HPos.CENTER);
				
				addView.add(publisherField, 1, 5);
				GridPane.setHalignment(publisherField, HPos.CENTER);
				
				addView.add(genre, 2, 5);
				GridPane.setHalignment(genre, HPos.CENTER);
				
				addView.add(genreField, 3, 5);
				GridPane.setHalignment(genreField, HPos.CENTER);
				
				addView.add(confirm, 3, 6);
				GridPane.setHalignment(confirm, HPos.CENTER);
				
				confirmText = new Text(" ");
				addView.add(confirmText, 3, 7);
				GridPane.setHalignment(confirmText, HPos.CENTER);
				
				middleSide.getChildren().setAll(addView);
			}
		});
		add.setMaxWidth(Double.MAX_VALUE);
		
		Button change = new Button("Edit Book");
		change.setOnAction(new EventHandler<ActionEvent> () {
			
			@Override
			public void handle(ActionEvent e) {
				
				ArrayList<BookListEdit> bookList = new ArrayList<BookListEdit>();
				
				try {
					
					DBOperations DBOp = new DBOperations();
					bookList = DBOp.getInfoEdit();
				}catch(SQLException e1) {
					
					e1.printStackTrace();
				}
				
				ObservableList<BookListEdit> obsList = FXCollections.observableList(bookList);
				listview.setItems(obsList);
				middleSide.getChildren().setAll(topMiddle, listview);
			}
		});
		change.setMaxWidth(Double.MAX_VALUE);
		
		Separator sep = new Separator();
		
		Button close = new Button("Close");
		close.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				((Node)(e.getSource())).getScene().getWindow().hide();
			}
		});
		close.setMaxWidth(Double.MAX_VALUE);
		
		left.getChildren().addAll(prompt, add, change, sep, close);
		
		return left;
	}
}
