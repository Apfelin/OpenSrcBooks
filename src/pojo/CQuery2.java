package pojo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CQuery2 extends VBox {
	
	Label authorL;
	
	String afn;
	String aln;
	
	public CQuery2(String afn, String aln) {
		
		authorL = new Label(afn + " " + aln);
		
		this.afn = afn;
		this.aln = aln;
		
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
}
