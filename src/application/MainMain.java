package application;

import application.arquivo.RetornaListaAluno;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMain extends Application {
	/*cena principal*/
	public static Stage stage;
	public static Scene mainScene;
	RetornaListaAluno retorna = new RetornaListaAluno();

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		try {
			//carrego o fxml
			Pane fxmlmain = FXMLLoader.load(getClass().getResource("views/mainScreen.fxml"));
			fxmlmain.setMaxSize(785, 500);
			mainScene = new Scene(fxmlmain, 1300, 647);
			primaryStage.setScene(mainScene); //set da cena que vai abrir
			primaryStage.show();

		} catch (Exception e) {
			System.out.println("erro no mainStart->" + e.getMessage());

		}

	}

}
