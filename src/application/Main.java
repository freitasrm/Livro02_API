package application;

import java.io.IOException;

import br.com.casadocodigo.livraria.produtos.Produto;
import dao.ProdutoDAO;
import io.Exportador;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		// criar grupo para tabela com listagem
		Group group = new Group();
		// criar a tela
		Scene scene = new Scene(group, 690, 510);
		// importa css
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		ObservableList<Produto> produtos = new ProdutoDAO().lista();

		TableView tableView = new TableView<>(produtos);

		TableColumn nomeColumn = new TableColumn("Nome");
		nomeColumn.setMinWidth(180);
		nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));

		TableColumn descColumn = new TableColumn("Descrição");
		descColumn.setMinWidth(230);
		descColumn.setCellValueFactory(new PropertyValueFactory("descricao"));

		TableColumn valorColumn = new TableColumn("Valor");
		valorColumn.setMinWidth(60);
		valorColumn.setCellValueFactory(new PropertyValueFactory("valor"));

		TableColumn isbnColumn = new TableColumn("ISBN");
		isbnColumn.setMinWidth(180);
		isbnColumn.setCellValueFactory(new PropertyValueFactory("isbn"));

		tableView.getColumns().addAll(nomeColumn, descColumn, valorColumn, isbnColumn);

		final VBox vbox = new VBox(tableView);
		vbox.setId("vbox");
		// incluir um texto
		Label label = new Label("Listagem de Livros");
		label.setId("label-listagem");
		// alterar fonte e padding
		Label progresso = new Label();
		progresso.setId("label-progresso");
		// incluir botão
		Button button = new Button("Exportar CSV");
		// ação de exportar produtos em CSV
		button.setOnAction(event -> {
			// sincronismo, substituição runnable por task
			Task<Void> task = new Task<Void>() {
				@Override
				protected Void call() throws Exception {
					dormePorVinteSegundos();
					exportarEmCSV(produtos);
					return null;
				}
			};
			// usando a task para exibir mensagem de feedback
			task.setOnRunning(e -> progresso.setText("exportando..."));
			// usando a task para exibir mensagem de feedback
			task.setOnSucceeded(e -> progresso.setText("concluído!"));

			new Thread(task).start();
		});

		double valorTotal = produtos.stream().mapToDouble(Produto::getValor).sum();

		Label labelFooter = new Label(String.format("Você tem R$%.2f em estoque, " + "com um total de %d produtos.",
				valorTotal, produtos.size()));

		labelFooter.setId("label-footer");
		// vincular texto a tela atraves do grupo
		group.getChildren().addAll(label, vbox, button, progresso, labelFooter);
		// titulo da tela
		primaryStage.setTitle("Sistema da livraria com Java FX");
		// informando a tela do programa
		primaryStage.setScene(scene);
		// exibir no programa
		primaryStage.show();

	}

	private void exportarEmCSV(ObservableList<Produto> produtos) {
		try {
			new Exportador().paraCSV(produtos);
		} catch (IOException e) {
			System.out.println("Erro ao exportar: " + e);
		}
	}

	private void dormePorVinteSegundos() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			System.out.println("Ops, ocorreu um erro: " + e);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}