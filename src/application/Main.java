package application;
	
import java.io.IOException;

import br.com.casadocodigo.livraria.produtos.Produto;
import dao.ProdutoDAO;
import io.Exportador;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

@SuppressWarnings({ "unchecked", "rawtypes"})
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
																				// criar grupo para tabela com listagem
		Group group = new Group();
																				// criar a tela
		Scene scene = new Scene(group,690,510);
		
		ObservableList<Produto> produtos = new ProdutoDAO().lista();
		
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
																				// incluir botão
		Button button = new Button("Exportar CSV");
		button.setLayoutX(575);
		button.setLayoutY(25);
																				// ação de exportar produtos em CSV
		button.setOnAction(event -> exportarEmCSV(produtos));
																				//vincular texto a tela atraves do grupo
		group.getChildren().addAll(label, vbox, button);
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

	public static void main(String[] args) {
		launch(args);
	}
}