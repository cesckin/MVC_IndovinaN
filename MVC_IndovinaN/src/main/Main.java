package main;

import controller.Controller;
import model.Tentativi;
import view.Grafica;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafica g = new Grafica();
		Tentativi t = new Tentativi();
		Controller c = new Controller(g, t);
		g.setVisible(true);
	}

}
