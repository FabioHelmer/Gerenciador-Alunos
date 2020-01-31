package application;

import application.controller.AlterarController;
import application.controller.ArquivoController;
import application.modal.Aluno;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	public static Stage stage; //armazena minha cena pra depois abrir
	public static Scene mainScene; // cena principal
	public static Scene cadastroScene;// cena de cadastro
	public static Scene alterarScene;// cena de alteração
	public static Scene ArquivoScene;// sena de escolher o arquivo

	/*nesse main que o sistema é iniciado*/
	
	@Override
	public void start(Stage primaryStage) {
		stage=primaryStage;
		try {
			//carrego o fxml
			Pane fxmlArquivo = FXMLLoader.load(getClass().getResource("views/EscolheArquivoScreen.fxml"));
			fxmlArquivo.setMaxSize(770, 500);
			ArquivoScene = new Scene(fxmlArquivo, 770, 500); // seto a dimensão
			primaryStage.setScene(ArquivoScene);
			primaryStage.show();

		} catch (Exception e) {
			System.out.println("erro no mainArquivo->" + e.getMessage());

		}

	}

	public static void changeScreen(String scr) {
		/*metodo responsavel por troca de tela 
		 * 
		 * com isso so preciso chamar o metodo e dizer pra onde ir
		 * */
		
		switch (scr) {
		case "main":
			//crio a tela principal
			MainMain mainMain = new MainMain();
			try {
				//starto a tela principal
				mainMain.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case "cadastro":
			//cria a tela de incluir
			ManInc mainInc = new ManInc();
			try {
				//starto a tela de incluir
				mainInc.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;

		case "alt": {
			//crio a tela de alterar
			MainAlt mainAlt = new MainAlt();
			try {
				//starto a tela 
				mainAlt.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		default:
			System.out.println("opção changeScreen invalid");
			break;
		}
	}

	public String returnArquivo() {
		//retorno o arquivo guardado
		return ArquivoController.getArquivo();
	}

	public Main() {
		super();

	}

	public Main(String arString) {
		super();
		//guardo o arquivo selecionado
		ArquivoController.setArquivo(arString);

	}

	public static void main(String[] args) {
		launch(args);//inicia o sistema
	}

	public static void alt(Aluno aluno) {
		//guardo o aluno que eu cliquei no grid
		AlterarController.setAluno(aluno);
	}

}
