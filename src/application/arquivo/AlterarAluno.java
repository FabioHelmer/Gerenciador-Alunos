package application.arquivo;

import java.util.List;

import application.modal.Aluno;

public class AlterarAluno {
	/*
	 * classe que vai alterar os dados de um aluno no arquivo
	 * 
	 * o altear assim como as outras manipulações foram feitas em cima do reload
	 * isto é apago todos os dados do arquivo e gravo de novo com as altearações
	 * 
	 */

	public static void alterar(Aluno selecionado) {
		RetornaListaAluno retorna = new RetornaListaAluno();
		List<Aluno> lista = retorna.listaAlunos();// recupero os alunos do file
		//trago todos os resultados que vão ser alteados (recuperação feita pela matricula)
		List<Aluno> alunoDelete = RetornaListaAluno.pesquisa(selecionado.getMatricula().toString());

		DeletarAluno.deletar(selecionado);//passo o aluno a ser alterado para ser apagado do arquivo
		IncluirAluno.salvar(selecionado);//incluo o aluno novamente no arquivo

	}
}
