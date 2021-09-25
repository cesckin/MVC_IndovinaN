package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Tentativi;
import view.Grafica;

public class Controller implements ActionListener {

	private Grafica grafica;
	private Tentativi tentativi;

	public Controller(Grafica grafica, Tentativi tentativi) {
		this.grafica = grafica;
		this.tentativi = tentativi;
		grafica.registraController(this);
		tentativi.generaNumero();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int numTentativi = tentativi.getTentativi();
		if (e.getActionCommand().equalsIgnoreCase("Invia")) {

			int n = -99;
			try {
				
				String numeroTirato = grafica.getTxtNumero().getText();
				int numTirato = Integer.parseInt(numeroTirato);

				int flag = tentativi.checkNumber(numTirato);

				if (numTentativi >= 1) {
					switch (flag) {
					case 1:
						tentativi.decrementaTentativi();
						grafica.getLblTesto().setText("Prova con un numero minore !");
						break;
					case -1:
						tentativi.decrementaTentativi();
						grafica.getLblTesto().setText("Prova con un numero maggiore !");
						break;
					case 0:
						grafica.getLblTesto().setText("Hai vinto :)");
						break;
					}
					grafica.getLblScore().setText("" + numTentativi);
				} else
					grafica.getLblTesto().setText("Hai perso :(");

			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
			if (n == -99) {
				grafica.getLblTesto().setText("! Attenzione inserire valore numerico !");
			}
		}

		if (e.getActionCommand().equalsIgnoreCase("Reset")) {

			tentativi.generaNumero();
			grafica.getLblScore().setText("" + numTentativi);

		}
	}
}
