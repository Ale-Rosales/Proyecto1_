package login;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import funcional.*;

import javax.swing.*;

import pestañas.*;

public class Login extends JFrame{
	
	JTextField usuario, password;
	JButton loggear, seria, deseria;
	Gestor gs;
	
	public Login(Gestor gs) {
		this.gs=gs;
		this.setTitle("Inicio de Sesion");
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);

		ImageIcon icon = new ImageIcon("./src/imagenes/logo.png");
		JLabel label = new JLabel();
		label.setBounds(80, 25, 420, 200);
		Icon ico = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(ico);
		this.add(label);
		
		usuario = new JTextField();
		usuario.setBounds(20, 250, 540, 40);
		TextPrompt placehold = new TextPrompt("Codigo", usuario);
		this.add(usuario);
		
		password = new JTextField();
		password.setBounds(20, 300, 540, 40);
		TextPrompt placehold2 = new TextPrompt("Contraseña", password);
		this.add(password);
		
		loggear = new JButton("Iniciar sesion");
		loggear.setBounds(235, 370, 120, 40);
		this.add(loggear);
		
		ActionListener log = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				sesion();	
			}			
		};
		loggear.addActionListener(log);
		
		seria = new JButton();
		seria.setBounds(100, 360, 70, 70);
		seria.setOpaque(false);
		seria.setBackground(new Color(0,0,0,0));
		add(seria);
		seria.setIcon(setIcono("/imagenes/save.png", seria));
		
		ActionListener seri = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Gestor.getInstance().SeriaProfe(Gestor.getInstance().getProfesores());
				Gestor.getInstance().SeriaCurso(Gestor.getInstance().getCursos());
				Gestor.getInstance().SeriaAlumno(Gestor.getInstance().getAlumnos());
				Gestor.getInstance().SeriaCursoAsig(Gestor.getInstance().getCursoag());
				Gestor.getInstance().SeriaAlumnoAsig(Gestor.getInstance().getAlumcu());
				Gestor.getInstance().SeriaNotas(Gestor.getInstance().getNota());
			}			
		};
		seria.addActionListener(seri);
		
		deseria = new JButton();
		deseria.setBounds(430, 360, 70, 70);
		deseria.setOpaque(false);
		deseria.setBackground(new Color(0,0,0,0));
		add(deseria);
		deseria.setIcon(setIcono("/imagenes/open.png", deseria));
		
		ActionListener deseri = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				Gestor.getInstance().DeseriaProfe(Gestor.getInstance());
				Gestor.getInstance().DeseriaCurso(Gestor.getInstance());
				Gestor.getInstance().DeseriaAlumno(Gestor.getInstance());
				Gestor.getInstance().DeseriaCursoAsig(Gestor.getInstance());
				Gestor.getInstance().DeseriaAlumnoAsig(Gestor.getInstance());
				Gestor.getInstance().DeseriaNotas(Gestor.getInstance());
			}			
		};
		deseria.addActionListener(deseri);

		this.setVisible(true);
	}
	
	private void sesion() {
		if(gs.iniciar(usuario.getText(), password.getText())){
			VAdmin va = new VAdmin(gs);
			this.dispose();
		}else if(gs.iniciarP(usuario.getText(), password.getText())){
			VProfesores vp = new VProfesores(gs, Gestor.getInstance().getcP(usuario.getText()));
			this.dispose();
		}else if(gs.iniciarA(usuario.getText(), password.getText())) {
			VAlumnos va = new VAlumnos(gs, Gestor.getInstance().getcA(usuario.getText()));
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this,"No existe el usuario","Error",JOptionPane.ERROR_MESSAGE);	
		}
	}
	
	public Icon setIcono(String url, JButton boton) {
		ImageIcon icon = new ImageIcon(getClass().getResource(url));
		int ac = seria.getWidth();
		int al = seria.getHeight();
		
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ac, al, Image.SCALE_DEFAULT));
		
		return icono;
	}
	

}
