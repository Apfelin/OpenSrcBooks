package application;
	
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import pojo.BookList;
import pojo.Books150;
import pojo.CQuery1;
import pojo.CQuery2;
import pojo.CQuery3;
import pojo.SQuery1;
import pojo.SQuery3;
import pojo.SQuery4;
import pojo.SQuery5;

public class Main extends Application {
	
	//root scene
	BorderPane root = new BorderPane();
	
	//left side
	VBox sidebar;
	
	//center side
	ListView<BookList> listview;
	ArrayList<BookList> bookList = new ArrayList<BookList>();
	VBox middle;
	HBox topMid;
	TextField search;
	Button btnSearch;
	
	//right side
	VBox rightSide;
	Button btnReserve;
	Label image;
	Label title;
	Label author;
	Label description;
	Label isbn;
	Label pages;
	Label publisher;
	Label genre;
	Label noSel;
	
	@Override
	public void start(Stage primaryStage) {
		
		//set window title
		primaryStage.setTitle("openSrcBooks");
		
		//add left side
		sidebar = addSidebar();
		
		//add center
		search = new TextField();
		search.setPromptText("Search...");
		btnSearch = new Button("Go");
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				if((search.getText() != null && !search.getText().isEmpty())) {
					
					try {
						
						DBOperations DBOp = new DBOperations();
						bookList = DBOp.searchDB(search.getText());
					}catch(SQLException e1) {
						
						e1.printStackTrace();
					}
					
					ObservableList<BookList> obsList = FXCollections.observableList(bookList);
					listview.setItems(obsList);
				}
				else {
					
					search.setPromptText("Invalid search terms");
				}
			}
		});
		btnSearch.setMaxWidth(Double.MAX_VALUE);
		
		topMid = new HBox();
		topMid.getChildren().addAll(search, btnSearch);
		topMid.setSpacing(10);
		topMid.setPadding(new Insets(10, 0, 10, 0));
		
		listview = addListview();
		
		middle = new VBox();
		middle.getChildren().addAll(topMid, listview);
		middle.setSpacing(5);
		VBox.setVgrow(listview, Priority.ALWAYS);
		
		//add right side
		rightSide = new VBox();
		noSel = new Label("Select a book first!");
		rightSide.setPrefWidth(700);;
		rightSide.setAlignment(Pos.CENTER);
		rightSide.getChildren().add(noSel);
		rightSide.setSpacing(10);
		rightSide.setPadding(new Insets(10));
		
		root.setLeft(sidebar);
		root.setCenter(middle);
		root.setRight(rightSide);
		
		Scene scene = new Scene(root, 1280, 736);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	public VBox addSidebar() {
		
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(5);
		
		Text menu = new Text("Menu");
		vbox.getChildren().add(menu);
		
		Region empty = new Region();
		
		Button byTitle = new Button("Show by Title");
		byTitle.setMaxWidth(Double.MAX_VALUE);
		byTitle.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				try {
					
					DBOperations DBOp = new DBOperations();
					bookList = DBOp.getInfoByTitle();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				ObservableList<BookList> obsList = FXCollections.observableList(bookList);
				listview.setItems(obsList);
				middle.getChildren().setAll(topMid, listview);
			}
		});
		vbox.getChildren().add(byTitle);
		
		Button byAuthor = new Button("Show by Author");
		byAuthor.setMaxWidth(Double.MAX_VALUE);
		byAuthor.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				try {
					
					DBOperations DBOp = new DBOperations();
					bookList = DBOp.getInfoByAuthor();
				}
				catch (SQLException e2) {
					
					e2.printStackTrace();
				}
				
				ObservableList<BookList> obsList = FXCollections.observableList(bookList);
				listview.setItems(obsList);
				middle.getChildren().setAll(topMid, listview);
			}
		});
		vbox.getChildren().add(byAuthor);
		
		Button bySubject = new Button("Show by Subject");
		bySubject.setMaxWidth(Double.MAX_VALUE);
		bySubject.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				try {
					
					DBOperations DBOp = new DBOperations();
					bookList = DBOp.getInfoByGenre();
				}
				catch (SQLException e3) {
					
					e3.printStackTrace();
				}
				
				ObservableList<BookList> obsList = FXCollections.observableList(bookList);
				listview.setItems(obsList);
				middle.getChildren().setAll(topMid, listview);
			}
		});
		vbox.getChildren().add(bySubject);
		
		Separator sep = new Separator();
		vbox.getChildren().add(sep);
		
		Button qSimple1 = new Button("Simple Query 1");
		qSimple1.setMaxWidth(Double.MAX_VALUE);
		qSimple1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Text prompt = new Text("Get clients with more than 3 books reserved.");
				ListView<SQuery1> clistview = new ListView<SQuery1>();
				ArrayList<SQuery1> cList = new ArrayList<SQuery1>();
				
				try {
					
					DBOperations DBOp = new DBOperations();
					cList = DBOp.getGTThree();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				ObservableList<SQuery1> obsList = FXCollections.observableList(cList);
				clistview.setItems(obsList);
				middle.getChildren().setAll(prompt, clistview);
				middle.setAlignment(Pos.CENTER);
			}
		});
		vbox.getChildren().add(qSimple1);
		
		Button qSimple2 = new Button("Simple Query 2");
		qSimple2.setMaxWidth(Double.MAX_VALUE);
		qSimple2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Text prompt = new Text("Select all books with more than 300 pages");
				ListView<Books150> clistview = new ListView<Books150>();
				ArrayList<Books150> cList = new ArrayList<Books150>();
				
				try {
					
					DBOperations DBOp = new DBOperations();
					cList = DBOp.getGT150();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				ObservableList<Books150> obsList = FXCollections.observableList(cList);
				clistview.setItems(obsList);
				middle.getChildren().setAll(prompt, clistview);
				middle.setAlignment(Pos.CENTER);
			}
		});
		vbox.getChildren().add(qSimple2);
		
		Button qSimple3 = new Button("Simple Query 3");
		qSimple3.setMaxWidth(Double.MAX_VALUE);
		qSimple3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Text prompt = new Text("Get the number of books for each genre");
				ListView<SQuery3> clistview = new ListView<SQuery3>();
				ArrayList<SQuery3> cList = new ArrayList<SQuery3>();
				
				try {
					
					DBOperations DBOp = new DBOperations();
					cList = DBOp.getGenreNumbers();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				ObservableList<SQuery3> obsList = FXCollections.observableList(cList);
				clistview.setItems(obsList);
				middle.getChildren().setAll(prompt, clistview);
				middle.setAlignment(Pos.CENTER);
			}
		});
		vbox.getChildren().add(qSimple3);
		
		Button qSimple4 = new Button("Simple Query 4");
		qSimple4.setMaxWidth(Double.MAX_VALUE);
		qSimple4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Text prompt = new Text("Get all the authors' publishers");
				ListView<SQuery4> clistview = new ListView<SQuery4>();
				ArrayList<SQuery4> cList = new ArrayList<SQuery4>();
				
				try {
					
					DBOperations DBOp = new DBOperations();
					cList = DBOp.getAuthorPublisher();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				ObservableList<SQuery4> obsList = FXCollections.observableList(cList);
				clistview.setItems(obsList);
				middle.getChildren().setAll(prompt, clistview);
				middle.setAlignment(Pos.CENTER);
			}
		});
		vbox.getChildren().add(qSimple4);
		
		Button qSimple5 = new Button("Simple Query 5");
		qSimple5.setMaxWidth(Double.MAX_VALUE);
		qSimple5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Text prompt = new Text("Get authors with more than 1 book");
				ListView<SQuery5> clistview = new ListView<SQuery5>();
				ArrayList<SQuery5> cList = new ArrayList<SQuery5>();
				
				try {
					
					DBOperations DBOp = new DBOperations();
					cList = DBOp.getAuthorNumbers();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				ObservableList<SQuery5> obsList = FXCollections.observableList(cList);
				clistview.setItems(obsList);
				middle.getChildren().setAll(prompt, clistview);
				middle.setAlignment(Pos.CENTER);
			}
		});
		vbox.getChildren().add(qSimple5);
		
		Button qComplex1 = new Button("Complex Query 1");
		qComplex1.setMaxWidth(Double.MAX_VALUE);
		qComplex1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Text prompt = new Text("Get all clients with the same last name as the author of one of the books they have borrowed");
				ListView<CQuery1> clistview = new ListView<CQuery1>();
				ArrayList<CQuery1> cList = new ArrayList<CQuery1>();
				
				try {
					
					DBOperations DBOp = new DBOperations();
					cList = DBOp.getACName();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				ObservableList<CQuery1> obsList = FXCollections.observableList(cList);
				clistview.setItems(obsList);
				middle.getChildren().setAll(prompt, clistview);
				middle.setAlignment(Pos.CENTER);
			}
		});
		vbox.getChildren().add(qComplex1);
		
		Button qComplex2 = new Button("Complex Query 2");
		qComplex2.setMaxWidth(Double.MAX_VALUE);
		qComplex2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				ListView<CQuery2> clistview = new ListView<CQuery2>();
				TextField searchTL = new TextField();
				searchTL.setPromptText("Search...");
				Button btnSearchCQ = new Button("Go");
				btnSearchCQ.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent e1) {
						
						if((searchTL.getText() != null && !searchTL.getText().isEmpty())) {
							
							ArrayList<CQuery2> cList = new ArrayList<CQuery2>();
							
							try {
								
								DBOperations DBOp = new DBOperations();
								cList = DBOp.getAuthorCurr(searchTL.getText());
							}catch(SQLException e2) {
								
								e2.printStackTrace();
							}
							
							ObservableList<CQuery2> obsList = FXCollections.observableList(cList);
							clistview.setItems(obsList);
						}
						else {
							
							search.setPromptText("Invalid search terms");
						}
					}
				});
				btnSearchCQ.setMaxWidth(Double.MAX_VALUE);
				
				HBox topMidCQ = new HBox();
				topMidCQ.getChildren().addAll(searchTL, btnSearchCQ);
				topMidCQ.setSpacing(5);
				topMidCQ.setPadding(new Insets(10, 0, 10, 0));
				
				Text prompt = new Text("Get the authors of the books due on the selected date");
				
//				try {
//					
//					DBOperations DBOp = new DBOperations();
//					cList = DBOp.getAuthorCur();
//				}
//				catch (SQLException e1) {
//					
//					e1.printStackTrace();
//				}
//				
//				ObservableList<CQuery2> obsList = FXCollections.observableList(cList);
//				clistview.setItems(obsList);
				middle.getChildren().setAll(topMidCQ, prompt, clistview);
				middle.setAlignment(Pos.CENTER);
			}
		});
		vbox.getChildren().add(qComplex2);
		
		Button qComplex3 = new Button("Complex Query 3");
		qComplex3.setMaxWidth(Double.MAX_VALUE);
		qComplex3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Text prompt = new Text("Get all books with more than the average number of pages");
				ListView<CQuery3> clistview = new ListView<CQuery3>();
				ArrayList<CQuery3> cList = new ArrayList<CQuery3>();
				
				try {
					
					DBOperations DBOp = new DBOperations();
					cList = DBOp.getPagesAvg();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				ObservableList<CQuery3> obsList = FXCollections.observableList(cList);
				clistview.setItems(obsList);
				middle.getChildren().setAll(prompt, clistview);
				middle.setAlignment(Pos.CENTER);
			}
		});
		vbox.getChildren().add(qComplex3);
		
		Separator sep2 = new Separator();
		vbox.getChildren().add(sep2);
		
		Button exit = new Button("Exit");
		exit.setMaxWidth(Double.MAX_VALUE);
		exit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Platform.exit();
				System.exit(0);
			}
		});
		vbox.getChildren().add(exit);
		
		vbox.getChildren().add(empty);
		VBox.setVgrow(empty, Priority.ALWAYS);
		
		Button mngBooks = new Button("Manage Books");
		mngBooks.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Stage mngStage = new Stage();
				Scene mngScene = new Scene(new Manage(), 800, 600);
				
				mngStage.setTitle("Manage Books");
				mngStage.setScene(mngScene);
				mngStage.show();
			}
		});
		mngBooks.setMaxWidth(Double.MAX_VALUE);
		mngBooks.setAlignment(Pos.BOTTOM_CENTER);
		vbox.getChildren().add(mngBooks);
		
		vbox.setAlignment(Pos.TOP_CENTER);
		
		return vbox;
	}
	
	public ListView<BookList> addListview() {
		
		try {
			
			DBOperations DBOp = new DBOperations();
			bookList = DBOp.getInfo();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		ListView<BookList> list = new ListView<BookList>();
		ObservableList<BookList> obsList = FXCollections.observableList(bookList);
		
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookList>() {
			
			public void changed(ObservableValue<? extends BookList> observable, BookList oldValue, BookList newValue) {
				
				BookList selected;
				HBox bandTop = new HBox();
				HBox bandBot = new HBox();
				HBox bandBtn = new HBox();
				Region emptyTop = new Region();
				Region emptyBot = new Region();
				Region emptyBtn = new Region();
				
				if((selected = list.getSelectionModel().getSelectedItem()) != null) {
				
					image = new Label("Image should go here");
					title = new Label(selected.getTitle());
					author = new Label(selected.getA_fn() + " " + selected.getA_ln());
					
					genre = new Label(selected.getGenre());
					publisher = new Label(selected.getPublisher());
					bandTop.getChildren().addAll(genre, emptyTop, publisher);
					HBox.setHgrow(emptyTop, Priority.ALWAYS);
					genre.setAlignment(Pos.CENTER_LEFT);
					publisher.setAlignment(Pos.CENTER_RIGHT);
					
					description = new Label("description");
					
					isbn = new Label(selected.getIsbn());
					pages = new Label(Integer.toString(selected.getPages()));
					bandBot.getChildren().addAll(pages, emptyBot, isbn);
					HBox.setHgrow(emptyBot, Priority.ALWAYS);
					isbn.setAlignment(Pos.CENTER_LEFT);
					pages.setAlignment(Pos.CENTER_RIGHT);
					
					btnReserve = new Button("Get this book!");
					btnReserve.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent e) {
							
							Stage resStage = new Stage();
							Scene resScene = new Scene(new Reserve(selected.getIsbn()), 500, 300);
							
							resStage.setTitle("Reserve Book");
							resStage.setScene(resScene);
							resStage.show();
						}
					});
					bandBtn.getChildren().addAll(emptyBtn, btnReserve);
					HBox.setHgrow(emptyBtn, Priority.ALWAYS);
					bandBtn.setAlignment(Pos.CENTER_RIGHT);
					
					rightSide.getChildren().setAll(image, title, author, bandTop, description, bandBot, bandBtn);
				}
			}
		});
		
		list.setItems(obsList);
		list.setPrefWidth(200);
		
		return list;
	}
}