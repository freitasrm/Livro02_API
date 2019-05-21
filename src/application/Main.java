package application;
	
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import br.com.casadocodigo.livraria.produtos.Produto;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import repositorio.RepositorioDeProdutos;

@SuppressWarnings({ "unchecked", "rawtypes"})
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
																				// criar grupo para tabela com listagem
		Group group = new Group();
																				// criar a tela
		Scene scene = new Scene(group,690,510);
		
		ObservableList<Produto> produtos = new RepositorioDeProdutos().lista();
		
		TableView tableView = new TableView<>(produtos);
		
		TableColumn nomeColumn = new TableColumn("Nome");
		nomeColumn.setMinWidth(180);
		nomeColumn.setCellValueFactory( new PropertyValueFactory("nome"));
		
		TableColumn descColumn = new TableColumn("Descrição");
		descColumn.setMinWidth(230);
		descColumn.setCellValueFactory( new PropertyValueFactory("descricao"));
		
		TableColumn valorColumn = new TableColumn("Valor");
		valorColumn.setMinWidth(60);
		valorColumn.setCellValueFactory( new PropertyValueFactory("valor"));

		TableColumn isbnColumn = new TableColumn("ISBN");
		isbnColumn.setMinWidth(180);
		isbnColumn.setCellValueFactory( new PropertyValueFactory("isbn"));
		
		tableView.getColumns().addAll(nomeColumn, descColumn, valorColumn, isbnColumn);
		
		final VBox vbox = new VBox(tableView);
		vbox.setPadding(new Insets(70, 0, 0, 10));

																				// incluir um texto
		Label label = new Label("Listagem de Livros");
																				// alterar fonte e padding
		label.setFont(Font.font("Lucida Grande", FontPosture.REGULAR, 30));
		label.setPadding(new Insets(20, 0, 10, 10));
		
																				//vincular texto a tela atraves do grupo
		group.getChildren().addAll(label, vbox);
																				// titulo da tela
		primaryStage.setTitle("Sistema da livraria com Java FX");
																				// informando a tela do programa
		primaryStage.setScene(scene);
																				// exibir no programa
		primaryStage.show();
		
		/*
		try {
			InputStream is = new FileInputStream("teste.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			String linha = reader.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Erro ao tentar ler o arquivo "+ e);
		}

		try {
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			String linha = reader.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Erro ao tentar ler o arquivo "+ e);
		}
		
		try {
			Scanner sc = new Scanner(new File("teste.txt"));
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao tentar ler o arquivo " + e);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		String nomeDigitado = sc.nextLine();
		System.out.println("Digite sua idade: ");
		int idadeDigitada = sc.nextInt();
		System.out.println("Nome: "+nomeDigitado);
		System.out.println("IdadE: "+ idadeDigitada);
		 */
		
		try{
			OutputStream os = new FileOutputStream("saida.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write("Testando a escrita em arquivo");
			bw.newLine();
			bw.write("Conteúdo na próxima linha");
			bw.write("Testando a escrita em arquivo\n");
			bw.write("Conteúdo na próxima linha");
			
			bw.close();
		} catch (IOException e) {
			System.out.println("Arquivo não encontrado");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}