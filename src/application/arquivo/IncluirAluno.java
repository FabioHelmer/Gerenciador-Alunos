package application.arquivo;

import java.util.ArrayList;
import java.util.List;

import application.Metods;
import application.modal.Aluno;
import javafx.scene.control.Alert.AlertType;

public class IncluirAluno {
	/*
	 * 
	 * incluir aluno apenas direciona o aluno para o reload assim o file vai ser
	 *  todo gravado de novo com a adição de mais um aluno 
	 * 
	 * */
	
	public static void salvar(Aluno aluno) {
		System.out.println("criado por Fabio Helmer, Carlos Baraquiel, João Batista, Gustavo Lucas");
		try {
			RetornaListaAluno retorna = new RetornaListaAluno();
			List<Aluno> alunos = new ArrayList<Aluno>();
			alunos=retorna.listaAlunos();//recupero a lista de alunos do file
			alunos.add(aluno);//inclui o novo aluno nessa lista
			System.out.println("adicioinou aluno a lista para reload");
			ReloadAlunos.reload(alunos);//mando a lista com o novo aluno para gravação
		} catch (Exception e) {
			Metods.callback(aluno);
			Metods.alertas(AlertType.ERROR, "erro no cadastro, contate suporte técnico").show();
			System.out.println("erro salvar-> "+e.getStackTrace());
		}
		
	
	}
	
	
}
