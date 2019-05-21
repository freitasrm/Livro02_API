package teste;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import br.com.casadocodigo.livraria.Autor;
import br.com.casadocodigo.livraria.produtos.Livro;
import br.com.casadocodigo.livraria.produtos.LivroFisico;
import br.com.casadocodigo.livraria.produtos.Produto;

public class Exportador {
	
	public static void main(String[] args) throws IOException{
		
		Livro livro = new LivroFisico(new Autor());
		livro.setNome("Java 8 Pr�tico");
		livro.setDescricao("Novos recursos da linguagem");
		livro.setValor(59.90);
		livro.setIsbn("978-85-66250-46-6");
		Livro maisUmlivro = new LivroFisico(new Autor());
		maisUmlivro.setNome("Desbravando a O.O.");
		maisUmlivro.setDescricao("Livro de Java e O.O");
		maisUmlivro.setValor(59.90);
		maisUmlivro.setIsbn("321-54-67890-11-2");
		new Exportador().paraCSV(Arrays.asList(livro, maisUmlivro));
		
	}
	
	public void paraCSV (List<Produto> produtos) throws IOException{
		
		PrintStream ps = new PrintStream("produtos.csv");
		ps.println("Nome; Descricao; Valor; ISBN");
		
		for(Produto produto: produtos) {
			ps.println(
					String.format("%s; %s; %s; %s",
						produto.getNome(),
						produto.getDescricao(),
						produto.getValor(),
						produto.getIsbn())
					);
		}
		
		ps.close();
		
	}

}
