package interfazAD;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.io.File;
import java.util.Map;

import javax.swing.*;

import com.itextpdf.text.Image;

import funcional.*;

public class AdminisP extends JFrame{
	
	Gestor gs;
	CursoAsignado csa;
	JLabel titulo, titulo1, titulo2, titulo3, titulo4, acum, notacu,
	nombre, descri, ponde, notas;
	JTable listado, actividad;
	JButton cargaA, t5mejor, t5peor, archivo, crear, refresh;
	JTextField nombret, descrit, pondet, notast;
	JFrame file, file2;
	
	public AdminisP(Gestor gs, CursoAsignado csa) {
		this.gs = gs;
		this.csa = csa;
		this.setTitle("ADMINISTRAR CURSO");
		this.setSize(1010,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
		
		titulo = new JLabel(csa.nC+ " " + "CÓDIGO: "+csa.cC);
		titulo.setBounds(65, 15, 315, 30);
		titulo.setFont(new Font("Serif", Font.ITALIC,30));
		Font font = titulo.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		add(titulo);
		
		titulo1 = new JLabel("Listado Oficial");
		titulo1.setBounds(45, 80, 130, 25);
		titulo1.setFont(new Font("Serif", Font.ITALIC,15));
		Font font1 = titulo1.getFont();
		Map attributes1 = font1.getAttributes();
		attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo1.setFont(font.deriveFont(attributes1));
		add(titulo1);
		
		cargaA = new JButton("Carga Masiva Alumnos");
		cargaA.setBounds(95, 395, 250, 30);
		add(cargaA);
		
		Object [][] fil = new Object [50][4];
		
		ActionListener cg= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				JFileChooser jf = new JFileChooser();
				jf.showOpenDialog(file);
				File archivoA = jf.getSelectedFile();
				if(jf.getSelectedFile()!=null) {
					if(archivoA!= null) {
						Gestor.getInstance().cargaAC(archivoA);
					}
					for(int i=0; i<50; i++) {
						if(Gestor.getInstance().getAlumcu()[i].cAl!=null && Gestor.getInstance().getAlumnos()[i].cA!=null) {
								fil[i][0] = Gestor.getInstance().codigoAC(Gestor.getInstance().getAlumcu()[i].cAl);
								fil[i][1] = Gestor.getInstance().nombreAC(Gestor.getInstance().getAlumcu()[i].cAl);
								fil[i][2] = Gestor.getInstance().apellidoAC(Gestor.getInstance().getAlumcu()[i].cAl);
						}
						
						System.out.println(Gestor.getInstance().codigoAC(Gestor.getInstance().getAlumcu()[i].cAl));
						System.out.println(Gestor.getInstance().nombreAC(Gestor.getInstance().getAlumcu()[i].cAl));
						System.out.println(Gestor.getInstance().apellidoAC(Gestor.getInstance().getAlumcu()[i].cAl));
					}
					
					refrescar();
				}
				}catch(Exception er) {
					System.out.println("Error: " +er);
				}
			}			
		};
		cargaA.addActionListener(cg);
		
		String[] col = {"Codigo", "Nombre", "Apellido", "Acciones"};
		listado = new JTable(fil, col);
		listado.setBounds(20,120,425,260);
		listado.getTableHeader().setReorderingAllowed(false);	
		JScrollPane sp = new JScrollPane(listado);
		sp.setBounds(20,120,425,260);
		add(sp);	
		
		refresh = new JButton();
		refresh.setBounds(795, 15, 55, 55);
		refresh.setOpaque(false);
		refresh.setBackground(new Color(0,0,0,0));
		add(refresh);
		refresh.setIcon(setIcono("/imagenes/icon.png", refresh));
		
		ActionListener eli = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					refrescar();
				}catch(Exception er) {
					System.out.println("Error: " +er);
				}
			}			
		};
		refresh.addActionListener(eli);
		
		titulo2 = new JLabel("Reportes");
		titulo2.setBounds(45, 460, 80, 25);
		titulo2.setFont(new Font("Serif", Font.ITALIC,15));
		Font font2 = titulo2.getFont();
		Map attributes2 = font2.getAttributes();
		attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo2.setFont(font.deriveFont(attributes2));
		add(titulo2);
		
		t5mejor = new JButton("Top 5 - Estudiantes con Mejor Rendimiento");
		t5mejor.setBounds(95, 500, 320, 30);
		add(t5mejor);
		
		t5peor = new JButton("Top 5 - Estudiantes con Peor Rendimiento");
		t5peor.setBounds(95, 550, 320, 30);
		add(t5peor);
		
		titulo3 = new JLabel("Actividades");
		titulo3.setBounds(550, 80, 80, 25);
		titulo3.setFont(new Font("Serif", Font.ITALIC,15));
		Font font3 = titulo3.getFont();
		Map attributes3 = font3.getAttributes();
		attributes3.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo3.setFont(font.deriveFont(attributes2));
		add(titulo3);
		
		crear = new JButton("Crear Actividad");
		crear.setBounds(560, 590, 320, 30);
		add(crear);
		
		nombret = new JTextField();
		nombret.setBounds(640, 440, 200, 25);
		add(nombret);

		descrit = new JTextField();
		descrit.setBounds(640, 475, 200, 25);
		add(descrit);
		
		pondet = new JTextField();
		pondet.setBounds(640, 510, 200, 25);
		add(pondet);
		
		Object [][] fil1 = new Object [15][4];
		
		ActionListener cre= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					for(int i=0; i<15; i++) {
						if(nombret.getText()!=null && descrit.getText()!=null && pondet.getText()!=null) {
								fil1[i][0] = nombret.getText();
								fil1[i][1] = descrit.getText();
								fil1[i][2] = pondet.getText();
						}
					}
					
					refrescar();
				}
						
		};
		crear.addActionListener(cre);
		
		String[] col1 = {"Nombre", "Descripción", "Ponderación", "Promedio"};
		actividad = new JTable(fil1, col1);
		actividad.setBounds(520,120,425,198);
		actividad.getTableHeader().setReorderingAllowed(false);	
		JScrollPane sp1 = new JScrollPane(actividad);
		sp1.setBounds(520,120,425,198);
		add(sp1);
		
		acum = new JLabel("Acumulado:");
		acum.setBounds(600, 330, 80, 25);
		acum.setFont(new Font("Serif", Font.ITALIC,13));
		Font font4 = acum.getFont();
		Map attributes4 = font4.getAttributes();
		attributes4.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		acum.setFont(font.deriveFont(attributes4));
		add(acum);
		
		notacu = new JLabel("100/100");
		notacu.setBounds(700, 330, 80, 25);
		add(notacu);
		
		titulo4 = new JLabel("Crear Actividad");
		titulo4.setBounds(550, 390, 120, 25);
		titulo4.setFont(new Font("Serif", Font.ITALIC,15));
		Font font5 = titulo3.getFont();
		Map attributes5 = font5.getAttributes();
		attributes5.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo4.setFont(font.deriveFont(attributes5));
		add(titulo4);
		
		nombre = new JLabel("Nombre");
		nombre.setBounds(530, 440, 80, 25);
		add(nombre);	
		
		descri = new JLabel("Descripción");
		descri.setBounds(530, 475, 80, 25);
		add(descri);
			
		ponde = new JLabel("Ponderación");
		ponde.setBounds(530, 510, 80, 25);
		add(ponde);
		
		notas = new JLabel("Notas");
		notas.setBounds(530, 545, 80 ,25);
		add(notas);
		
		archivo = new JButton("Seleccionar archivo CSV");
		archivo.setBounds(640, 545, 200, 25);
		add(archivo);
		
		ActionListener ar= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jf = new JFileChooser();
					jf.showOpenDialog(file);
					File archivoA = jf.getSelectedFile();
					if(jf.getSelectedFile()!=null) {
						if(archivoA!= null) {
							Gestor.getInstance().cargaN(archivoA);;
						}
						
					}	
				}catch(Exception ev) {
					System.out.println("Error al cargar: "+ev);
				}
				
			}		
		};
		archivo.addActionListener(ar);
		

		
		
		
		this.setVisible(true);
	}
	
	public void refrescar() {
		this.paintAll(getGraphics());
	}

	public Icon setIcono(String url, JButton boton) {
		ImageIcon icon = new ImageIcon(getClass().getResource(url));
		int ac = refresh.getWidth();
		int al = refresh.getHeight();
		
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ac, al, Image.ALIGN_JUSTIFIED_ALL));
		
		return icono;
	}
}
