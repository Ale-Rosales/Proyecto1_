package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;

import com.itextpdf.text.Image;

import funcional.Curso;
import funcional.CursoAsignado;
import funcional.Gestor;
import funcional.Profesor;
import interfazAD.ActuPV;
import interfazAD.AdminisP;
import interfazAD.InfoC;
import interfazAD.PanelAdminisP;

public class VProfesores extends JFrame implements ActionListener{
	
	JLabel titulo, usuario;
	JButton salir, actudatos, refresh;
	Gestor gs;
	Profesor pf;
	CursoAsignado csa;
	JPanel panel;
	JButton [] arreglo;
	JLabel [] arreglo2;
	JScrollPane scroll;
	
	public VProfesores(Gestor gs, Profesor pf) {
		this.gs = gs;
		this.pf = pf;
		this.setTitle("PROFESORES");
		this.setSize(900,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
		Gestor.getInstance().getcC2(pf.cP);

		titulo = new JLabel("Cursos Asignados");
		titulo.setBounds(65, 15, 315, 25);
		titulo.setFont(new Font("Serif", Font.ITALIC,25));
		Font font = titulo.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		add(titulo);
		
		usuario = new JLabel("Profesor: "+pf.nP+" "+pf.aP);
		usuario.setBounds(65, 50, 200, 25);
		usuario.setFont(new Font("Serif", Font.ITALIC, 15));
		add(usuario);
		
		salir = new JButton("Cerrar Sesion");
		salir.setBounds(700, 25, 120, 30);
		add(salir);
		
		ActionListener ce = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				cerrar();	
			}			
		};
		salir.addActionListener(ce);
		
		actudatos = new JButton("Actualizar datos");
		actudatos.setBounds(693, 70, 135, 30);
		add(actudatos);
		
		ActionListener ad = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				actu();
			}			
		};
		actudatos.addActionListener(ad);
	
		refresh = new JButton();
		refresh.setBounds(630, 35, 55, 55);
		refresh.setOpaque(false);
		refresh.setBackground(new Color(0,0,0,0));
		add(refresh);
		refresh.setIcon(setIcono("/imagenes/icon.png", refresh));
		
		ActionListener rfh = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				refrescar();
			}			
		};
		refresh.addActionListener(rfh);
		
		//=================================================PANEL QUE CONTIENE LOS BOTONES DE LOS CURSOS=================================================
		panel = new PanelAdminisP(this.gs, this.pf);
		add(panel);
		
		/*panel = new JPanel();
		panel.setBounds(12, 140, 860, 505);
		panel.setBackground(Color.ORANGE);
		add(panel);
		panel.setLayout(new GridLayout());
		
		scroll = new JScrollPane();
		
		arreglo = new JButton[50];
		arreglo2 = new JLabel[50];
		
		for(int i=0; i<arreglo.length; i++) {
			if(Gestor.getInstance().getCursoag()[i]!=null) {
				arreglo[i]= new JButton(Gestor.getInstance().getCursoag()[i].cC);
				arreglo2[i] = new JLabel(Gestor.getInstance().getCursoag()[i].nC);
				
				arreglo[i].addActionListener(this);
				
				panel.add(arreglo2[i]);
				arreglo2[i].setFont(new Font("Serif", Font.ITALIC,15));
				arreglo2[i].setHorizontalAlignment(JTextField.CENTER);
			
				panel.add(arreglo[i]);
			
			}
		}*/
		//==================================================================================================
		
		this.setVisible(true);
		
	}
	
	public void cerrar() {
		Login lg = new Login(this.gs);
		this.dispose();
	}
	
	public void actu() {
		ActuPV ap = new ActuPV(this.gs, this.pf);
	}
	
	public Icon setIcono(String url, JButton boton) {
		ImageIcon icon = new ImageIcon(getClass().getResource(url));
		int ac = refresh.getWidth();
		int al = refresh.getHeight();
		
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ac, al, Image.ALIGN_JUSTIFIED_ALL));
		
		return icono;
	}
	
	public void refrescar() {
		this.paintAll(getGraphics());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		for(JButton ar:this.arreglo) {
			if(ar!=null && e.getSource()==ar ) {
				AdminisP info = new AdminisP(this.gs, Gestor.getInstance().getAC(ar.getText()));
			}
		}	
	}
	

}
