package teste;

import threads.ExportadorDeCSV;

public class TestandoThread {

	public static void main(String[] args) {
		
		ExportadorDeCSV exportador = new ExportadorDeCSV();
		Thread thread = new Thread(exportador);
		thread.start();
		System.out.println("Terminei de rodar o main");
	}
}
