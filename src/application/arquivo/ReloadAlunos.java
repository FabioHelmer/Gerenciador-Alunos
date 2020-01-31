package application.arquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import application.Metods;
import application.modal.Aluno;
import javafx.scene.control.Alert.AlertType;

public class ReloadAlunos {
	/*
	 * a classe reload e muito importante para o sistema, ela é responsavel por
	 * limpar o file e gravar todos os alunos de volta para isso um false em
	 * BufferedWriter saida foi adicionado esse parametro faz o bufferedwriter ficar
	 * com essa caracteristica
	 * 
	 */

	public static void reload(List<Aluno> alunos) {
		try {
			String arquivo = SelecionaArquivo.caminho();//recupero o file que vai ser manipulado
			BufferedWriter saida = new BufferedWriter(new FileWriter(arquivo, false));//responsavel por gravar no file
			System.out.println("----> iniciou o reload");
			for (Aluno aluno : alunos) {
				//grava os atributos do aluno do meu file
				saida.write(Metods.incLimp(aluno.getMatricula().toUpperCase() + "\t"));
				saida.write(Metods.incLimp(aluno.getIdade().toUpperCase() + "\t"));
				saida.write(Metods.incLimp(aluno.getRendimento().toUpperCase() + "\t"));
				saida.write(Metods.incLimp(aluno.getPeridoVigente().toUpperCase() + "\t"));
				saida.write(Metods.incLimp(aluno.getAltura().toUpperCase() + "\t"));
				saida.write(Metods.incLimp(aluno.getBoleanoEstagio().toUpperCase()) + "\t");
				saida.write(Metods.incLimp(aluno.getQuantLivrosAno().toUpperCase() + "\t"));
				saida.write(Metods.incLimp(aluno.getCidade().toUpperCase() + "\t"));
				saida.write(Metods.incLimp(aluno.getLinguagemProgramacaoFav().toUpperCase() + "\t"));
				saida.write(Metods.incLimp(aluno.getSerieFav().toUpperCase()) + "\t");
				saida.write(Metods.incLimp(aluno.getTimeFutebol().toUpperCase()) + "\t");
				saida.write(Metods.incLimp(aluno.getAndroidISO().toUpperCase() + "\r\n"));
			}

			saida.flush();
			saida.close();
			System.out.println("<sucesseful> final do reload com sucesso");
		} catch (Exception e) {
			Metods.alertas(AlertType.ERROR, "erro no sistema, contate suporte técnico").show();
			System.out.println("erro reload-> " + e.getStackTrace());
		}

	}

}
