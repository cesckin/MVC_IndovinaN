package main;

import controller.Controller;
import controller.Logger;
import model.Tentativi;
import view.Grafica;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafica g = new Grafica();
		Tentativi t = new Tentativi();
		Logger l = new Logger();
		Controller c = new Controller(g, t, l);
		g.setVisible(true);
	}

}
