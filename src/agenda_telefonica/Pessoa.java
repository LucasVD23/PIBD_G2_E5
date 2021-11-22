package agenda_telefonica;

public class Pessoa {
	private int codigo;
	private String nome;
	private String data_nascimento;
	private String homepage;
	private String cep;
	private int numero;
	private String complemento;
	private int qtd_carros;
	private int qtd_amigos;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getQtd_amigos() {
		return qtd_amigos;
	}
	public void setQtd_amigos(int qtd_amigos) {
		this.qtd_amigos = qtd_amigos;
	}
	public int getQtd_carros() {
		return qtd_carros;
	}
	public void setQtd_carros(int qtd_carros) {
		this.qtd_carros = qtd_carros;
	}
}
