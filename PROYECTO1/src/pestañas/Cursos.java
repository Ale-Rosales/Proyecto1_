package pestañas;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import funcional.*;
import interfaz.*;
import javax.swing.table.DefaultTableModel;

public class Cursos extends JPanel{
	
	JButton crearC, cargaC, actualizarC, eliminarC, exportarC, recaC;
	JLabel tablaC;
	JTable listadoC;
	JFrame file;
	DefaultTableModel modeloC;
	Gestor gs;
	
	public Cursos(Gestor gs) {
		this.gs = gs;
		this.setLayout(null);
		this.setBackground(Color.ORANGE);
		
		crearC = new JButton("Crear");
		crearC.setBounds(510, 40, 120, 30);
		add(crearC);
		
		ActionListener crc = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ccV();
			}			
		};
		crearC.addActionListener(crc);
		
		cargaC = new JButton("Carga Masiva");
		cargaC.setBounds(650, 40, 120, 30);
		add(cargaC);
		
		actualizarC = new JButton("Actualizar");
		actualizarC.setBounds(510, 90, 120, 30);
		add(actualizarC);
		
		ActionListener acc = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				acV();
			}			
		};
		actualizarC.addActionListener(acc);
		
		eliminarC = new JButton("Eliminar");
		eliminarC.setBounds(650, 90, 120, 30);
		add(eliminarC);
		
		exportarC = new JButton("Exportar Listado a PDF ");
		exportarC.setBounds(500, 140, 280, 30);
		add(exportarC);
		
		recaC = new JButton();
		recaC.setBounds(795, 70, 55, 55);
		recaC.setOpaque(false);
		recaC.setBackground(new Color(0,0,0,0));
		add(recaC);
		recaC.setIcon(setIcono("/imagenes/icon.png", recaC));
		
		tablaC = new JLabel("Listado Oficial");
		tablaC.setBounds(45, 15, 130, 25);
		tablaC.setFont(new Font("Serif", Font.ITALIC,20));
		Font font = tablaC.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		tablaC.setFont(font.deriveFont(attributes));
		add(tablaC);

		Object[][] fil = new Object [50][5];
		
		ActionListener cg= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				JFileChooser jf = new JFileChooser();
				jf.showOpenDialog(file);
				File archivoC = jf.getSelectedFile();
				if(jf.getSelectedFile()!=null) {
					if(archivoC!= null) {
						Gestor.getInstance().cargamasivaC(archivoC);
					}
					for(int i=0; i<Gestor.getInstance().getCursos().length; i++) {
						if(Gestor.getInstance().getCursos()[i]!=null) {
							fil[i][0] = Gestor.getInstance().getCursos()[i].cC;
							fil[i][1] = Gestor.getInstance().getCursos()[i].nC;
							fil[i][2] = Gestor.getInstance().getCursos()[i].ncC;
							fil[i][4] = Gestor.getInstance().nombreCP(Gestor.getInstance().getCursos()[i].pC);
						}
					}			
					graficaC();
					refrescar();
					
				}
				}catch(Exception er) {
					System.out.println("Error: " +er);
				}
			}			
		};
		cargaC.addActionListener(cg);
		
		//====================================ELIMINAR DATOS==============================================
		ActionListener elic = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					eV();
				}catch(Exception er) {
					System.out.println("Error: " +er);
				}
			}			
		};
		eliminarC.addActionListener(elic);
		//================================================================================================
		
		
		//====================================REFRESH DE DATOS==============================================	
		ActionListener ac1= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
						for(int i=0; i<Gestor.getInstance().getCursos().length; i++) {
							if(Gestor.getInstance().getCursos()[i]!=null) {
								fil[i][0] = Gestor.getInstance().getCursos()[i].cC;
								fil[i][1] = Gestor.getInstance().getCursos()[i].nC;
								fil[i][2] = Gestor.getInstance().getCursos()[i].ncC;
								fil[i][4] = Gestor.getInstance().nombreCP(Gestor.getInstance().getCursos()[i].pC);
							}else if(Gestor.getInstance().getCursos()[i]==null) {
								fil[i][0]= null;
								fil[i][1]= null;
								fil[i][2]= null;
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
		recaC.addActionListener(ac1);
		//===================================================================================================
		
		
		//====================================PDF==============================================	
		ActionListener ex = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pdf();
			}			
		};
		exportarC.addActionListener(ex);	
		//=====================================================================================
		
		String[] col = {"Codigo", "Nombre", "Creditos", "Alumnos", "Profesor"};
		listadoC = new JTable(fil,col);	
		listadoC.setBounds(20,55,450,500);
		listadoC.getTableHeader().setReorderingAllowed(false);
		JScrollPane sp = new JScrollPane(listadoC);
		sp.setBounds(20,55,460,500);
		add(sp);
			
	}
	
	public void graficaC() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		Curso temp = null;			
		for(int i =0; i<Gestor.getInstance().getCursos().length-1;i++) {
			for(int j=0; j<Gestor.getInstance().getCursos().length-i-1;j++) {
				if(Gestor.getInstance().getCursos()[j]!=null && Gestor.getInstance().getCursos()[j+1]!=null) {
					if (Gestor.getInstance().getCursos()[j].ncC < Gestor.getInstance().getCursos()[j+1].ncC){ 
						temp = Gestor.getInstance().getCursos()[j]; 
						Gestor.getInstance().getCursos()[j] = Gestor.getInstance().getCursos()[j+1]; 
						Gestor.getInstance().getCursos()[j+1] = temp; 
					} 
				}
			}
		} 
		 	
		String cu = "";
		for(int i=0; i<3; i++) {
			dataset.addValue(Gestor.getInstance().getCursos()[i].ncC, Gestor.getInstance().getCursos()[i].nC, cu);
		}
		
		JFreeChart barChart = ChartFactory.createBarChart(
				"Top 3 cursos con más alumnos", 
				null, 
				null,
				dataset, 
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(barChart);
		panel.setBounds(495, 200, 350, 300);
		add(panel);
	}
	
	public void ccV() {
		CrearC cre = new CrearC(this.gs);
	}
	
	public void acV() {
		ActualizarC cre = new ActualizarC(this.gs);
	}
	
	public void refrescar() {
		this.paintAll(getGraphics());
	}
	
	public void gN() {
		GraficaNC ng = new GraficaNC(this.gs);
	}
	
	public void eV() {
		EliminarC e = new EliminarC(this.gs);
	}
	
	public Icon setIcono(String url, JButton boton) {
		ImageIcon icon = new ImageIcon(getClass().getResource(url));
		int ac = recaC.getWidth();
		int al = recaC.getHeight();
		
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ac, al, Image.ALIGN_JUSTIFIED_ALL));
		
		return icono;
	}
	
	public void pdf() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Reportes/ListadoCursos.pdf"));
			document.open();
			
			try {
				Image imagen = Image.getInstance("src/imagenes/curso.png");
				imagen.setAlignment(Image.ALIGN_LEFT);
				imagen.scaleAbsolute(80f, 80f);
				imagen.setAbsolutePosition(415f, 755f);
				document.add(imagen);
			}catch(Exception v) {
				System.out.println("Error: "+v);
			}
			
	        //Declaramos un texto como Paragraph. Le podemos dar formato alineado, tamaño, color, etc.
	        Paragraph titulo = new Paragraph();
	        titulo.setAlignment(Paragraph.ALIGN_CENTER);
	        titulo.setFont(FontFactory.getFont("Serif", 25, Font.ITALIC, BaseColor.BLACK));
	        titulo.add("Listado de Cursos");       
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
			
			Paragraph columna3 = new Paragraph("Créditos");
			columna3.getFont().setStyle(Font.BOLD);
		    columna3.getFont().setSize(15);
		    columna3.getFont().setFamily("Serif");
			table.addCell(columna3);
			
			Paragraph columna4 = new Paragraph("Alumnos");
			columna4.getFont().setStyle(Font.BOLD);
		    columna4.getFont().setSize(15);
		    columna4.getFont().setFamily("Serif");
			table.addCell(columna4);
			
			Paragraph columna5 = new Paragraph("Profesor");
			columna5.getFont().setStyle(Font.BOLD);
		    columna5.getFont().setSize(15);
		    columna5.getFont().setFamily("Serif");	   
			table.addCell(columna5);

			for(int i=0; i<Gestor.getInstance().getCursos().length; i++) {
				if(Gestor.getInstance().getCursos()[i]!=null) {
					table.addCell(Gestor.getInstance().getCursos()[i].cC);
					table.addCell(Gestor.getInstance().getCursos()[i].nC);
					table.addCell(String.valueOf(Gestor.getInstance().getCursos()[i].ncC));
					table.addCell(String.valueOf(Gestor.getInstance().getCursos()[i].nAA));
					table.addCell(Gestor.getInstance().nombreCP(Gestor.getInstance().getCursos()[i].pC));
				}
			}
			
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			document.add(table);
			document.close();
			
		}catch(Exception f) {
			JOptionPane.showMessageDialog(this,"No existen datos para exportar","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	
}
