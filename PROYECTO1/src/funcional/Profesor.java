package funcional;

import java.io.Serializable;

public class Profesor implements Serializable{
	public String cP;
	public String nP;
	public String aP;
	public String coP;
	public String gP;

	private String passP = "1234";
	
	public Profesor(String cP, String nP, String aP, String coP, String gP) {
		this.cP = cP;
		this.nP = nP;
		this.aP = aP;
		this.coP = coP;
		this.gP = gP;
	}

	public String getPassP() {
		return passP;
	}

	public void setPassP(String passP) {
		this.passP = passP;
	}
	
	public Profesor(String cP, String nP, String aP, String coP, String gP, String passP) {
		this.cP = cP;
		this.nP = nP;
		this.aP = aP;
		this.coP = coP;
		this.gP = gP;
		this.setPassP(passP);
	}
	
	public void  modificarP(String cP, String nP, String aP, String coP, String gP, String passP) {
		this.cP = cP;
		this.nP = nP;
		this.aP = aP;
		this.coP = coP;
		this.gP = gP;
		this.setPassP(passP);
	}

	
}
