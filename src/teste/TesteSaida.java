package teste;

import java.io.IOException;
import java.io.PrintStream;

public class TesteSaida {

	public static void main(String[] args) throws IOException {

		/*
		 * OutputStream os = new FileOutputStream("saida.txt"); OutputStreamWriter osw =
		 * new OutputStreamWriter(os); BufferedWriter bw = new BufferedWriter(osw);
		 * 
		 * bw.write("Testando a escrita em arquivo"); bw.newLine();
		 * bw.write("Conte�do na pr�xima linha"); bw.close();
		 */

		// gravando arquiv
		// PrintStream out = new PrintStream("saida.txt");
		// sa�da no console
		PrintStream out = System.out;
		out.println("Testando a escrita em arquivo");
		out.println("Conte�do na pr�xima linha");
		out.close();

	}

}
