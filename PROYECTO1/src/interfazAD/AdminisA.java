package interfazAD;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;

import funcional.*;

public class AdminisA extends JFrame{
	
	Gestor gs;
	JLabel titulo, titulo1;
	
	public AdminisA(Gestor gs) {
		this.gs = gs;
		this.setTitle("INFORMACION CURSO");
		this.setSize(1010,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
		
		titulo = new JLabel("CURSO");
		titulo.setBounds(65, 15, 315, 30);
		titulo.setFont(new Font("Serif", Font.ITALIC,30));
		Font font = titulo.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo.setFont(font.deriveFont(attributes));
		add(titulo);
		
		titulo1 = new JLabel("Actividades");
		titulo1.setBounds(45, 80, 130, 25);
		titulo1.setFont(new Font("Serif", Font.ITALIC,15));
		Font font1 = titulo1.getFont();
		Map attributes1 = font1.getAttributes();
		attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titulo1.setFont(font.deriveFont(attributes1));
		add(titulo1);
		
		
		
		
		this.setVisible(true);
	}

}
