package application.modal;

public class Aluno {
	private String matricula;
	private String rendimento;
	private String idade;
	private String altura;
	private String peridoVigente;
	private String boleanoEstagio;
	private String quantLivrosAno;
	private String cidade;
	private String linguagemProgramacaoFav;
	private String serieFav;
	private String timeFutebol;
	private String androidISO;

	public Aluno(String matricula,  String rendimento, String idade, String altura,
			String peridoVigente, String boleanoEstagio, String quantLivrosAno, String cidade,
			String linguagemProgramacaoFav, String serieFav, String timeFutebol, String androidISO) {
		super();
		this.matricula = matricula;
		this.rendimento = rendimento;
		this.idade = idade;
		this.altura = altura;
		this.peridoVigente = peridoVigente;
		this.boleanoEstagio = boleanoEstagio;
		this.quantLivrosAno = quantLivrosAno;
		this.cidade = cidade;
		this.linguagemProgramacaoFav = linguagemProgramacaoFav;
		this.serieFav = serieFav;
		this.timeFutebol = timeFutebol;
		this.androidISO = androidISO;
	}

	public Aluno() {

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getRendimento() {
		return rendimento;
	}

	public void setRendimento(String rendimento) {
		this.rendimento = rendimento;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeridoVigente() {
		return peridoVigente;
	}

	public void setPeridoVigente(String peridoVigente) {
		this.peridoVigente = peridoVigente;
	}

	public String getBoleanoEstagio() {
		return boleanoEstagio;
	}

	public void setBoleanoEstagio(String boleanoEstagio) {
		this.boleanoEstagio = boleanoEstagio;
	}

	public String getQuantLivrosAno() {
		return quantLivrosAno;
	}

	public void setQuantLivrosAno(String quantLivrosAno) {
		this.quantLivrosAno = quantLivrosAno;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLinguagemProgramacaoFav() {
		return linguagemProgramacaoFav;
	}

	public void setLinguagemProgramacaoFav(String linguagemProgramacaoFav) {
		this.linguagemProgramacaoFav = linguagemProgramacaoFav;
	}

	public String getSerieFav() {
		return serieFav;
	}

	public void setSerieFav(String serieFav) {
		this.serieFav = serieFav;
	}

	public String getTimeFutebol() {
		return timeFutebol;
	}

	public void setTimeFutebol(String timeFutebol) {
		this.timeFutebol = timeFutebol;
	}

	public String getAndroidISO() {
		return androidISO;
	}

	public void setAndroidISO(String androidISO) {
		this.androidISO = androidISO;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", rendimento="
				+ rendimento + ", idade=" + idade + ", altura=" + altura + ", peridoVigente=" + peridoVigente
				+ ", boleanoEstagio=" + boleanoEstagio + ", quantLivrosAno=" + quantLivrosAno + ", cidade=" + cidade
				+ ", linguagemProgramacaoFav=" + linguagemProgramacaoFav + ", serieFav=" + serieFav + ", timeFutebol="
				+ timeFutebol + ", androidISO=" + androidISO + "]";
	}



}
