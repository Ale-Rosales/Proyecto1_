package funcional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


public class Gestor implements Serializable{	
	private Admin usuarios[];
	private Profesor profesores[];
	private Curso cursos[];
	private Alumno alumnos[];
	private CursoAsignado cursoag[];
	private AlumnosCurso alumcu[];
	private Notas nota[];
	
	public Gestor() {
		this.usuarios= new Admin[1];
		this.profesores= new Profesor[50];
		this.alumnos= new Alumno[300];
		this.cursos= new Curso[50];	
		
		
		this.alumcu= new AlumnosCurso[50];
		this.cursoag= new CursoAsignado[50];
		this.nota = new Notas[50];
	}
	
	static Gestor instanciaUnica = null;
	
	public static Gestor getInstance() {
		if(instanciaUnica == null) {
			instanciaUnica = new Gestor();
		}
		return instanciaUnica;
	}
	
	public Profesor[] getProfesores() {
		return profesores;
	}


	public void setProfesores(Profesor[] profesores) {
		this.profesores = profesores;
	}


	public Curso[] getCursos() {
		return cursos;
	}


	public void setCursos(Curso[] cursos) {
		this.cursos = cursos;
	}


	public Alumno[] getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}


	public CursoAsignado[] getCursoag() {
		return cursoag;
	}


	public void setCursoag(CursoAsignado[] cursoag) {
		this.cursoag = cursoag;
	}


	public AlumnosCurso[] getAlumcu() {
		return alumcu;
	}


	public void setAlumcu(AlumnosCurso[] alumcu) {
		this.alumcu = alumcu;
	}
	
	public Notas[] getNota() {
		return nota;
	}

	public void setNota(Notas[] nota) {
		this.nota = nota;
	}
	
	
	/*public void cargamasiva() {
		try {
			File file = new File("usuarios.json");
			Scanner sc = new Scanner(file);
			String data ="";
			while(sc.hasNextLine()) {
				data+= sc.nextLine()+"\n";
			}
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(data);
			JSONArray array = (JSONArray)obj;
			JSONObject jobj;
			for(int i=0; i<array.size(); i++) {
				jobj = (JSONObject)array.get(i);
				this.insertar(jobj.get("usuario").toString(), jobj.get("password").toString());
			}

			sc.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error: "+e,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public void imprimir() {
		for(Admin u:this.usuarios) {
			if(u!=null) {
				System.out.println("Usuario: "+u.codigo+ " Password: "+u.password);
			}
		}
	}*/
	
	public boolean existe(String usuario) {
		for(Admin u:usuarios) {
			if(u!=null && u.codigo.equals(usuario))
				return true;
		}
		return false;
	}

	public boolean insertar(String codigo, String password) {
		if(existe(codigo))return false;
		
		for(int i=0; i<usuarios.length; i++) {
			if(usuarios[i]==null) {
				usuarios[i] = new Admin(codigo, password);
				return true;
			}
		}
		return false;
	}
	
	/*public Admin getUsuario(String codigo) {
		for(Admin u:this.usuarios) {
			if(u!=null && u.codigo.equals(codigo))return u;
		}
		return null;
	}*/
	
	
	//=====================================================================PROFESORES====================================================================
	public void cargamasivaP(File fileP) {
		try {
			//File file = new File("profesores.json");
			Scanner sc = new Scanner(fileP);
			String data ="";
			while(sc.hasNextLine()) {
				data+= sc.nextLine()+"\n";
			}
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(data);
			JSONArray array = (JSONArray)obj;
			JSONObject jobj;
			for(int i=0; i<array.size(); i++) {
				jobj = (JSONObject)array.get(i);
				this.insertarP(jobj.get("codigo").toString(), jobj.get("nombre").toString(), 
						jobj.get("apellido").toString(), jobj.get("correo").toString(), 
						jobj.get("genero").toString());
			}

			sc.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error: "+e,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean existeP(String cP) {
		for(Profesor pf:profesores) {
			if(pf!=null && pf.cP.equals(cP))
				return true;
		}
		return false;
	}
	
	public Profesor getcP(String cP) {
		for(Profesor pf:this.profesores) {
			if(pf!=null && pf.cP.equals(cP))return pf;
		}
		return null;
	}

	public boolean insertarP(String cP, String nP, String aP, String coP, String gP) {
		if(existeP(cP))return false;
		
		for(int i=0; i<profesores.length; i++) {
			if(profesores[i]==null) {
				profesores[i] = new Profesor(cP, nP, aP, coP, gP);
				return true;
			}
		}
		return false;
	}

	public void imprimirP() {
		for(Profesor pf:this.profesores) {
			if(pf!=null) {
				System.out.println("Codigo: "+pf.cP+ " Nombre: "+pf.nP+" Apellido: "+pf.aP+"\n"
						+"Correo: "+pf.coP+" Genero: "+pf.gP+"\n");
			}
		}
	}
	
		
	//=====================================================================ALUMNOS====================================================================
	public void cargamasivaA(File fileA) {
		try {
			//File file = new File("alumnos.json");
			Scanner sc = new Scanner(fileA);
			String data ="";
			while(sc.hasNextLine()) {
				data+= sc.nextLine()+"\n";
			}
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(data);
			JSONArray array = (JSONArray)obj;
			JSONObject jobj;
			for(int i=0; i<array.size(); i++) {
				jobj = (JSONObject)array.get(i);
				this.insertarA(jobj.get("codigo").toString(), jobj.get("nombre").toString(), 
						jobj.get("apellido").toString(), jobj.get("correo").toString(), 
						jobj.get("genero").toString());
			}

			sc.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error: "+e,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean existeA(String cA) {
		for(Alumno al:alumnos) {
			if(al!=null && al.cA.equals(cA))
				return true;
		}
		return false;
	}
	
	public boolean insertarA(String cA, String nA, String aA, String coA, String gA) {
		if(existeA(cA))return false;
		
		for(int i=0; i<alumnos.length; i++) {
			if(alumnos[i]==null) {
				alumnos[i] = new Alumno(cA, nA, aA, coA, gA);
				return true;
			}
		}
		return false;
	}
	
	public Alumno getcA(String cA) {
		for(Alumno al:this.alumnos) {
			if(al!=null && al.cA.equals(cA))return al;
		}
		return null;
	}
	
	public void imprimirA() {
		for(Alumno al:this.alumnos) {
			if(al!=null) {
				System.out.println("Codigo: "+al.cA+ " Nombre: "+al.nA+" Apellido: "+al.aA+"\n"
						+"Correo: "+al.coA+" Genero: "+al.gA+"\n");
			}
		}
	}
	
	
	//=====================================================================CURSOS====================================================================
	public void cargamasivaC(File fileC) {
		try {
			//File file = new File("cursos.json");
			Scanner sc = new Scanner(fileC);
			String data ="";
			while(sc.hasNextLine()) {
				data+= sc.nextLine()+"\n";
			}
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(data);
			JSONArray array = (JSONArray)obj;
			JSONObject jobj;
			for(int i=0; i<array.size(); i++) {
				jobj = (JSONObject)array.get(i);
				this.insertarC(jobj.get("codigo").toString(), jobj.get("nombre").toString(), 
						Integer.valueOf(jobj.get("creditos").toString()), jobj.get("profesor").toString());
			}
			
			sc.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error: "+e,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean existeC(String cC) {
		for(Curso cs:cursos) {
			if(cs!=null && cs.cC.equals(cC))
				return true;
		}
		return false;
	}
	
	public Curso getcC(String cC) {
		for(Curso cs:this.cursos) {
			if(cs!=null && cs.cC.equals(cC))return cs;
		}
		return null;
	}

	public boolean insertarC(String cC, String nC, int ncC, String pC) {
		if(existeC(cC))return false;
		
		for(int i=0; i<cursos.length; i++) {
			if(cursos[i]==null) {
				cursos[i] = new Curso(cC, nC, ncC, pC);
				return true;
			}
		}
		return false;
	}

	public void imprimirC() {
		for(Curso cs:this.cursos) {
			if(cs!=null) {
				System.out.println("Codigo: "+cs.cC+ " Nombre: "+cs.nC+" Creditos: "+cs.ncC+"\n"
						+"Profesor: "+cs.pC+"\n");
			}
		}
	}
	
	
	//=====================================================================INCIOS DE SESION====================================================================
	public boolean iniciar(String codigo, String password) {
		for(Admin u:this.usuarios) {
			if(u!=null && u.codigo.equals(codigo) && u.password.equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean iniciarP(String codigo, String password) {
		for(Profesor pro:this.profesores) {
			if(pro!=null && pro.cP.equals(codigo) && pro.getPassP().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean iniciarA(String codigo, String password) {
		for(Alumno alum:this.alumnos) {
			if(alum!=null && alum.cA.equals(codigo) && alum.getPassA().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	
	//=====================================================================ELIMINAR DATOS====================================================================
	public void eliminarP(String nombre) {
		for(int i=0; i<profesores.length; i++) {
			if(profesores[i]!=null && profesores[i].nP.equals(nombre)) {
				profesores[i]=null;	
				correrP(i);					
				return;
			}
			
		}
	}
	
	int tp = 50;
	private void correrP(int ps) {
		for(int i=ps; i<tp-1; i++) {
			profesores[i] = profesores[i+1];
		}
		tp --;
	}
	
	public void eliminarC(String nombre) {
		for(int i=0; i<cursos.length; i++) {
			if(cursos[i]!=null && cursos[i].nC.equals(nombre)) {
				cursos[i]=null;
				correrC(i);
				return;
			}
		}
	}
	
	int tc = 50;
	private void correrC(int ps) {
		for(int i=ps; i<tc-1; i++) {		
			cursos[i] = cursos[i+1];
		}
		tc --;
	}
	
	
	//=====================================================================ACTUALIZAR DATOS====================================================================
	public boolean modificarP(String cP, String nP, String aP, String coP, String gP,String passP) {
		//if(existeP(cP))return false;	
		for(int i=0; i<profesores.length; i++) {
			if(this.profesores[i]!=null) {
				this.profesores[i].modificarP(cP, nP, aP, coP, gP, passP);
				return true;
			}
		}
	return false;
	}
	
	public boolean modificarC(String cC, String nC, int ncC, String pC) {
		//if(existeC(cC))return false;
		for(int i=0; i<cursos.length; i++) {
			if(this.cursos[i]!=null) {
				this.cursos[i].modificarC(cC, nC, ncC, pC);
				return true;
			}
		}
	return false;
	}
	
	public boolean modificarA(String cA, String nA, String aA, String coA, String gA, String passA) {
		
		for(int i=0; i<alumnos.length; i++) {
			if(this.alumnos[i]!=null) {
				this.alumnos[i].modificarA(cA, nA, aA, coA, gA, passA);
				return true;
			}
		}
	return false;
	}
	
	
	//=====================================================================NOMBRE PROFESOR====================================================================
	public String nombreCP(String pC) {
		for(int i=0; i<profesores.length; i++) {
			if(cursos[i]!=null && profesores[i]!=null && profesores[i].cP.equals(pC)) {
				return profesores[i].nP+ " " +profesores[i].aP;
			}
		}
		return null;
	}
	
	
	//=====================================================================CURSO ASIGNADO====================================================================
	public void getcC2(String cP) {
		for(Curso cs:this.cursos) {
				if(cs!=null && cs.pC.equals(cP)) {
					this.insertarCA(cs.cC, cs.nC, cs.ncC);
				}
		}
	}
	
	public void imprimirCA() {
		for(CursoAsignado ca:this.cursoag) {
			if(ca!=null) {
				System.out.println(ca.cC+" "+ca.nC+" "+ca.ncC);
			}
		}
	}
	
	public boolean insertarCA(String cC, String nC, int ncC) {
		for(int i=0; i<cursoag.length; i++) {
			if(cursoag[i]==null) {
				cursoag[i] = new CursoAsignado(cC, nC, ncC);
				return true;
			}
		}
		return false;
	}
	
	
	public CursoAsignado getAC(String cC) {
		for(CursoAsignado csa:this.cursoag) {
			if(csa!=null && csa.cC.equals(cC))return csa;
		}
		return null;
	}
	
	
	//=====================================================================CURSO ALUMNOS====================================================================
	public void cargaAC(File fileP) {
		try {
			//File file = new File("profesores.json");
			Scanner sc = new Scanner(fileP);
			String data ="";
			while(sc.hasNextLine()) {
				data+= sc.nextLine()+"\n";
			}
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(data);
			JSONArray array = (JSONArray)obj;
			JSONObject jobj;
			for(int i=0; i<array.size(); i++) {
				jobj = (JSONObject)array.get(i);
				this.insertarAing(jobj.get("codigo").toString());
			}

			sc.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error: "+e,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean existeAin(String cA) {
		for(AlumnosCurso cuas:alumcu) {
			if(cuas!=null && cuas.cAl.equals(cA))
				return true;
		}
		return false;
	}
	
	public boolean insertarAing(String cA) {
		for(int i=0; i<alumcu.length; i++) {
			if(alumcu[i]==null) {
				alumcu[i] = new AlumnosCurso(cA);
				return true;
			}
		}
		return false;
	}
	
	public void imprimirAC() {
		for(AlumnosCurso cs:this.alumcu) {
			if(cs!=null) {
				System.out.println("Codigo: "+cs.cAl);
			}
		}
	}
	
	public String codigoAC(String cAl) {
		//if(existeAin(cAl))return null;
		for(int i=0; i<300; i++) {
			if(alumcu[i]!=null && alumnos[i]!=null && alumnos[i].cA.equals(cAl)) {
				return alumnos[i].cA;
			}
		}
		return null;
	}
	
	public String nombreAC(String cAl) {
		//if(existeAin(cAl))return null;
		for(int i=0; i<300; i++) {
			if(alumcu[i]!=null && alumnos[i]!=null &&  alumnos[i].cA.equals(cAl)) {
				return alumnos[i].nA;
			}
		}
		return null;	
	}	
	
	public String apellidoAC(String cAl) {
		//if(existeAin(cAl))return null;
		for(int i=0; i<300; i++) {
			if(alumcu[i]!=null && alumnos[i]!=null &&  alumnos[i].cA.equals(cAl)) {
				return alumnos[i].aA;
			}
		}
		return null;
	}
	
	
	//=====================================================================SERIALIZAR / DESERIALIZAR====================================================================
	public void SeriaProfe(Object obj) {
		try {
			FileOutputStream archivo = new FileOutputStream("profesores");
			ObjectOutputStream profea = new ObjectOutputStream(archivo);
			profea.writeObject(obj);
			profea.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void DeseriaProfe(Gestor gs) {
		try {
			FileInputStream archivo1 = new FileInputStream("profesores");
			ObjectInputStream profes = new ObjectInputStream(archivo1);
			gs.setProfesores((Profesor[])profes.readObject());
			profes.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void SeriaCurso(Object obj) {
		try {
			FileOutputStream archivo = new FileOutputStream("cursos");
			ObjectOutputStream profea = new ObjectOutputStream(archivo);
			profea.writeObject(obj);
			profea.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void DeseriaCurso(Gestor gs) {
		try {
			FileInputStream archivo1 = new FileInputStream("cursos");
			ObjectInputStream profes = new ObjectInputStream(archivo1);
			gs.setCursos((Curso[])profes.readObject());
			profes.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void SeriaAlumno(Object obj) {
		try {
			FileOutputStream archivo = new FileOutputStream("alumnos");
			ObjectOutputStream profea = new ObjectOutputStream(archivo);
			profea.writeObject(obj);
			profea.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void DeseriaAlumno(Gestor gs) {
		try {
			FileInputStream archivo1 = new FileInputStream("alumnos");
			ObjectInputStream profes = new ObjectInputStream(archivo1);
			gs.setAlumnos((Alumno[])profes.readObject());
			profes.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void SeriaCursoAsig(Object obj) {
		try {
			FileOutputStream archivo = new FileOutputStream("cursosasignados");
			ObjectOutputStream profea = new ObjectOutputStream(archivo);
			profea.writeObject(obj);
			profea.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void DeseriaCursoAsig(Gestor gs) {
		try {
			FileInputStream archivo1 = new FileInputStream("cursosasignados");
			ObjectInputStream profes = new ObjectInputStream(archivo1);
			gs.setCursoag((CursoAsignado[])profes.readObject());
			profes.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void SeriaAlumnoAsig(Object obj) {
		try {
			FileOutputStream archivo = new FileOutputStream("alumnoasignados");
			ObjectOutputStream profea = new ObjectOutputStream(archivo);
			profea.writeObject(obj);
			profea.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void DeseriaAlumnoAsig(Gestor gs) {
		try {
			FileInputStream archivo1 = new FileInputStream("alumnoasignados");
			ObjectInputStream profes = new ObjectInputStream(archivo1);
			gs.setAlumcu((AlumnosCurso[])profes.readObject());
			profes.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void SeriaNotas(Object obj) {
		try {
			FileOutputStream archivo = new FileOutputStream("notas");
			ObjectOutputStream profea = new ObjectOutputStream(archivo);
			profea.writeObject(obj);
			profea.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void DeseriaNotas(Gestor gs) {
		try {
			FileInputStream archivo1 = new FileInputStream("notas");
			ObjectInputStream profes = new ObjectInputStream(archivo1);
			gs.setNota((Notas[])profes.readObject());
			profes.close();
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Proceso incompleto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	//=====================================================================CARGAR NOTAS====================================================================
	public void cargaN(File archivo) {
		try {

				Scanner reader = new Scanner(archivo);
				String []psac;
				reader.nextLine();
				Notas nota;
				while(reader.hasNextLine()) {
					psac= reader.nextLine().split(",");
					nota= new Notas(Integer.parseInt(psac[0]), Double.parseDouble(psac[1]));					
					if(!this.insertarN(nota)){
						System.out.println("No hay mas notas");
					}
				}
				
				System.out.println("Se cargaron correctamente.");
				
				reader.close();
		}catch(Exception e) {
				System.out.println("Error al cargar archivo: "+e);
			}
	}
	
	public boolean insertarN(Notas nota) {
		for(int i=0; i<50;i++) {
			if(this.nota[i]==null) {
				this.nota[i]= nota;
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
}
