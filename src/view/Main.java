package view;

import java.util.concurrent.Semaphore;

import controller.ThreadTransito;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for(int id = 1; id <11; id++) {
			Thread carro = new ThreadTransito(id,semaforo);
			carro.start();
		}
		
	}

}
