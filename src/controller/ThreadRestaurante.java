package controller;

import java.util.concurrent.Semaphore;

public class ThreadRestaurante extends Thread {
	
	private int idPrato;
	private Semaphore semaforo;

	public ThreadRestaurante(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		if(idPrato % 2 == 1) {
			SopadeCebola();
		}
		if(idPrato % 2 == 0) {
			LasanhaBolonhesa();
		}
	}

	private void SopadeCebola() {
		int tempo = (int) (Math.random() * 501) + 300;
		int percentual = tempo / 100;
		System.out.println("O prato Sopa de Cebola iniciou... ");
		
		while(tempo > 0) {
			System.out.println("Percurso do prato Sopa de Cebola .... = "+percentual+"s para ficar pronto");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempo -= 100;
			percentual = tempo / 100;
		}
			System.out.println("Prato Concluido");
		
		
// ==============================SEÇÃO CRITICA =======================================================
		try {
			semaforo.acquire();
			System.out.println("Entrega do prato Sopa de Cebola de ID#"+idPrato);
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}
	private void LasanhaBolonhesa() {
		int tempo = (int) (Math.random() * 601) + 600;
		int percentual = tempo / 100;
		System.out.println("O prato Lasanha a Bolonhesa iniciou... ");
		
		while(tempo > 0) {
			System.out.println("Percurso do prato Lasanha a Bolonhesa .... = "+percentual+"s para ficar pronto");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempo -= 100;
			percentual = tempo / 100;
		}
			System.out.println("Prato Concluido");
		
		
// ==============================SEÇÃO CRITICA =======================================================
		try {
			semaforo.acquire();
			System.out.println("Entrega do prato Lasanha a Bolonhesa de ID#"+idPrato);
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		
	}

}
