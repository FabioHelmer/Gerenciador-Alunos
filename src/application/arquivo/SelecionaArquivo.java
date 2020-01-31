package application.arquivo;

import application.controller.ArquivoController;

public class SelecionaArquivo {
	/*
	 * apenas reorna e disponibiliza para as outras classes o caminho do file
	 */

	public static String caminho() {
		try {
			String arquivo = ArquivoController.getArquivo().toString();
			return arquivo;

		} catch (Exception e) {

		}

		return null;

	}
}
