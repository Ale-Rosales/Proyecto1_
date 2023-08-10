package pestañas;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.general.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;

import funcional.*;
import interfaz.GraficaNA;

import javax.swing.table.DefaultTableModel;

public class Alumnos extends JPanel{
	
	JButton cargaA, exportarA, recaA;
	JLabel tablaA;
	JTable listadoA;
	JFrame file;
	DefaultTableModel modeloA;
	Gestor gs;
	
	public Alumnos(Gestor gs) {
		this.gs = gs;
		this.setLayout(null);
		this.setBackground(Color.ORANGE);
		
		cargaA = new JButton("Carga Masiva");
		cargaA.setBounds(530, 70, 230, 30);
		add(cargaA);
		
		exportarA = new JButton("Exportar Listado a PDF ");
		exportarA.setBounds(530, 120, 230, 30);
		add(exportarA);
		
		recaA = new JButton();
		recaA.setBounds(785, 75, 55, 55);
		recaA.setOpaque(false);
		recaA.setBackground(new Color(0,0,0,0));
		add(recaA);
		recaA.setIcon(setIcono("/imagenes/icon.png", recaA));
		
		tablaA = new JLabel("Listado Oficial");
		tablaA.setBounds(45, 15, 130, 25);
		tablaA.setFont(new Font("Serif", Font.ITALIC,20));
		Font font = tablaA.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		tablaA.setFont(font.deriveFont(attributes));
		add(tablaA);

		Object[][] fil = new Object [300][5];
		
		ActionListener cg= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				JFileChooser jf = new JFileChooser();
				jf.showOpenDialog(file);
				File archivoA = jf.getSelectedFile();
				if(jf.getSelectedFile()!=null) {
					if(archivoA!= null) {
						Gestor.getInstance().cargamasivaA(archivoA);
					}
					for(int i=0; i<Gestor.getInstance().getAlumnos().length; i++) {
						if(Gestor.getInstance().getAlumnos()[i]!=null) {
							fil[i][0] = Gestor.getInstance().getAlumnos()[i].cA;
							fil[i][1] = Gestor.getInstance().getAlumnos()[i].nA;
							fil[i][2] = Gestor.getInstance().getAlumnos()[i].aA;
							fil[i][3] = Gestor.getInstance().getAlumnos()[i].coA;
							fil[i][4] = Gestor.getInstance().getAlumnos()[i].gA;
						}	
					}
					
					graficaA();
					refrescar();
				}
				}catch(Exception er) {
					System.out.println("Error: " +er);
				}
			}			
		};
		cargaA.addActionListener(cg);
		
		//====================================REFRESH DE DATOS==============================================
		ActionListener ac1= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					for(int i=0; i<Gestor.getInstance().getAlumnos().length; i++) {
						if(Gestor.getInstance().getAlumnos()[i]!=null ) {
							fil[i][0] = Gestor.getInstance().getAlumnos()[i].cA;
							fil[i][1] = Gestor.getInstance().getAlumnos()[i].nA;
							fil[i][2] = Gestor.getInstance().getAlumnos()[i].aA;
							fil[i][3] = Gestor.getInstance().getAlumnos()[i].coA;
							fil[i][4] = Gestor.getInstance().getAlumnos()[i].gA;
						}else if(Gestor.getInstance().getAlumnos()[i]==null) {
							fil[i][0]= null;
							fil[i][1]= null;
							fil[i][2]= null;
							fil[i][3]= null;
							fil[i][4]= null;
						}
					}
					gNA();
					refrescar();
					
				}catch(Exception er) {
					System.out.println("Error: " +er);
				}
			}			
		};
		recaA.addActionListener(ac1);
		//===================================================================================================
		
		
		//====================================PDF==============================================	
		ActionListener ex = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pdf();
			}			
		};
		exportarA.addActionListener(ex);	
		//=====================================================================================
		
		String[] col = {"Codigo", "Nombre", "Apellido", "Correo", "Genero"};
		listadoA = new JTable(fil,col);
		listadoA.setBounds(20,55,450,500);
		listadoA.getTableHeader().setReorderingAllowed(false);
		JScrollPane sp = new JScrollPane(listadoA);
		sp.setBounds(20,55,460,500);
		add(sp);
	
	}
	
	public void graficaA() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		String  m = "m";
		int hm = 0;
		int mj = 0;
		for(int i=0; i<Gestor.getInstance().getAlumnos().length; i++) {
			if(Gestor.getInstance().getAlumnos()[i]!=null) {
				if(Gestor.getInstance().getAlumnos()[i].gA.equals("m")) {
					hm++;
				}else {
					mj++;
				}
			}
		}
		
		dataset.setValue("Masculino", hm);
		dataset.setValue("Femenino", mj);	
		
		JFreeChart chart = ChartFactory.createPieChart(
				"Género de Alumnos", 
				dataset, 
				true,
				true, 
				true);
		ChartPanel panel = new ChartPanel(chart);
		panel.setBounds(495, 200, 350, 300);
		add(panel);
	}
	
	public Icon setIcono(String url, JButton boton) {
		ImageIcon icon = new ImageIcon(getClass().getResource(url));
		int ac = recaA.getWidth();
		int al = recaA.getHeight();
		
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ac, al, Image.ALIGN_JUSTIFIED_ALL));
		
		return icono;
	}
	
	public void refrescar() {
		this.paintAll(getGraphics());
	}
	
	public void gNA() {
		GraficaNA na = new GraficaNA(this.gs);
	}
	
	public void pdf() {
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Reportes/ListadoAlumnos.pdf"));
			document.open();
			
			try {
				Image imagen = Image.getInstance("src/imagenes/alumno.png");
				imagen.setAlignment(Image.ALIGN_LEFT);
				imagen.scaleAbsolute(80f, 80f);
				imagen.setAbsolutePosition(420f, 755f);
				document.add(imagen);
			}catch(Exception v) {
				System.out.println("Error: "+v);
			}

	        //Declaramos un texto como Paragraph. Le podemos dar formato alineado, tamaño, color, etc.
	        Paragraph titulo = new Paragraph();
	        titulo.setAlignment(Paragraph.ALIGN_CENTER);
	        titulo.setFont(FontFactory.getFont("Serif", 25, Font.ITALIC, BaseColor.BLACK));
	        titulo.add("Listado de Alumnos");       
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

			for(int i=0; i<Gestor.getInstance().getAlumnos().length; i++) {
				if(Gestor.getInstance().getAlumnos()[i]!=null) {
					table.addCell(Gestor.getInstance().getAlumnos()[i].cA);
					table.addCell(Gestor.getInstance().getAlumnos()[i].nA);
					table.addCell(Gestor.getInstance().getAlumnos()[i].aA);
					table.addCell(Gestor.getInstance().getAlumnos()[i].coA);
					table.addCell(Gestor.getInstance().getAlumnos()[i].gA);
				}
			}
			
			document.add(table);
			document.close();
			
		}catch(Exception f) {
			JOptionPane.showMessageDialog(this,"No existen datos para exportar","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

}
