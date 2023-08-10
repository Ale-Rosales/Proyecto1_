package funcional;

import java.io.Serializable;

public class Curso implements Serializable{
	public String cC;
	public String nC;
	public int ncC;
	public String pC;
	
	public int nAA;
	
	public Curso(String cC, String nC, int ncC, String pC) {
		this.cC = cC;
		this.nC = nC;
		this.ncC = ncC;
		this.pC = pC;
	}
	
	public void modificarC(String cC, String nC, int ncC, String pC) {
		this.cC = cC;
		this.nC = nC;
		this.ncC = ncC;
		this.pC = pC;
	}
	

}
