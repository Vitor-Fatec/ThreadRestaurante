package view;

import java.util.concurrent.Semaphore;

import controller.ThreadRestaurante;

public class mainRestaurante {

	public static void main(String[] args) {
		int  permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idPrato = 0; idPrato < 5; idPrato++) {
			Thread prato = new ThreadRestaurante(idPrato, semaforo);
			prato.start();
		}

	}

}
