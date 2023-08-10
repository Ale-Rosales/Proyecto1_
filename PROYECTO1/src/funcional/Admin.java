package funcional;

import java.io.Serializable;

public class Admin implements Serializable{
	
	public String codigo;
	public String password;
	
	public Admin(String codigo, String password) {
		this.codigo = codigo;
		this.password = password;
	}

}
