package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import model.Tentativi;
import view.Grafica;

public class Controller implements ActionListener {

	private Grafica grafica;
	private Tentativi tentativi;
	private String stringa = "";
	FileWriter fw = null;

	public Controller(Grafica grafica, Tentativi tentativi) {
		this.grafica = grafica;
		this.tentativi = tentativi;
		grafica.registraController(this);
		tentativi.generaNumero();
		grafica.getLblTesto().setText("Benvenuto :) 0-50");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		try {
			fw = new FileWriter("log.txt", true);
			stringa = tentativi.getOra() + " Inizio game\n";
			if (e.getActionCommand().equalsIgnoreCase("Invia")) {
				stringa = tentativi.getOra() + "Utente ha premuto invia\n";
				int numTirato = -99;
				try {
					String numeroTirato = grafica.getTxtNumero().getText();
					numTirato = Integer.parseInt(numeroTirato);
					int flag = tentativi.checkNumber(numTirato);

					stringa = tentativi.getOra() + " Utente ha tirato il numero " + numTirato + "\n";

					if (tentativi.getTentativi() > 1) {
						switch (flag) {
						case 99:
							break;
						case 1:
							tentativi.decrementaTentativi();
							stringa = tentativi.getOra() + " Utente deve provare con numero minore \n";
							grafica.getLblTesto().setText("Prova con un numero minore !");
							break;
						case -1:
							tentativi.decrementaTentativi();
							stringa = tentativi.getOra() + " Utente deve provare con numero maggiore \n";
							grafica.getLblTesto().setText("Prova con un numero maggiore !");
							break;
						case 0:
							stringa = tentativi.getOra() + " Utente ha vinto la partita! \n";
							grafica.getLblTesto().setText("Hai vinto :)");
							break;
						}
						stringa = tentativi.getOra() + " Utente ha " + tentativi.getTentativi() + " tentativi\n";
						grafica.getLblScore().setText("" + tentativi.getTentativi());
					} else {
						stringa = tentativi.getOra() + " Utente ha perso la partita :( \n";
						grafica.getLblTesto().setText("Hai perso :(");
						grafica.getLblScore().setText("0");
						grafica.getBtnInvia().setEnabled(false);
					}
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				if (numTirato == -99) {
					stringa = tentativi.getOra() + " Utente ha inserito un valore non numerico! \n";
					grafica.getLblTesto().setText("! Attenzione inserire valore numerico !");
				}
			}

			if (e.getActionCommand().equalsIgnoreCase("Reset")) {
				stringa = tentativi.getOra() + " Utente ha resettato la partita! \n";
				tentativi.generaNumero();
				int numTentativi = tentativi.getTentativi();
				grafica.getTxtNumero().setText(null);
				grafica.getLblTesto().setText("Benvenuto :) 0-50");
				grafica.getLblScore().setText("" + numTentativi);
				grafica.getBtnInvia().setEnabled(true);
			}

			fw.write(stringa);
			fw.close();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

}
