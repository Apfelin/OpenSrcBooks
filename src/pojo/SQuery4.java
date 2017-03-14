package pojo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SQuery4 extends VBox {
	
	Label authorL;
	Label publisherL;
	
	String afn;
	String aln;
	String publisher;
	
	public SQuery4(String afn, String aln, String publisher) {
		
		authorL = new Label(afn + " " + aln);
		publisherL = new Label(publisher);
		
		this.afn = afn;
		this.aln = aln;
		this.publisher = publisher;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(5);
		this.getChildren().addAll(authorL, publisherL);
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

	public String getPublisher() {
		
		return publisher;
	}

	public void setPublisher(String publisher) {
		
		this.publisher = publisher;
	}
}
