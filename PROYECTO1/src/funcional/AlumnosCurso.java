package funcional;

import java.io.Serializable;

public class AlumnosCurso implements Serializable{
	
	public String cAl;
	
	public String nomA;
	public String apeA;
	
	public String nC;
	public String cC;
	
	public AlumnosCurso(String cA) {
		this.cAl = cA;
	}
	
	public AlumnosCurso(String cAl, String nomA, String apeA) {
		this.cAl = cAl;
		this.nomA = nomA;
		this.apeA = apeA;
	}
	
	public void datosA(String cAl, String nomA, String apeA) {
		this.cAl = cAl;
		this.nomA = nomA;
		this.apeA = apeA;
	}
	
	public void asignar1(String cAl, String nomA, String apeA) {
		this.cAl = cAl;
		this.nomA = nomA;
		this.apeA = apeA;
	}
	
	
	public void asignar2(String cAl, String nomA, String apeA, String nC, String cC) {
		this.cAl = cAl;
		this.nomA = nomA;
		this.apeA = apeA;
		this.nC = nC;
		this.cC = cC;
	}
	
}
