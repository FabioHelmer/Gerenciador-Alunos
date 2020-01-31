package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainAlt extends Application {
	/*cena de alterar os dados do aluno*/
	public static Scene alterarScene;
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		try {
			//carrego o fxml
			Pane fxmlAlterar = FXMLLoader.load(getClass().getResource("views/AlterandoAlunoScreen.fxml"));
			fxmlAlterar.setMaxSize(770, 500);
			alterarScene = new Scene(fxmlAlterar, 770, 500);

			primaryStage.setScene(alterarScene); //set da cena que vai ser aberta
			primaryStage.show();

		} catch (Exception e) {
			System.out.println("erro no mainAlt->" + e.getLocalizedMessage());

		}

	}

}
