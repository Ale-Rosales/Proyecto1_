package interfazAD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;

import funcional.*;

public class ActuPV extends JFrame{
	
	Gestor gs;
	Profesor pf;
	JLabel titulo, codigo, nombre, apellido, correo, contra, genero;
	JButton actualizar;
	JTextField codigot, nombret, apellidot, correot, contrat, genet;
	
	public ActuPV(Gestor gs, Profesor pf) {
		this.gs = gs;
		this.setTitle("Actualizar Profesor");
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
		
		titulo = new JLabel("Actualizar datos profesor");
		titulo.setBounds(30,35,220,25);
		titulo.setFont(new Font("Serif", Font.ITALIC,20));
		Font font = titulo.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		add(titulo);
		
		codigot = new JTextField();
		codigot.setText(pf.cP);
		
		nombre = new JLabel("Nombre:");
		nombre.setBounds(80, 120, 80, 35);
		nombre.setFont(new Font("Serif", Font.ITALIC,15));
		add(nombre);
		
		nombret = new JTextField();
		nombret.setBounds(180, 125, 200, 25);
		nombret.setText(pf.nP);
		add(nombret);

		apellido = new JLabel("Apellido:");
		apellido.setBounds(80, 170, 80, 35);
		apellido.setFont(new Font("Serif", Font.ITALIC,15));
		add(apellido);
		
		apellidot = new JTextField();
		apellidot.setBounds(180, 175, 200, 25);
		apellidot.setText(pf.aP);
		add(apellidot);
		
		correo = new JLabel("Correo:");
		correo.setBounds(80, 220, 80, 35);
		correo.setFont(new Font("Serif", Font.ITALIC,15));
		add(correo);
		
		correot = new JTextField();
		correot.setBounds(180, 225, 200, 25);
		correot.setText(pf.coP);
		add(correot);
		
		contra = new JLabel("Contraseña:");
		contra.setBounds(80, 270, 80, 35);
		contra.setFont(new Font("Serif", Font.ITALIC,15));
		add(contra);
		
		contrat = new JTextField();
		contrat.setBounds(180, 275, 200, 25);
		contrat.setText(pf.getPassP());
		add(contrat);
		
		genero = new JLabel("Género:");
		genero.setBounds(80, 320, 80, 35);
		genero.setFont(new Font("Serif", Font.ITALIC,15));
		add(genero);
		
		genet = new JTextField();
		genet.setBounds(180, 325, 160, 25);
		genet.setText(pf.gP);
		add(genet);
						
		actualizar = new JButton("Actualizar");
		actualizar.setBounds(230, 390, 130, 35);
		add(actualizar);
		
		ActionListener atu = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actu();
;			}			
		};
		actualizar.addActionListener(atu);
		
		this.setVisible(true);
	}
	
	public void actu() {
		try {
			Gestor.getInstance().modificarP(codigot.getText(), nombret.getText(),
					apellidot.getText(), correot.getText(), genet.getText(), contrat.getText());
			this.dispose();		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this,"Llenar los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
		}	
	}

}
