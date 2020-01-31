package application;

import java.util.ArrayList;

import application.modal.Aluno;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Metods {
	/* Metodos que posso reutilizar */

	public static Alert alertas(AlertType alertType, String msg) {
		// cria um alerta com apenas uma msg
		// é preciso chamar o .show
		Alert alerta = new Alert(alertType);
		alerta.setContentText(msg);

		return alerta;
	}

	public static void alertas(AlertType alertType, ArrayList<String> listaErro) {
		// cria um alerta com uma lista de msg
		// não precisa chamar o show
		Alert alerta = new Alert(alertType);

		String erro = "";

		for (int i = 0; i < listaErro.size(); i++) {
			erro += listaErro.get(i) + "\n";
		}

		alerta.setContentText(erro);
		alerta.show();
		listaErro.clear();
	}
	
	public static String retiraAcentos(String input) {
		input.toUpperCase();
		return input.replaceAll("NULL", "-")
				.replaceAll("Á|À|Â|Ã|Ä","A")
				.replaceAll("É|È|Ê|Ë","E")
				.replaceAll("Ú|Ù|Û|Ü","U")
				.replaceAll("Í|Ì","I")
				.replaceAll("Ó|Ò|Ö","O")
				.replaceAll(",", ".");
	}
	public static String incLimp(String input) {
		input.toUpperCase();
		return input.replaceAll("Á|À|Â|Ã|Ä","A")
				.replaceAll("É|È|Ê|Ë","E")
				.replaceAll("Ú|Ù|Û|Ü","U")
				.replaceAll("Í|Ì","I")
				.replaceAll("Ó|Ò|Ö","O");
	}

	public static void callback(Aluno aluno) {
		//esvazio o aluno
		aluno = null;
	}

}
