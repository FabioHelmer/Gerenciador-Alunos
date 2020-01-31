package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Metods;
import application.arquivo.AlterarAluno;
import application.arquivo.RetornaListaAluno;
import application.modal.Aluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AlterarController implements Initializable{

	//campos do fxml
	
    @FXML
    private TextField tfMatricula;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField tfIdade;

    @FXML
    private TextField tfRendimento;

    @FXML
    private TextField tfAltura;

    @FXML
    private TextField tfBoleano;

    @FXML
    private TextField tflivros;

    @FXML
    private TextField tfcidade;

    @FXML
    private TextField tfLinguaPrograma;

    @FXML
    private TextField tfSerie;

    @FXML
    private TextField tfTime;

    @FXML
    private TextField tfAndroidIOS;

    @FXML
    private TextField tfPeriodoVigente;

    private static  Aluno aluno ;
    
    ArrayList<String> erros = new ArrayList<String>();
    
    @FXML
    void cancelar(ActionEvent event)   {
    	//função caso queira cancelar a alteração
    	Main.changeScreen("main");
    	limpaForm();
    }

    @FXML
    void confirmaAlt(ActionEvent event)  {
    	regrasNovo();
    	if (erros.size()==0) {
    		//caso não encontra erros
    		//encaminha o aluno alterado para a inclução no arquivo
    		AlterarAluno.alterar(getAluno());
    		limpaForm();
    		Main.changeScreen("main");
    		Metods.alertas(AlertType.CONFIRMATION, "Alteração concluída").show();
		}else {
			Metods.alertas(AlertType.ERROR, erros);
		}

    }
    
    public void regrasNovo() {
    	//valida os campos, faz alguns tratamentos de campos que não podem aceitar letras
    	//tranfere o valor do textfil para o aluno
    	try {
			String matricula = tfMatricula.getText().trim().toString();

			if (matricula.length() == 8) {
				RetornaListaAluno retornaListaAluno = new RetornaListaAluno();
				boolean matrciculaCad = false;

				if (getAluno().getMatricula().equals(matricula)) {
					aluno.setMatricula(tfMatricula.getText().trim().toString());
				} else {

					for (Aluno verifica : retornaListaAluno.listaAlunos()) {
						if (verifica.getMatricula().equals(matricula)) {
							erros.add("Matrícula ja cadastrada");
							matrciculaCad = true;
						}
					}
					if (matrciculaCad == false) {
						aluno.setMatricula(tfMatricula.getText().trim().toString());
					}
				}
			} else {
				erros.add("Matrícula deve ter 8 caracteres");
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
				if(tfBoleano.getText().equalsIgnoreCase("sim")) {
					aluno.setBoleanoEstagio("sim");
				}else 
					if(tfBoleano.getText().equalsIgnoreCase("não") || tfBoleano.getText().equalsIgnoreCase("nao") ) {
					aluno.setBoleanoEstagio("nao");
				}else {
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
		//valida se a string é numero ou possui letras
		try {
			double num = Double.parseDouble(fild);
		} catch (Exception e) {
			erros.add(campo+" não aceita letras");
		}
		
	}
    
    
    public void limpaForm() {
    	//apenas limpa no form
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
	
    public void iniAluno() {
    	//recupera o aluno selecionado no grid e distribui seus atributos nos textsFilds
    	
    	tfMatricula.setText(getAluno().getMatricula().toString());

    		
    	if(getAluno().getRendimento().toString().equals("NULL")||getAluno().getRendimento().toString().equals("-")) {
    		tfRendimento.setText("");
    	}else {
    		tfRendimento.setText(getAluno().getRendimento().toString());	
    	}

    	if(getAluno().getAltura().toString().trim().equals("NULL")||getAluno().getAltura().toString().equals("-")) {
    		tfAltura.setText("");
    	}else {
    		tfAltura.setText(getAluno().getAltura().toString());	
    	}
    	
    	if(getAluno().getAndroidISO().toString().trim().equals("NULL")||getAluno().getAndroidISO().trim().toString().equals("-")) {
    		tfAndroidIOS.setText("");
    	}else {
    		tfAndroidIOS.setText(getAluno().getAndroidISO().toString());	
    	}
    	
    	if(getAluno().getBoleanoEstagio().toString().equals("NULL")||getAluno().getBoleanoEstagio().toString().equals("-")) {
    		tfBoleano.setText("");
    	}else {
    		tfBoleano.setText(getAluno().getBoleanoEstagio().toString());	
    	}
    	
    	if(getAluno().getCidade().toString().equals("NULL")||getAluno().getCidade().toString().equals("-")) {
    		tfcidade.setText("");
    	}else {
    		tfcidade.setText(getAluno().getCidade().toString());	
    	}
    	
    	if(getAluno().getIdade().toString().equals("NULL")||getAluno().getIdade().toString().equals("-")) {
    		tfIdade.setText("");
    	}else {
    		tfIdade.setText(getAluno().getIdade().toString());	
    	}
    	
    	if(getAluno().getLinguagemProgramacaoFav().toString().equals("NULL")||getAluno().getLinguagemProgramacaoFav().toString().equals("-")) {
    		tfLinguaPrograma.setText("");
    	}else {
    		tfLinguaPrograma.setText(getAluno().getLinguagemProgramacaoFav().toString());	
    	}
    	
    	if(getAluno().getPeridoVigente().toString().equals("NULL")||getAluno().getPeridoVigente().toString().equals("-")) {
    		tfPeriodoVigente.setText("");
    	}else {
    		tfPeriodoVigente.setText(getAluno().getPeridoVigente().toString());	
    	}
    	
    	if(getAluno().getQuantLivrosAno().toString().equals("NULL")||getAluno().getQuantLivrosAno().toString().equals("-")) {
    		tflivros.setText("");
    	}else {
    		tflivros.setText(getAluno().getQuantLivrosAno().toString());	
    	}
    	if(getAluno().getSerieFav().toString().equals("NULL")||getAluno().getSerieFav().toString().equals("-")) {
    		tfSerie.setText("");
    	}else {
    		tfSerie.setText(getAluno().getSerieFav().toString());	
    	}
    	if(getAluno().getTimeFutebol().toString().equals("NULL")||getAluno().getTimeFutebol().toString().equals("-")) {
    		tfTime.setText("");
    	}else {
    		tfTime.setText(getAluno().getTimeFutebol().toString());	
    	}
    	
    }

	public static Aluno getAluno() {
		return aluno;
	}

	public static void setAluno(Aluno aluno) {
		AlterarController.aluno = aluno;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//inicia a classe de controle ta tela de alteração
		iniAluno();
	}

}
