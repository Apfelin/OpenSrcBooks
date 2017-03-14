package pojo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SQuery1 extends VBox {
	
	Label clientL;
	
	String cfn;
	String cln;
	int bnr;
	
	public SQuery1(String first_name, String last_name, int count) {
		
		super();
		
		this.cfn = first_name;
		this.cln = last_name;
		this.bnr = count;
		
		clientL = new Label(first_name + " " + last_name + " - " + Integer.toString(count) + " books");
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(5);
		this.getChildren().add(clientL);
	}

	public String getCfn() {
		
		return cfn;
	}

	public void setCfn(String cfn) {
		
		this.cfn = cfn;
	}

	public String getCln() {
		
		return cln;
	}

	public void setCln(String cln) {
		
		this.cln = cln;
	}

	public int getBnr() {
		
		return bnr;
	}

	public void setBnr(int bnr) {
		
		this.bnr = bnr;
	}
}
