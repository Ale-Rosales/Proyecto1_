package interfazAD;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import funcional.Alumno;
import funcional.CursoAsignado;
import funcional.Gestor;

public class PanelAdminsA extends JPanel implements ActionListener{
	
	Gestor gs;
	CursoAsignado csa;
	Alumno alumn;
	JButton [] arreglo;
	JLabel [] arreglo2;
	
	public PanelAdminsA(Gestor gs, CursoAsignado csa, Alumno alum) {
		this.gs = gs;
		this.alumn = alum;		
		this.setLayout(null);
		this.setBackground(Color.ORANGE);
		this.setBounds(12, 140, 860, 505);
		
		this.setLayout(new GridLayout(3,1));
		
		arreglo = new JButton[50];
		arreglo2 = new JLabel[50];
		
		for(int i=0; i<arreglo.length; i++) {
			if(Gestor.getInstance().getCursoag()[i]!=null) {
				arreglo[i]= new JButton(Gestor.getInstance().getCursoag()[i].cC);
				add(arreglo[i]);
				arreglo[i].addActionListener(this);
				
				arreglo2[i] = new JLabel(Gestor.getInstance().getCursoag()[i].nC);
				arreglo2[i].setFont(new Font("Serif", Font.ITALIC,15));
				arreglo2[i].setHorizontalAlignment(JTextField.CENTER);
				add(arreglo2[i]);
					
			}
		}
		
		
		
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	

}
