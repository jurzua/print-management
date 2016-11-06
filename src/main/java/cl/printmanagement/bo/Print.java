package cl.printmanagement.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Print")
public class Print extends DBEntry implements Serializable{
	private static final long serialVersionUID = 6144659416545771751L;
	
	@Column(name = "document")
	private String document;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "printer")
	private String printer;
	
	@Column(name = "computer")
	private String computer;
	
	@Column(name = "numeroHojas")
	private String numeroHojas;

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPrinter() {
		return printer;
	}

	public void setPrinter(String printer) {
		this.printer = printer;
	}

	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}
	
	public String getNumeroHojas() {
		return numeroHojas;
	}

	public void setNumeroHojas(String numeroHojas) {
		this.computer = numeroHojas;
	}
	
	@Override
	public String toString(){
		return "Print [userName="+ userName +", computer="+ computer +", printer="+ printer +", document=" +document+ "]";
	}
}
