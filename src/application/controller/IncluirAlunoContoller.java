package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.Metods;
import application.arquivo.IncluirAluno;
import application.arquivo.RetornaListaAluno;
import application.modal.Aluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class IncluirAlunoContoller implements Initializable {

	ArrayList<String> erros = new ArrayList<String>();
	public Aluno aluno = new Aluno();

	//campos do fxml
	
	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfNomeMae;

	@FXML
	private TextField tfRendimento;

	@FXML
	private TextField tfIdade;

	@FXML
	private TextField tfMatricula;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnfechar;

	@FXML
	private TextField tfAltura;

	@FXML
	private TextField tfBoleano;

	@FXML
	private TextField tflivros;

	@FXML
	private TextField tfcidade;

	@FXML
	private TextField tfPeriodoVigente;

	@FXML
	private TextField tfLinguaPrograma;

	@FXML
	private TextField tfSerie;

	@FXML
	private TextField tfTime;

	@FXML
	private TextField tfAndroidIOS;

	@FXML
	void salvarAction(ActionEvent event) {
		//ação do btn salvar 
		regrasNovo();
		if (erros.size() == 0) {
			//se não tiver erros pode salvar
			IncluirAluno.salvar(aluno);
			limpaForm();
			Main main = new Main(ArquivoController.getArquivo());
			try {
				main.changeScreen("main");
			} catch (Exception e) {
				e.printStackTrace();
			}
			Metods.alertas(AlertType.CONFIRMATION, "cadastro concluído").show();
		} else {
			Metods.alertas(AlertType.ERROR, erros);
			erros.clear();
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void fecharAction(ActionEvent event) {
		//fecha a tela de cadastro
		try {
			Main.changeScreen("main");
		} catch (Exception e) {
			e.printStackTrace();
		}
		limpaForm();

	}

	public void regrasNovo() {
		//validação de campos obrigatorios e campos qu nçao podem ter letras
		try {
			if(tfMatricula.getText().trim().toString().length()>0&& (tfMatricula!=null)) {
				RetornaListaAluno retorna = new RetornaListaAluno();
				Boolean cadmatricula=false;
				for (Aluno verifica: retorna.listaAlunos()) {
					if(verifica.getMatricula().equalsIgnoreCase(tfMatricula.getText().trim().toString())) {
						erros.add("Mátricula ja cadastrada");
						cadmatricula=true;
					}
				}
				if (cadmatricula == false) {
					if ((tfMatricula.getText().trim().toString().length() < 8)
							|| (tfMatricula.getText().trim().toString().length() > 8)) {
						erros.add("Matrícula deve ter 8 caracteres");
					}else {
						aluno.setMatricula(tfMatricula.getText().trim().toString());	
					}
				}
			}else {
				erros.add("Matrícula é obigatótia");
			}
			

			if (tfRendimento == null || tfRendimento.getText().isEmpty()) {
				erros.add("indice de rendimento é Obrigatorio");
			} else {
				verificaLetra(tfRendimento.getText().toString(), "Indice de rendimento");
				aluno.setRendimento(tfRendimento.getText().trim().toString());
			}

			if (tfIdade == null || tfIdade.getText().isEmpty()) {
				aluno.setIdade("null");
			} else {
				verificaLetra(tfIdade.getText().trim().toString(), "Idade");
				aluno.setIdade(tfIdade.getText().trim().toString());
			}

			if (tfAltura == null || tfAltura.getText().isEmpty()) {
				aluno.setAltura("null");
			} else {
				verificaLetra(tfAltura.getText().trim().toString(), "Altura");
				aluno.setAltura(tfAltura.getText().trim().toString());
			}

			if (tfPeriodoVigente == null || tfPeriodoVigente.getText().isEmpty()) {
				aluno.setPeridoVigente("null");
			} else {
				verificaLetra(tfPeriodoVigente.getText().trim().toString(), "Perido Vigencia");
				aluno.setPeridoVigente(tfPeriodoVigente.getText().trim().toString());
			}

			if (tfBoleano == null || tfBoleano.getText().isEmpty()) {
				aluno.setBoleanoEstagio("null");
			} else {
				if (tfBoleano.getText().equalsIgnoreCase("sim")) {
					aluno.setBoleanoEstagio("sim");
				} else if (tfBoleano.getText().equalsIgnoreCase("não") || tfBoleano.getText().equalsIgnoreCase("nao")) {
					aluno.setBoleanoEstagio("nao");
				} else {
					erros.add("Faz estágio somente Sim ou Não");
				}

			}

			if (tflivros == null || tflivros.getText().isEmpty()) {
				aluno.setQuantLivrosAno("null");
			} else {
				verificaLetra(tflivros.getText().trim().toString(), "quantidade de livros por ano");
				aluno.setQuantLivrosAno(tflivros.getText().trim().toString());
			}

			if (tfcidade == null || tfcidade.getText().isEmpty()) {
				aluno.setCidade("null");
			} else {
				aluno.setCidade(tfcidade.getText().trim().toString());
			}

			if (tfLinguaPrograma == null || tfLinguaPrograma.getText().isEmpty()) {
				aluno.setLinguagemProgramacaoFav("null");
			} else {
				aluno.setLinguagemProgramacaoFav(tfLinguaPrograma.getText().trim().toString());
			}

			if (tfSerie == null || tfSerie.getText().isEmpty()) {
				aluno.setSerieFav("null");
			} else {
				aluno.setSerieFav(tfSerie.getText().trim().toString());
			}

			if (tfTime == null || tfTime.getText().isEmpty()) {
				aluno.setTimeFutebol("null");
			} else {
				aluno.setTimeFutebol(tfTime.getText().trim().toString());
			}

			if (tfAndroidIOS == null || tfAndroidIOS.getText().isEmpty()) {
				aluno.setAndroidISO("null");
			} else {
				aluno.setAndroidISO(tfAndroidIOS.getText().trim().toString());
			}

		} catch (Exception e) {
			System.out.println("erro regras->" + e.getMessage());
		}

	}

	public void verificaLetra(String fild, String campo) {
		//verifica se no campo tem letras
		try {
			double num = Double.parseDouble(fild);
		} catch (Exception e) {
			erros.add(campo + " não aceita letras");
		}

	}
	public void limpaForm() {
		//limpa os dados no form
		tfMatricula.setText("");
		tfRendimento.setText("");
		tfIdade.setText("");
		tfAltura.setText("");
		tfAndroidIOS.setText("");
		tfBoleano.setText("");
		tfcidade.setText("");
		tfLinguaPrograma.setText("");
		tflivros.setText("");
		tfPeriodoVigente.setText("");
		tfSerie.setText("");
		tfTime.setText("");
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
}