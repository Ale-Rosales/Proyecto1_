package main;

import login.Login;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import funcional.*;



public class main {
	
	static JFrame file;

	public static void main(String[] args) {
		
		Gestor.getInstance().insertar("admin", "admin");
		Login lg = new Login(Gestor.getInstance());

	}	
	

}
