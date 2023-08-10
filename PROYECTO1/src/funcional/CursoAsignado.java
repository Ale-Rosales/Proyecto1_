package funcional;

import java.io.Serializable;

public class CursoAsignado implements Serializable{
	
	public String cC;
	public String nC;
	public int ncC;
	public String pC;

	public String cAlum;
	
	public CursoAsignado(String cC, String nC, int ncC) {
		this.cC = cC;
		this.nC = nC;
		this.ncC = ncC;
	}

	public CursoAsignado(String cC, String nC, int ncC, String cAlum) {
		this.cC = cC;
		this.nC = nC;
		this.ncC = ncC;
		this.cAlum = cAlum;
	}
	
	public CursoAsignado(String cAlum) {
		this.cAlum = cAlum;
	}
	
	
}
