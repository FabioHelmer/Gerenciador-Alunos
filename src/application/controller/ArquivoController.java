package application.controller;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ArquivoController {
	/*
	 * controller da cena de escolher arquivo
	 * 
	 * */

	@FXML
	private Button btnEscolher;

	@FXML
	void escolherArquivo(ActionEvent event) {
		arquivo = caminho().toString();
		Main main = new Main(arquivo);
		setArquivo(arquivo);
		Main.changeScreen("main");
		System.out.println("criado por Fabio Helmer, Carlos Baraquiel, João Batista, Gustavo Lucas");

	}

	public static String caminho() {
		//inicia a teinha de navegação no windowns
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int result = fileChooser.showOpenDialog(null);
			if (result == JFileChooser.CANCEL_OPTION) {
				return null;
			}
			File arquivo = fileChooser.getSelectedFile();
			if (arquivo == null || arquivo.getName().equals("")) {
				JOptionPane.showMessageDialog(null, "Nome do arquivo Inválido");
			} else {
				System.out.println(arquivo.getPath());

				return arquivo.getPath();

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;

	}

	public static String arquivo;

	public static String getArquivo() {
		return arquivo;
	}

	public static void setArquivo(String arquivo) {
		ArquivoController.arquivo = arquivo;
		System.out.println(arquivo);

	}

}
