package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;

import funcional.*;
import pestañas.Profesores;

public class CrearP extends JFrame{
	
	Gestor gs;
	JLabel titulo, codigo, nombre, apellido, correo, contra, genero;
	JButton agregar;
	JTextField codigot, nombret, apellidot, correot, contrat;
	JComboBox gene, cod;
	
	
	public CrearP(Gestor gs) {
		this.gs = gs;
		this.setTitle("Agregar Profesor");
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
		
		titulo = new JLabel("Agregar nuevo profesor");
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
		
		apellido = new JLabel("Apellido:");
		apellido.setBounds(80, 170, 80, 35);
		apellido.setFont(new Font("Serif", Font.ITALIC,15));
		add(apellido);
		
		apellidot = new JTextField();
		apellidot.setBounds(180, 175, 200, 25);
		add(apellidot);
		
		correo = new JLabel("Correo:");
		correo.setBounds(80, 220, 80, 35);
		correo.setFont(new Font("Serif", Font.ITALIC,15));
		add(correo);
		
		correot = new JTextField();
		correot.setBounds(180, 225, 200, 25);
		add(correot);
		
		contra = new JLabel("Contraseña:");
		contra.setBounds(80, 270, 80, 35);
		contra.setFont(new Font("Serif", Font.ITALIC,15));
		add(contra);
		
		contrat = new JTextField();
		contrat.setBounds(180, 275, 200, 25);
		add(contrat);
		
		genero = new JLabel("Género:");
		genero.setBounds(80, 320, 80, 35);
		genero.setFont(new Font("Serif", Font.ITALIC,15));
		add(genero);
		
		String [] selec = {"m","f"};
		gene = new JComboBox(selec);
		gene.setBounds(180, 325, 160, 25);
		add(gene);
		
		agregar = new JButton("Agregar");
		agregar.setBounds(230, 390, 130, 35);
		add(agregar);
		
		ActionListener agp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crear();
			}			
		};
		agregar.addActionListener(agp);
		
		this.setVisible(true);
		
	}
	
	public void crear() {
		try {
			Gestor.getInstance().insertarP(codigot.getText(), nombret.getText(), apellidot.getText(), correot.getText(), gene.getSelectedItem().toString());
			this.dispose();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this,"Llenar los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
		}	
	}

}
