package pojo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SQuery5 extends VBox {
	
	Label authorL;
	
	String afn;
	String aln;
	int numbers;
	
	public SQuery5(String afn, String aln, int numbers) {
		
		authorL = new Label(afn + " " + aln + " - " + Integer.toString(numbers) + " books");
		
		this.afn = afn;
		this.aln = aln;
		this.numbers = numbers;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(5);
		this.getChildren().addAll(authorL);
	}

	public String getAfn() {
		
		return afn;
	}

	public void setAfn(String afn) {
		
		this.afn = afn;
	}

	public String getAln() {
		
		return aln;
	}

	public void setAln(String aln) {
		
		this.aln = aln;
	}

	public int getNumbers() {
		
		return numbers;
	}

	public void setNumbers(int numbers) {
		
		this.numbers = numbers;
	}
}
