package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;

import com.itextpdf.text.Image;

import funcional.Alumno;
import funcional.Gestor;
import interfazAD.ActuAV;

public class VAlumnos extends JFrame{
	
	JButton salir, actudatos, refresh;
	JLabel titulo, usuario;
	Gestor gs;
	Alumno alum;
	
	public VAlumnos(Gestor gs, Alumno alum) {
		this.gs = gs;
		this.alum = alum;
		this.setTitle("ALUMNOS");
		this.setSize(900,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);

		titulo = new JLabel("Cursos Asignados");
		titulo.setBounds(65, 15, 315, 25);
		titulo.setFont(new Font("Serif", Font.ITALIC,25));
		Font font = titulo.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		add(titulo);
		
		usuario = new JLabel("Alumno: "+alum.nA+" "+alum.aA);
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
		
		
		this.setVisible(true);
	}
	
	public void cerrar() {
		Login lg = new Login(this.gs);
		this.dispose();
	}
	
	public void actu() {
		ActuAV aa = new ActuAV(this.gs, this.alum);
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

}
