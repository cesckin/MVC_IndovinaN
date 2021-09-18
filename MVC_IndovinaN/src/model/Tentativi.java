package model;

public class Tentativi {

	private int numeroTentativi;
	private int numeroGenerato;
	private int numeroTirato;
	private int flag;

	public void generaNumero() {
		numeroGenerato = (int) (Math.random() * 50);
		numeroTentativi = 10;
	}

	public int getTentativi() {
		return numeroTentativi;
	}

	public void decrementaTentativi() {
		numeroTentativi--;
	}

	public int getNumeroTirato() {
		return numeroTirato;
	}

	public int checkNumber(int numeroTirato) {
		if (numeroTirato > numeroGenerato)
			flag = 1;
		if (numeroTirato < numeroGenerato)
			flag = -1;
		if (numeroTirato == numeroGenerato)
			flag = 0;
		return flag;
	}

}
