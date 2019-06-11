package teste;

import java.io.IOException;
import java.util.Scanner;

public class TesteEntrada {

	public static void main(String[] args) throws IOException {

		/*
		 * try { InputStream is = new FileInputStream("teste.txt"); InputStreamReader
		 * isr = new InputStreamReader(is); BufferedReader reader = new
		 * BufferedReader(isr); String linha = reader.readLine(); while(linha != null) {
		 * System.out.println(linha); linha = reader.readLine(); } reader.close(); }
		 * catch (IOException e) { System.out.println("Erro ao tentar ler o arquivo "+
		 * e); }
		 * 
		 * try { InputStream is = System.in; InputStreamReader isr = new
		 * InputStreamReader(is); BufferedReader reader = new BufferedReader(isr);
		 * String linha = reader.readLine(); while(linha != null) {
		 * System.out.println(linha); linha = reader.readLine(); } reader.close(); }
		 * catch (IOException e) { System.out.println("Erro ao tentar ler o arquivo "+
		 * e); }
		 * 
		 * try { Scanner sc = new Scanner(new File("teste.txt"));
		 * while(sc.hasNextLine()) { System.out.println(sc.nextLine()); } } catch
		 * (FileNotFoundException e) {
		 * System.out.println("Erro ao tentar ler o arquivo " + e); }
		 */
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		String nomeDigitado = sc.nextLine();
		System.out.println("Digite sua idade: ");
		int idadeDigitada = sc.nextInt();
		System.out.println("Nome: " + nomeDigitado);
		System.out.println("IdadE: " + idadeDigitada);

	}

}
