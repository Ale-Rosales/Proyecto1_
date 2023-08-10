package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import funcional.Gestor;
import pestañas.*;

public class VAdmin extends JFrame{
	
	Profesores panelP;
	Alumnos panelA;
	Cursos panelC;
	JTabbedPane pestañas;
	JLabel titulo;
	JButton salir;
	Gestor gs;

	public VAdmin(Gestor gs) {
		this.gs = gs;
		this.setTitle("ADMINISTRADOR");
		this.setSize(900,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);

		titulo = new JLabel("Modulo de Administrador");
		titulo.setBounds(300, 10, 315, 30);
		titulo.setFont(new Font("Serif", Font.ITALIC,30));
		add(titulo);
		
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
		
		pestañas = new JTabbedPane();

		panelP = new Profesores(this.gs);
		panelA = new Alumnos(this.gs);
		panelC = new Cursos(this.gs);
		
		pestañas.add("Profesores", panelP);
		pestañas.add("Cursos", panelC);
		pestañas.add("Alumnos", panelA);
		
		pestañas.setBounds(10, 50 , 863, 600);
		pestañas.setFont(new Font("Serif", Font.ROMAN_BASELINE,15));
		pestañas.setBackgroundAt(0, Color.ORANGE); //CAMBIAR COLOR DE CADA PESTAÑA
		pestañas.setBackgroundAt(1, Color.ORANGE);
		pestañas.setBackgroundAt(2, Color.ORANGE);
		add(pestañas);
		
		this.setVisible(true);
		
	}
	
	public void cerrar() {
		Login lg = new Login(this.gs);
		this.dispose();
	}
	
}
