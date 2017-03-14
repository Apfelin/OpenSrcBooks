package pojo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CQuery1 extends VBox {

	Label namesL;
	
	String cfn;
	String cln;
	String afn;
	String aln;
	
	public CQuery1(String cfn, String cln, String afn, String aln) {
		
		namesL = new Label(cfn + " " + cln + " - " + afn + " " + aln);
		
		this.cfn = cfn;
		this.cln = cln;
		this.afn = afn;
		this.aln = aln;
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(5);
		this.getChildren().addAll(namesL);
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
