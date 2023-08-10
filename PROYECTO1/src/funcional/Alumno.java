package funcional;

import java.io.Serializable;

public class Alumno implements Serializable{
	public String cA;
	public String nA;
	public String aA;
	public String coA;
	public String gA;
	
	private String passA = "1234";
	
	public Alumno(String cA, String nA, String aA, String coA, String gA) {
		this.cA = cA;
		this.nA = nA;
		this.aA = aA;
		this.coA = coA;
		this.gA = gA;
	}

	public String getPassA() {
		return passA;
	}

	public void setPassA(String passA) {
		this.passA = passA;
	}
	
	public Alumno(String cA, String nA, String aA, String coA, String gA, String passA) {
		this.cA = cA;
		this.nA = nA;
		this.aA = aA;
		this.coA = coA;
		this.gA = gA;
		this.setPassA(passA);
	}
	
	public void modificarA(String cA, String nA, String aA, String coA, String gA, String passA) {
		this.cA = cA;
		this.nA = nA;
		this.aA = aA;
		this.coA = coA;
		this.gA = gA;
		this.setPassA(passA);
	}
	

}
