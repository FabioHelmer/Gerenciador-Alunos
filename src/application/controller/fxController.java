package application.controller;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Metods;
import application.arquivo.DeletarAluno;
import application.arquivo.RetornaListaAluno;
import application.modal.Aluno;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class fxController implements Initializable {

	// campos do fxml

	@FXML
	private Label lab1;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnAlterar;

	@FXML
	private Button btnPesquisa;

	@FXML
	private Button btnRefresh;

	@FXML
	private TextField tfPesquisa;

	@FXML
	public TableView<Aluno> tableView;

	@FXML
	private TableColumn<Aluno, String> colunMatricula;

	@FXML
	private TableColumn<Aluno, String> colunIdade;

	@FXML
	private TableColumn<Aluno, String> colunIndiceRendimento;

	@FXML
	private TableColumn<Aluno, String> columPerido;

	@FXML
	private TableColumn<Aluno, String> columAltura;

	@FXML
	private TableColumn<Aluno, String> columFazEstagio;

	@FXML
	private TableColumn<Aluno, String> columLivros;

	@FXML
	private TableColumn<Aluno, String> columCidade;

	@FXML
	private TableColumn<Aluno, String> columLingProg;

	@FXML
	private TableColumn<Aluno, String> columSerie;

	@FXML
	private TableColumn<Aluno, String> columTime;

	@FXML
	private TableColumn<Aluno, String> columAndroidISO;

	private Aluno selecionado;// guarda o aluno selecionado no grid

	@FXML
	void deletar(ActionEvent event) {
		// ação do btn deletar
		if (selecionado == null) {
			// se não tiver aluno selecionado não pode excluir
			Main.changeScreen("main");
			Metods.alertas(AlertType.WARNING, "É preciso selecionar um aluno").show();
			selecionado = null;
		} else {
			deleta();//encaminha para  o metodo de deletar
			Main.changeScreen("main");
		}
	}

	@FXML
	void alterar(ActionEvent event) {
		//ação do btn de alterar
		//leva pra tela de alteração
		if (selecionado == null) {
			// se não tiver aluno selecionado não pode alterar
			Main.changeScreen("main");
			Metods.alertas(AlertType.WARNING, "É preciso selecionar um aluno").show();
			selecionado = null;

		} else {
			Main.alt(selecionado);//guarda o aluno selecionado na classe main
			Main.changeScreen("alt");
			initTable();//inicia o grid
		}

	}


	@FXML
	void pesquisar(ActionEvent event) {
		//ação do btn de peqsuisa
		String busca = tfPesquisa.getText().trim().toString();
		if (!busca.equals("")) {
			tablePes(busca);
		} else {
			initTable();
		}
	}

	@FXML
	public void novo(ActionEvent event) {
		//leva pra tela de novo aluno
		try {
			Main.changeScreen("cadastro");
		} catch (Exception e) {
			Metods.alertas(AlertType.ERROR, "erro ao inserir novo registro");
		}

	}

	public void initTable() {
		//inicia os dados no grid 
		colunMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
		colunIndiceRendimento.setCellValueFactory(new PropertyValueFactory("rendimento"));
		columAltura.setCellValueFactory(new PropertyValueFactory("altura"));
		colunIdade.setCellValueFactory(new PropertyValueFactory("idade"));
		columAndroidISO.setCellValueFactory(new PropertyValueFactory("androidISO"));
		columCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
		columFazEstagio.setCellValueFactory(new PropertyValueFactory("boleanoEstagio"));
		columLingProg.setCellValueFactory(new PropertyValueFactory("linguagemProgramacaoFav"));
		columLivros.setCellValueFactory(new PropertyValueFactory("quantLivrosAno"));
		columPerido.setCellValueFactory(new PropertyValueFactory("peridoVigente"));
		columSerie.setCellValueFactory(new PropertyValueFactory("serieFav"));
		columTime.setCellValueFactory(new PropertyValueFactory("timeFutebol"));
		tableView.setItems(atualizaTable());
	}

	public ObservableList<Aluno> atualizaTable() {
		//grid escherga os dados de uma observableList
		try {
			RetornaListaAluno retorna = new RetornaListaAluno();
			return FXCollections.observableArrayList(retorna.listaAlunos());
		} catch (Exception e) {
			System.out.println("erro no observablelist->" + e.getMessage());
		}
		return null;
	}

	public void tablePes(String busca) {
		//mostra os dados referernte a pesquisa
		colunMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
		colunIndiceRendimento.setCellValueFactory(new PropertyValueFactory("rendimento"));
		columAltura.setCellValueFactory(new PropertyValueFactory("altura"));
		colunIdade.setCellValueFactory(new PropertyValueFactory("idade"));
		columAndroidISO.setCellValueFactory(new PropertyValueFactory("androidISO"));
		columCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
		columFazEstagio.setCellValueFactory(new PropertyValueFactory("boleanoEstagio"));
		columLingProg.setCellValueFactory(new PropertyValueFactory("linguagemProgramacaoFav"));
		columLivros.setCellValueFactory(new PropertyValueFactory("quantLivrosAno"));
		columPerido.setCellValueFactory(new PropertyValueFactory("peridoVigente"));
		columSerie.setCellValueFactory(new PropertyValueFactory("serieFav"));
		columTime.setCellValueFactory(new PropertyValueFactory("timeFutebol"));
		tableView.setItems(atualizaTablePes(busca));
	}

	public ObservableList<Aluno> atualizaTablePes(String busca) {
		//contem apenas os dados da pesqusa para o grid mostrar
		try {
			RetornaListaAluno lista = new RetornaListaAluno();
			return FXCollections.observableArrayList(lista.pesquisa(busca));
		} catch (Exception e) {
			System.out.println("erro no observablelist->" + e.getMessage());
		}
		return null;
	}

	public void deleta() {
		DeletarAluno.deletar(selecionado);
	}

	private String arquivo;

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTable();
		
		//metodo ´para recupar a linha do grid que representa um aluno
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				selecionado = (Aluno) newValue;

			}
		});

	}

}
