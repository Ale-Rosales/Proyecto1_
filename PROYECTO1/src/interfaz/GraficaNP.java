package interfaz;

import java.awt.Color;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import funcional.Gestor;

public class GraficaNP extends JFrame{
	
	Gestor gs;
	
	public GraficaNP(Gestor gs) {
	this.gs = gs;
	this.setTitle("GRAFICA ACTUALIZADA");
	this.setSize(400,400);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setLayout(null);
	this.getContentPane().setBackground(Color.ORANGE);
	
	
	DefaultPieDataset dataset = new DefaultPieDataset();
	String  m = "m";
	int hm = 0;
	int mj = 0;
	for(int i=0; i<Gestor.getInstance().getProfesores().length; i++) {
		if(Gestor.getInstance().getProfesores()[i]!=null) {
			if(Gestor.getInstance().getProfesores()[i].gP.equals("m")) {
				hm++;
			}else {
				mj++;
			}
		}
	}
	
	dataset.setValue("Masculino", hm);
	dataset.setValue("Femenino", mj);	
	
	JFreeChart chart = ChartFactory.createPieChart(
			"Género de Profesores", 
			dataset, 
			true,
			true, 
			true);
	ChartPanel panel = new ChartPanel(chart);
	panel.setBounds(20, 20, 350, 300);
	add(panel);
	
	this.setVisible(true);
	
	}

}
