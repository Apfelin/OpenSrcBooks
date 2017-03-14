package pojo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SQuery3 extends VBox {

	Label numbersL;
	
	String name;
	int count;
	
	public SQuery3(String name, int count) {
		
		numbersL = new Label(name + " - " + count + " books");
		
		this.name = name;
		this.count = count;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(5);
		this.getChildren().addAll(numbersL);
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public int getCount() {
		
		return count;
	}

	public void setCount(int count) {
		
		this.count = count;
	}
}
