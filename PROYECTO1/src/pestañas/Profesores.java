package pestañas;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.*;
import org.jfree.data.general.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import funcional.*;
import interfaz.*;
import login.Login;

public class Profesores extends JPanel{
	
	JButton crearP, cargaP, actualizarP, eliminarP, exportarP, recaP;
	JLabel tablaP;
	JTable listadoP;
	DefaultTableModel modeloP;
	JFrame file;
	Gestor gs;
	
	
	public Profesores(Gestor gs) {
		this.gs = gs;
		this.setLayout(null);
		this.setBackground(Color.ORANGE);
		
		tablaP = new JLabel("Listado Oficial");
		tablaP.setBounds(45, 15, 130, 25);
		tablaP.setFont(new Font("Serif", Font.ITALIC,20));
		Font font = tablaP.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		tablaP.setFont(font.deriveFont(attributes));
		add(tablaP);
		
		crearP = new JButton("Crear");
		crearP.setBounds(510, 40, 120, 30);
		add(crearP);
		
		ActionListener crp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cpV();
			}			
		};
		crearP.addActionListener(crp);
		
		cargaP = new JButton("Carga Masiva");
		cargaP.setBounds(650, 40, 120, 30);	
		add(cargaP);
		
		actualizarP = new JButton("Actualizar");
		actualizarP.setBounds(510, 90, 120, 30);
		add(actualizarP);
				
		ActionListener atp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apV();
			}			
		};
		actualizarP.addActionListener(atp);
		
		eliminarP = new JButton("Eliminar");
		eliminarP.setBounds(650, 90, 120, 30);
		add(eliminarP);
			
		exportarP = new JButton("Exportar Listado a PDF ");
		exportarP.setBounds(500, 140, 280, 30);
		add(exportarP);
		
		recaP = new JButton();
		recaP.setBounds(795, 70, 55, 55);
		recaP.setOpaque(false);
		recaP.setBackground(new Color(0,0,0,0));
		add(recaP);
		recaP.setIcon(setIcono("/imagenes/icon.png", recaP));
		//recaP.setPressedIcon(setPresionado("/imagenes/icon.png", recaP, 3, 3));
			
		Object [][] fil = new Object [50][5];
		
		ActionListener cg= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				
				JFileChooser jf = new JFileChooser();
				jf.showOpenDialog(file);
				File archivoP = jf.getSelectedFile();
				if(jf.getSelectedFile()!=null) {
					if(archivoP!= null) {
						Gestor.getInstance().cargamasivaP(archivoP);
					}
					for(int i=0; i<Gestor.getInstance().getProfesores().length; i++) {
						if(Gestor.getInstance().getProfesores()[i]!=null) {
							fil[i][0] = Gestor.getInstance().getProfesores()[i].cP;
							fil[i][1] = Gestor.getInstance().getProfesores()[i].nP;
							fil[i][2] = Gestor.getInstance().getProfesores()[i].aP;
							fil[i][3] = Gestor.getInstance().getProfesores()[i].coP;
							fil[i][4] = Gestor.getInstance().getProfesores()[i].gP;
						}
					}
					graficaP();
					refrescar();
				}
				}catch(Exception er) {
					System.out.println("Error: " +er);
				}
			}			
		};
		cargaP.addActionListener(cg);
		
		//====================================ELIMINAR DATOS==============================================
		ActionListener elip = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					eV();
				}catch(Exception er) {
					System.out.println("Error: " +er);
				}
			}			
		};
		eliminarP.addActionListener(elip);
		//================================================================================================
		
		
		//====================================REFRESH DE DATOS==============================================	
		ActionListener ac1= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					for(int i=0; i<Gestor.getInstance().getProfesores().length; i++) {
						if(Gestor.getInstance().getProfesores()[i]!=null ) {
							fil[i][0] = Gestor.getInstance().getProfesores()[i].cP;
							fil[i][1] = Gestor.getInstance().getProfesores()[i].nP;
							fil[i][2] = Gestor.getInstance().getProfesores()[i].aP;
							fil[i][3] = Gestor.getInstance().getProfesores()[i].coP;
							fil[i][4] = Gestor.getInstance().getProfesores()[i].gP;
						}else if(Gestor.getInstance().getProfesores()[i]==null) {
							fil[i][0]= null;
							fil[i][1]= null;
							fil[i][2]= null;
							fil[i][3]= null;
							fil[i][4]= null;
						}
					}
					gN();
					refrescar();
					
				}catch(Exception er) {
					System.out.println("Error: " +er);
				}
			}			
		};
		recaP.addActionListener(ac1);
		//===================================================================================================
		
		
		//====================================PDF==============================================	
		ActionListener ex = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pdf();
			}			
		};
		exportarP.addActionListener(ex);	
		//=====================================================================================

		String[] col = {"Codigo", "Nombre", "Apellido", "Correo", "Genero"};
		listadoP = new JTable(fil, col);
		listadoP.setBounds(20,55,450,500);
		listadoP.getTableHeader().setReorderingAllowed(false);	
		JScrollPane sp = new JScrollPane(listadoP);
		sp.setBounds(20,55,460,500);
		add(sp);
		
	}
	
	public void graficaP() {	
		DefaultPieDataset dataset = new DefaultPieDataset();
		String  m = "m";
		int hm = 0;
		int mj = 0;
		for(int i=0; i<Gestor.getInstance().getProfesores().length; i++) {
			if(Gestor.getInstance().getProfesores()[i]!=null) {
				if(Gestor.getInstance().getProfesores()[i].gP.equals("m")) {
					hm++;
				}else {
					mj++;
				}
			}
		}
		
		dataset.setValue("Masculino", hm);
		dataset.setValue("Femenino", mj);
		
		JFreeChart chart = ChartFactory.createPieChart(
				"Género de Profesores", 
				dataset, 
				true,
				true, 
				true);
		ChartPanel panel = new ChartPanel(chart);
		panel.setBounds(495, 200, 350, 300);
		add(panel);	
	}
	
	public void refrescar() {
		this.paintAll(getGraphics());
	}
	
	public void cpV() {
		CrearP cre = new CrearP(this.gs);
	}
	
	public void apV() {
		ActualizarP actu = new ActualizarP(this.gs);
	}
	
	public void gN() {
		GraficaNP ng = new GraficaNP(this.gs);
	}
	
	public void eV() {
		EliminarP e = new EliminarP(this.gs);
	}
	
	public Icon setIcono(String url, JButton boton) {
		ImageIcon icon = new ImageIcon(getClass().getResource(url));
		int ac = recaP.getWidth();
		int al = recaP.getHeight();
		
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ac, al, Image.ALIGN_JUSTIFIED_ALL));
		
		return icono;
	}
	
	public Icon setPresionado(String url, JButton boton, int an, int al) {
		ImageIcon icon = new ImageIcon(getClass().getResource(url));
		int width = recaP.getWidth() - an;
		int heigth = recaP.getHeight() - al;
		
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, heigth, Image.ALIGN_JUSTIFIED_ALL));
		return icono;
	}
	
	public void pdf() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Reportes/ListadoProfesores.pdf"));
			document.open();
			
			try {
				Image imagen = Image.getInstance("src/imagenes/profe.png");
				imagen.setAlignment(Image.ALIGN_LEFT);
				imagen.scaleAbsolute(80f, 80f);
				imagen.setAbsolutePosition(430f, 755f);
				document.add(imagen);
			}catch(Exception v) {
				System.out.println("Error: "+v);
			}
			
	        //Declaramos un texto como Paragraph. Le podemos dar formato alineado, tamaño, color, etc.
	        Paragraph titulo = new Paragraph();
	        titulo.setAlignment(Paragraph.ALIGN_CENTER);
	        titulo.setFont(FontFactory.getFont("Serif", 25, Font.ITALIC, BaseColor.BLACK));
	        titulo.add("Listado de Profesores");       
	        document.add(titulo);
	        
	        Paragraph vacio1 = new Paragraph();
	        vacio1.add("\n\n\n");
	        document.add(vacio1);
			
			PdfPTable table = new PdfPTable(5);
			
			Paragraph columna1 = new Paragraph("Código");
			columna1.getFont().setStyle(Font.BOLD);
		    columna1.getFont().setSize(15);
		    columna1.getFont().setFamily("Serif");
			table.addCell(columna1);
			
			Paragraph columna2 = new Paragraph("Nombre");
			columna2.getFont().setStyle(Font.BOLD);
		    columna2.getFont().setSize(15);
		    columna2.getFont().setFamily("Serif");
			table.addCell(columna2);
			
			Paragraph columna3 = new Paragraph("Apellido");
			columna3.getFont().setStyle(Font.BOLD);
		    columna3.getFont().setSize(15);
		    columna3.getFont().setFamily("Serif");
			table.addCell(columna3);
			
			Paragraph columna4 = new Paragraph("Correo");
			columna4.getFont().setStyle(Font.BOLD);
		    columna4.getFont().setSize(15);
		    columna4.getFont().setFamily("Serif");
			table.addCell(columna4);
			
			Paragraph columna5 = new Paragraph("Género");
			columna5.getFont().setStyle(Font.BOLD);
		    columna5.getFont().setSize(15);
		    columna5.getFont().setFamily("Serif");	   
			table.addCell(columna5);
			
			for(int i=0; i<Gestor.getInstance().getProfesores().length; i++) {
				if(Gestor.getInstance().getProfesores()[i]!=null) {
					table.addCell(Gestor.getInstance().getProfesores()[i].cP);
					table.addCell(Gestor.getInstance().getProfesores()[i].nP);
					table.addCell(Gestor.getInstance().getProfesores()[i].aP);
					table.addCell(Gestor.getInstance().getProfesores()[i].coP);
					table.addCell(Gestor.getInstance().getProfesores()[i].gP);
				}
			}
			
			document.add(table);
			document.close();
			
		}catch(Exception f) {
			JOptionPane.showMessageDialog(this,"No existen datos para exportar","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
