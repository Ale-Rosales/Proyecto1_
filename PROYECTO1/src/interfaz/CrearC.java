package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;

import funcional.*;

public class CrearC extends JFrame{
	
	Gestor gs;
	JLabel titulo, codigo, nombre, creditos, profesor;
	JButton agregar;
	JTextField codigot, nombret, creditost;
	JComboBox profe;
	
	public CrearC(Gestor gs) {
		this.gs = gs;
		this.setTitle("Agregar curso");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
		
		titulo = new JLabel("Agregar datos curso");
		titulo.setBounds(30,15,200,25);
		titulo.setFont(new Font("Serif", Font.ITALIC,20));
		Font font = titulo.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		add(titulo);
		
		codigo = new JLabel("Código:");
		codigo.setBounds(80, 70, 80, 35);
		codigo.setFont(new Font("Serif", Font.ITALIC,15));
		add(codigo);
		
		codigot = new JTextField();
		codigot.setBounds(180, 75, 160, 25);
		add(codigot);
		
		nombre = new JLabel("Nombre:");
		nombre.setBounds(80, 120, 80, 35);
		nombre.setFont(new Font("Serif", Font.ITALIC,15));
		add(nombre);
		
		nombret = new JTextField();
		nombret.setBounds(180, 125, 200, 25);
		add(nombret);
		
		creditos = new JLabel("Créditos:");
		creditos.setBounds(80, 170, 80, 35);
		creditos.setFont(new Font("Serif", Font.ITALIC,15));
		add(creditos);
		
		creditost = new JTextField();
		creditost.setBounds(180, 175, 200, 25);
		add(creditost);
		
		profesor = new JLabel("Profesor:");
		profesor.setBounds(80, 220, 80, 35);
		profesor.setFont(new Font("Serif", Font.ITALIC,15));
		add(profesor);
		
		profe = new JComboBox();
		for(int i=0; i<Gestor.getInstance().getProfesores().length; i++) {
			if(Gestor.getInstance().getProfesores()[i]!=null) {
			profe.addItem(Gestor.getInstance().getProfesores()[i].cP);
			}
		}
		profe.setBounds(180, 225, 160, 25);
		add(profe);
		
		agregar = new JButton("Agregar");
		agregar.setBounds(230, 285, 130, 35);
		add(agregar);
		
		ActionListener agc = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crear();
			}			
		};
		agregar.addActionListener(agc);
		
		
		this.setVisible(true);
		
	}
	
	public void crear() {
		try {
			Gestor.getInstance().insertarC(codigot.getText(), nombret.getText(), Integer.parseInt(creditost.getText()), profe.getSelectedItem().toString());
			this.dispose();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this,"Llenar los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
		}	
	}
	
}
