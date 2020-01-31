package application.arquivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import application.Metods;
import application.modal.Aluno;

public class RetornaListaAluno {
	/*
	 * responsavel por ler o arquivo, encontrar cada valor dos alunos adicionar em
	 * uma lista e disponibilizar para todas as ouotras classes
	 * 
	 */

	public List<Aluno> listaAlunos() {
		System.out.println("criado por Fabio Helmer, Carlos Baraquiel, João Batista, Gustavo Lucas");
		StringBuffer memoria = new StringBuffer();
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.clear();

		try {

			String arquivo = SelecionaArquivo.caminho();// recupero o file

			BufferedReader arqentrada;
			arqentrada = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"));

			//arqentrada = new BufferedReader(new FileReader(arquivo));
			String linha;
			while ((linha = arqentrada.readLine()) != null) {//navega ate a ultima linha do file
				memoria.append(linha + "\r\n");

				if (linha == null) {
					return alunos;
				} else {
				
					if (!linha.equals("")) {
						Aluno aluno = new Aluno();
						String matricula = linha.subSequence(0, 8).toString();
						int inicio = -1;
						//indexof retorna diferernte de -1 
						inicio = memoria.indexOf(matricula);//pega o primeiro indice da linha
						if (inicio != -1) {
							int ultimo = memoria.indexOf("\t", inicio);
							try {
								aluno.setMatricula(Metods.retiraAcentos(ler(inicio, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setMatricula(null);
							}
							int primeiro = ultimo + 1;
							ultimo = memoria.indexOf("\t", primeiro);

							try {
								aluno.setIdade(Metods.retiraAcentos(ler(primeiro, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setIdade(null);
							}

							primeiro = ultimo + 1;
							ultimo = memoria.indexOf("\t", primeiro);

							try {
								aluno.setRendimento(Metods.retiraAcentos(ler(primeiro, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setRendimento(null);
							}

							primeiro = ultimo + 1;
							ultimo = memoria.indexOf("\t", primeiro);

							try {
								aluno.setPeridoVigente(Metods.retiraAcentos(ler(primeiro, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setPeridoVigente(null);
							}
							primeiro = ultimo + 1;
							ultimo = memoria.indexOf("\t", primeiro);
							try {
								aluno.setAltura(Metods.retiraAcentos(ler(primeiro, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setAltura(null);
							}

							primeiro = ultimo + 1;
							ultimo = memoria.indexOf("\t", primeiro);

							try {
								aluno.setBoleanoEstagio(Metods.retiraAcentos(ler(primeiro, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setBoleanoEstagio(null);
							}

							primeiro = ultimo + 1;
							ultimo = memoria.indexOf("\t", primeiro);

							try {
								aluno.setQuantLivrosAno(Metods.retiraAcentos(ler(primeiro, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setQuantLivrosAno(null);
							}

							primeiro = ultimo + 1;
							ultimo = memoria.indexOf("\t", primeiro);

							try {
								aluno.setCidade(Metods.retiraAcentos(ler(primeiro, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setCidade(null);
							}

							primeiro = ultimo + 1;
							ultimo = memoria.indexOf("\t", primeiro);

							try {
								aluno.setLinguagemProgramacaoFav(Metods.retiraAcentos(ler(primeiro, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setLinguagemProgramacaoFav(null);
							}

							primeiro = ultimo + 1;
							ultimo = memoria.indexOf("\t", primeiro);

							try {
								aluno.setSerieFav(Metods.retiraAcentos(ler(primeiro, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setSerieFav(null);
							}

							primeiro = ultimo + 1;
							ultimo = memoria.indexOf("\t", primeiro);

							try {
								aluno.setTimeFutebol(Metods.retiraAcentos(ler(primeiro, ultimo, memoria)));
							} catch (Exception e) {
								aluno.setTimeFutebol(null);
							}

							primeiro = ultimo + 1;
							int fim = memoria.indexOf("\n", primeiro);
							try {
								aluno.setAndroidISO(Metods.retiraAcentos(ler(primeiro, fim, memoria)));
							} catch (Exception e) {
								aluno.setAndroidISO(null);
							}

							alunos.add(aluno);
						}
					}
				}
			}

			arqentrada.close();
		} catch (Exception e) {
			System.out.println("erro listAluno->" + e.getMessage());
		}

		return alunos;

	}

	public static List<Aluno> pesquisa(String busca) {//pesquisa um aluno
		List<Aluno> pes = new ArrayList<Aluno>();
		RetornaListaAluno lista = new RetornaListaAluno();
		List<Aluno> temp = lista.listaAlunos();// recupera a lista de alunos do file
		pes.clear();
		//se a string busca conter numeros então a pesquisa e por matricula
		if (busca.matches("[0-9]+")) {
			for (Aluno aluno : temp) {
				if (busca.equalsIgnoreCase(aluno.getMatricula().toString())) {
					pes.add(aluno);
				}
			}
			//caso contrario é por pesquisa é cidade
		} else {
			for (Aluno aluno : temp) {
				if (busca.equalsIgnoreCase(aluno.getCidade().toString())) {
					pes.add(aluno);
				}
			}
		}

		return pes;
	}
	
	//metodo para ler os campos no file
	public String ler(int primeiro, int ultimo, StringBuffer memoria) {
		String dados = "";
		dados = memoria.substring(primeiro, ultimo).toUpperCase();

		return dados;
	}

}
