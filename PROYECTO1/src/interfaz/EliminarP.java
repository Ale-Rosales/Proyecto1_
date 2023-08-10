package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;

import funcional.*;

public class EliminarP extends JFrame{
	
	Gestor gs;
	JLabel titulo, eliminar, elicombo;
	JButton elimi;
	JComboBox profe;
	JTextField eli;
	
	public EliminarP(Gestor gs) {
		this.gs = gs;
		this.setTitle("Eliminar profesor");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
		
		titulo = new JLabel("Eliminar profesor");
		titulo.setBounds(40, 15, 200,25);
		titulo.setFont(new Font("Serif", Font.ITALIC,20));
		Font font = titulo.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		add(titulo);
		
		elicombo = new JLabel("Seleccionar profesor:");
		elicombo.setBounds(60, 110, 150, 35);
		elicombo.setFont(new Font("Serif", Font.ITALIC,15));
		add(elicombo);
		
		profe = new JComboBox();
		for(int i=0; i<Gestor.getInstance().getProfesores().length; i++) {
			if(Gestor.getInstance().getProfesores()[i]!=null) {
			profe.addItem(Gestor.getInstance().getProfesores()[i].cP);
			}
		}
		profe.setBounds(215, 115, 170, 30);
		add(profe);
		
		eliminar = new JLabel("Profesor:");
		eliminar.setBounds(80, 190, 80, 35);
		eliminar.setFont(new Font("Serif", Font.ITALIC,15));
		add(eliminar);
		
		eli = new JTextField();
		eli.setBounds(160, 195, 180, 30);
		eli.setEditable(false);
		add(eli);
			
		// Accion a realizar cuando el JComboBox cambia de item seleccionado.
		profe.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<Gestor.getInstance().getProfesores().length; i++) {
					if(Gestor.getInstance().getProfesores()[i]!=null) {
						if(profe.getSelectedItem().toString() == Gestor.getInstance().getProfesores()[i].cP) {
							eli.setText(Gestor.getInstance().getProfesores()[i].nP);
						}
					}
				}
			}
		});
		
		elimi = new JButton("Eliminar");
		elimi.setBounds(180, 285, 130, 35);
		add(elimi);
		
		ActionListener agc = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}			
		};
		elimi.addActionListener(agc);
		
		this.setVisible(true);
	}
	
	public void eliminar() {
		try {
				Gestor.getInstance().eliminarP(eli.getText());
				this.dispose();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this,"Llenar los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
		}	
	}

}
