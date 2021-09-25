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

		if (e.getActionCommand().equalsIgnoreCase("Invia")) {
			int numTentativi = tentativi.getTentativi();
			int numTirato = -99;
			try {
				String numeroTirato = grafica.getTxtNumero().getText();
				numTirato = Integer.parseInt(numeroTirato);
				int flag = tentativi.checkNumber(numTirato);

				if (numTentativi >= 1) {
					switch (flag) {
					case 99:
						break;
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
				} else {
					grafica.getLblScore().setText("0");
					grafica.getLblTesto().setText("Hai perso :(");
					grafica.getBtnInvia().setEnabled(false);
				}
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
			if (numTirato == -99) {
				grafica.getLblTesto().setText("! Attenzione inserire valore numerico !");
			}
		}

		if (e.getActionCommand().equalsIgnoreCase("Reset")) {
			int numTentativi = tentativi.getTentativi();
			grafica.getLblTesto().setText("Benvenuto :)");
			tentativi.generaNumero();
			grafica.getLblScore().setText("" + numTentativi);
			grafica.getBtnInvia().setEnabled(true);

		}
	}
}
