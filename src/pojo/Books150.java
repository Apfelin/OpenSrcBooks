package pojo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Books150 extends VBox {

	Label titleL;
	Label authorL;
	Label pagesL;
	
	String title;
	String afn;
	String aln;
	int pages;
	
	public Books150(String title, String afn, String aln, int pages) {
		
		titleL = new Label(title);
		authorL = new Label(afn + " " + aln);
		pagesL = new Label(Integer.toString(pages) + " pages");
		
		this.title = title;
		this.afn = afn;
		this.aln = aln;
		this.pages = pages;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(5);
		this.getChildren().addAll(titleL, authorL, pagesL);
	}

	public String getTitle() {
		
		return title;
	}

	public void setTitle(String title) {
		
		this.title = title;
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

	public int getPages() {
		
		return pages;
	}

	public void setPages(int pages) {
		
		this.pages = pages;
	}

}
