package funcional;

import java.io.Serializable;

public class Notas implements Serializable{
	
	public int cA;
	public double nota;
	
	public Notas(int cA, double nota){
		this.cA = cA;
		this.nota = nota;
	}

}
