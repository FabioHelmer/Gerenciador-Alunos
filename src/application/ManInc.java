package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ManInc extends Application{
	/*cena de inclução de dados*/
	public static Stage stage;
	public static Scene cadastroScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage=primaryStage;
		
		 try {
			//carrego o fxml	
			Pane fxmlcadastro = FXMLLoader.load(getClass().getResource("views/cadastroAlunoScreen.fxml"));
			fxmlcadastro.setMaxSize(770, 500);
			cadastroScene = new Scene(fxmlcadastro,770, 500);								
				
			primaryStage.setScene(cadastroScene);
			primaryStage.show();
				
		} catch (Exception e) {
			System.out.println("erro no mainCad->"+e.getLocalizedMessage());

		} 
		
	}

}
