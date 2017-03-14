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

public class Reserve extends GridPane {
	
	Text confirmText;
	
	Reserve(String isbnRec) {
		
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(5);
		this.setPadding(new Insets(25));
		
		Text prompt = new Text("Reserve a book");
		GridPane.setHalignment(prompt, HPos.CENTER);
		this.add(prompt, 0, 0, 5, 1);
		
		Text prompt2 = new Text("Please fill in your info");
		GridPane.setHalignment(prompt2, HPos.CENTER);
		this.add(prompt2, 0, 1, 5, 1);
		
		Label firstName = new Label("First Name: ");
		TextField firstNameField = new TextField();
		this.add(firstName, 0, 2);
		this.add(firstNameField, 1, 2);
		
		Label lastName = new Label("Last Name: ");
		TextField lastNameField = new TextField();
		this.add(lastName, 3, 2);
		this.add(lastNameField, 4, 2);
		
		Label cnp = new Label("CNP: ");
		TextField cnpField = new TextField();
		HBox cnpH = new HBox();
		cnpH.getChildren().addAll(cnp, cnpField);
		cnpH.setAlignment(Pos.CENTER);
		this.add(cnpH, 0, 3, 5, 1);
		
		Label address = new Label("Address: ");
		TextField addressField = new TextField();
		HBox addressH = new HBox();
		addressH.getChildren().addAll(address, addressField);
		addressH.setAlignment(Pos.CENTER);
		this.add(addressH, 0, 4, 5, 1);
		
		Label city = new Label("City: ");
		TextField cityField = new TextField();
		HBox cityH = new HBox();
		cityH.getChildren().addAll(city, cityField);
		cityH.setAlignment(Pos.CENTER);
		this.add(cityH, 0, 5, 5, 1);
		
		Label phone = new Label("Phone: ");
		TextField phoneField = new TextField();
		HBox phoneH = new HBox();
		phoneH.getChildren().addAll(phone, phoneField);
		phoneH.setAlignment(Pos.CENTER);
		this.add(phoneH, 0, 6, 5, 1);
		
		Button cancel = new Button("Cancel");
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				((Node)(e.getSource())).getScene().getWindow().hide();
			}
		});
		GridPane.setHalignment(cancel, HPos.CENTER);
		this.add(cancel, 0, 8, 2, 1);
		
		Button confirm = new Button("Confirm");
		confirm.setOnAction(new EventHandler<ActionEvent> () {
			
			@Override
			public void handle(ActionEvent e) {
				
				if((firstNameField.getText() != null && !firstNameField.getText().isEmpty()) &&
						(lastNameField.getText() != null && !lastNameField.getText().isEmpty()) &&
						(cnpField.getText() != null && !cnpField.getText().isEmpty()) &&
						(addressField.getText() != null && !addressField.getText().isEmpty()) &&
						(cityField.getText() != null && !cityField.getText().isEmpty()) &&
						(phoneField.getText() != null && !phoneField.getText().isEmpty())) {
					
					try {
						
						DBOperations DBOp = new DBOperations();
						DBOp.bookReserved(firstNameField.getText(), lastNameField.getText(), cnpField.getText(), addressField.getText(), cityField.getText(), phoneField.getText(), isbnRec);
					}catch(SQLException e1) {
						
						e1.printStackTrace();
					}
					
					confirmText.setText("You have succesfully reserved this book!");
					}
					else {
						
						confirmText.setText("Please fill in all the fields!");
					}
			}
		});
		GridPane.setHalignment(confirm, HPos.CENTER);
		this.add(confirm, 4, 8, 2, 1);
		
		confirmText = new Text(" ");
		GridPane.setHalignment(confirmText, HPos.CENTER);
		this.add(confirmText, 3, 9, 2, 1);
	}
}
