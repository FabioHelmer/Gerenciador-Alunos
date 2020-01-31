package application.arquivo;

import java.util.ArrayList;
import java.util.List;

import application.modal.Aluno;

public class DeletarAluno {
	public static void deletar(Aluno aluno) {
		/*
		 * o delete vai receber o aluno a ser deletado, retornar a lista de alunos que
		 * estao no file, vai encontrar o aluno a ser deletado nessa lista e vai retira-lo,
		 * e ai então gravar novamente no file a lista de alunos mas sem o aluno que foi
		 * deletado
		 * 
		 */

		RetornaListaAluno retorna = new RetornaListaAluno();
		System.out.println("criado por Fabio Helmer, Carlos Baraquiel, João Batista, Gustavo Lucas");
		List<Aluno> lista = retorna.listaAlunos();//retorno da lista de alunos no file
		List<Aluno> alunos = new ArrayList<Aluno>();//lista auxiliar
		
		//recupero todos os alunos com mesma matricula do aluno que vai ser deletado 
		//normalmenmte e so 1
		List<Aluno> alunodelete = RetornaListaAluno.pesquisa(aluno.getMatricula().toString());
		alunos.clear();

		String mat = alunodelete.get(0).getMatricula();

		for (Aluno al : lista) {
			if (!al.getMatricula().toString().equals(mat)) {
				//adiciono no list auxiliar todos os alunos que 
				//não tem a matricula do aluno a ser deletado
				alunos.add(al);
			}
		}
		ReloadAlunos.reload(alunos);//mando a lista de alunos para ser gravada sem o aluno deletado

	}
}
