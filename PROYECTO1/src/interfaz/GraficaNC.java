package interfaz;

import java.awt.Color;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import funcional.Curso;
import funcional.Gestor;

public class GraficaNC extends JFrame{
	
	Gestor gs;
	
	public GraficaNC(Gestor gs) {
		this.gs = gs;
		this.setTitle("GRAFICA ACTUALIZADA");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		Curso temp = null;			
		for(int i =0; i<Gestor.getInstance().getCursos().length-1;i++) {
			for(int j=0; j<Gestor.getInstance().getCursos().length-i-1;j++) {
				if(Gestor.getInstance().getCursos()[j]!=null && Gestor.getInstance().getCursos()[j+1]!=null) {
					if (Gestor.getInstance().getCursos()[j].ncC < Gestor.getInstance().getCursos()[j+1].ncC){ 
						temp = Gestor.getInstance().getCursos()[j]; 
						Gestor.getInstance().getCursos()[j] = Gestor.getInstance().getCursos()[j+1]; 
						Gestor.getInstance().getCursos()[j+1] = temp; 
					} 
				}
			}
		} 
		 	
		String cu = "";
		for(int i=0; i<3; i++) {
			dataset.addValue(Gestor.getInstance().getCursos()[i].ncC, Gestor.getInstance().getCursos()[i].nC, cu);
		}
			
		JFreeChart barChart = ChartFactory.createBarChart(
				"Top 3 cursos con más alumnos", 
				null, 
				null,
				dataset, 
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(barChart);
		panel.setBounds(20, 20, 350, 300);
		add(panel);
		
		this.setVisible(true);
		
	}

}
