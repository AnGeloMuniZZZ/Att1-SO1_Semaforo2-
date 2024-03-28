package controller;

import java.util.concurrent.Semaphore;

public class ThreadTransito extends Thread {

	private int id;
	Semaphore semaforo;
	private String sentido;

	public ThreadTransito(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			passar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void passar() {
		try {
			switch ((int) ((Math.random() * 4) + 1)) {
			case 1:
				sentido = "norte";
				sleep(1000);
				System.out.println("Passou o " + id + "º no sentido " + sentido);
				break;
			case 2:
				sentido = "sul";
				sleep(1000);
				System.out.println("Passou o " + id + "º no sentido " + sentido);
				break;
			case 3:
				sentido = "leste";
				sleep(1000);
				System.out.println("Passou o " + id + "º no sentido " + sentido);
				break;
			case 4:
				sentido = "oeste";
				sleep(1000);
				System.out.println("Passou o " + id + "º no sentido " + sentido);
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}