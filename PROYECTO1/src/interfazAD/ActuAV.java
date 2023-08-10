package interfazAD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;

import funcional.*;

public class ActuAV extends JFrame{
	
	Gestor gs;
	Alumno alum;
	JLabel titulo, codigo, nombre, apellido, correo, contra, genero;
	JButton actualizar;
	JTextField codigot, nombret, apellidot, correot, contrat, genet;
	
	public ActuAV(Gestor gs, Alumno alum) {
		this.gs = gs;
		this.setTitle("Actualizar Alumno");
		this.setSize(500,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
		
		titulo = new JLabel("Actualizar datos alumno");
		titulo.setBounds(30,35,220,25);
		titulo.setFont(new Font("Serif", Font.ITALIC,20));
		Font font = titulo.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		add(titulo);
		
		codigot = new JTextField();
		codigot.setText(alum.cA);
		
		nombre = new JLabel("Nombre:");
		nombre.setBounds(80, 320, 80, 35);
		nombre.setFont(new Font("Serif", Font.ITALIC,15));
		add(nombre);
		
		nombret = new JTextField();
		nombret.setBounds(180, 325, 200, 25);
		nombret.setText(alum.nA);
		add(nombret);

		apellido = new JLabel("Apellido:");
		apellido.setBounds(80, 370, 80, 35);
		apellido.setFont(new Font("Serif", Font.ITALIC,15));
		add(apellido);
		
		apellidot = new JTextField();
		apellidot.setBounds(180, 375, 200, 25);
		apellidot.setText(alum.aA);
		add(apellidot);
		
		correo = new JLabel("Correo:");
		correo.setBounds(80, 420, 80, 35);
		correo.setFont(new Font("Serif", Font.ITALIC,15));
		add(correo);
		
		correot = new JTextField();
		correot.setBounds(180, 425, 200, 25);
		correot.setText(alum.coA);
		add(correot);
		
		contra = new JLabel("Contraseña:");
		contra.setBounds(80, 470, 80, 35);
		contra.setFont(new Font("Serif", Font.ITALIC,15));
		add(contra);
		
		contrat = new JTextField();
		contrat.setBounds(180, 475, 200, 25);
		contrat.setText(alum.getPassA());
		add(contrat);
		
		genero = new JLabel("Género:");
		genero.setBounds(80, 520, 80, 35);
		genero.setFont(new Font("Serif", Font.ITALIC,15));
		add(genero);
		
		genet = new JTextField();
		genet.setBounds(180, 525, 160, 25);
		genet.setText(alum.gA);
		add(genet);
						
		actualizar = new JButton("Actualizar");
		actualizar.setBounds(170, 590, 130, 35);
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
			Gestor.getInstance().modificarA(codigot.getText(), nombret.getText(),
					apellidot.getText(), correot.getText(), genet.getText(), contrat.getText());
			this.dispose();		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this,"Llenar los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
		}	
	}

}
