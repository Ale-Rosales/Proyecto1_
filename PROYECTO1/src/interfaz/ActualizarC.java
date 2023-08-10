package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;

import funcional.*;

public class ActualizarC extends JFrame{

	Gestor gs;
	JLabel titulo, codigo, nombre, creditos, profesor;
	JButton actualizar;
	JTextField codigot, nombret, creditost, pro;
	JComboBox profe, codC;
	
	public ActualizarC(Gestor gs) {
		this.gs = gs;
		this.setTitle("Actualizar curso");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
		
		titulo = new JLabel("Actualizar datos curso");
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
		
		codC = new JComboBox();
		for(int i=0; i<Gestor.getInstance().getCursos().length; i++) {
			if(Gestor.getInstance().getCursos()[i]!=null) {
				codC.addItem(Gestor.getInstance().getCursos()[i].cC);
			}
		}
		codC.setBounds(180, 75, 160, 25);
		add(codC);
		
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
		profe.setBounds(180, 225, 160, 25);
		//add(profe);
		
		pro = new JTextField();
		pro.setBounds(180, 225, 160, 25);
		add(pro);
		//JTextField codigot, nombret, creditost;
		codC.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<Gestor.getInstance().getCursos().length; i++) {
					if(Gestor.getInstance().getCursos()[i]!=null) {
						if(codC.getSelectedItem().toString() == Gestor.getInstance().getCursos()[i].cC) {
							nombret.setText(Gestor.getInstance().getCursos()[i].nC);
							creditost.setText(String.valueOf(Gestor.getInstance().getCursos()[i].ncC));  //AL FIN CONSEGUI PASAR A STRING :)
							pro.setText(String.valueOf(Gestor.getInstance().getCursos()[i].pC));
						}
					}
				}
				
			}			
		});
		
		actualizar = new JButton("Actualizar");
		actualizar.setBounds(230, 285, 130, 35);
		add(actualizar);
		
		ActionListener atu = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modi();
;			}			
		};
		actualizar.addActionListener(atu);
		
		this.setVisible(true);
		
	}
	
	public void modi() {
		try {
			Gestor.getInstance().modificarC(codC.getSelectedItem().toString(), nombret.getText(), Integer.parseInt(creditost.getText()), pro.getText());
			this.dispose();		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this,"Llenar los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

}
