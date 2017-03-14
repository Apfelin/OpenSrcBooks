package pojo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CQuery3 extends VBox {

	Label titleL;
	Label authorL;
	Label pagesL;
	
	String title;
	String afn;
	String aln;
	int pages;
	
	public CQuery3(String title, int pages, String afn, String aln) {
		
		titleL = new Label(title);
		authorL = new Label(afn + " " + aln);
		pagesL = new Label("Pages: " + Integer.toString(pages));
		
		this.title = title;
		this.afn = afn;
		this.aln = aln;
		this.pages = pages;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(5);
		this.getChildren().addAll(titleL, authorL, pagesL);
	}
}
