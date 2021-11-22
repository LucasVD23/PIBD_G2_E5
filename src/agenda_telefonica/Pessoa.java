package agenda_telefonica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	static final String DATABASE_URL = "jdbc:postgresql://localhost/pibd?user=postgres&password=postgres";
	static Connection con = null;
	static Statement stm = null;
	static ResultSet rs = null;
	static ResultSetMetaData md = null;
	
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
	
	
	public void InserePessoa(int codigo, String nome, String homepage,String cep, int numero, String complemento, int qtd_carros,int qtd_amigos) {
		try {
			Pessoa.con = DriverManager.getConnection(Pessoa.DATABASE_URL);
			PreparedStatement insere = con.prepareStatement("insert into "
							+ "Pessoa(codigo,nome,homepage,cep,numero,complemento,qtd_carros,qtd_amigos) "
							+ "values (?,?,?,?,?,?,?,?)");
			insere.setInt(1,codigo);
			insere.setString(2, nome);
			insere.setString(3,homepage);
			insere.setString(4,cep);
			insere.setInt(5,numero);
			insere.setString(6, complemento);
			insere.setInt(7, qtd_amigos);
			insere.setInt(8, qtd_amigos);
			
		}catch(SQLException e){
			System.err.println(e);
		}catch(Exception e){
			System.err.println(e);
		}
	
	}
	public void SelecionaPessoa() {
		try{
			//Abrir a conexão
			con = DriverManager.getConnection(DATABASE_URL,"postgres","postgres");
			//Criar o comando
			stm = con.createStatement();
			rs = stm.executeQuery("select * from dvd");
			//Criar o metadado da tabela
			md = rs.getMetaData();
			int nroColunas = md.getColumnCount();
			//Exibir os metadados/dados
			for(int i = 1; i <= nroColunas; i++)
				System.out.printf("%s\t",
						md.getColumnName(i));
			
			ArrayList<Pessoa> p = new ArrayList<Pessoa>();
			int cod;
			String nome;
			String data_nasc;
			String home;
			String cep;
			int numero;
			String complemento;
			int qtd_carros;
			int qtd_amigos;
			Pessoa p1;
			//Usar os dados e mostra-los
			while(rs.next()){
				cod = rs.getInt("codigo");
				nome = rs.getString("nome");
				data_nasc = rs.getString("data_nascimento");
				home = rs.getString("hompage");
				cep = rs.getString("cep");
				numero = rs.getInt("numero");
				complemento = rs.getString("complemento");
				qtd_carros = rs.getInt("qtd_carros");
				qtd_amigos = rs.getInt("qtd_amigos");
				
				p1 = new Pessoa();
				p1.setCodigo(cod);
				p1.setNome(nome);
				p1.setData_nascimento(data_nasc);
				p1.setHomepage(home);
				p1.setCep(cep);
				p1.setNumero(numero);
				p1.setComplemento(complemento);
				p1.setQtd_carros(qtd_carros);
				p1.setQtd_amigos(qtd_amigos);
			}
			
			for(Pessoa umaPessoa : p){
				System.out.printf("\n%d\t%s\t%s\t%s\t%s\t%d\t%s\t%d\t%d",
						umaPessoa.getCodigo(),
						umaPessoa.getNome(),
						umaPessoa.getData_nascimento(),
						umaPessoa.getHomepage(),
						umaPessoa.getNumero(),
						umaPessoa.getComplemento(),
						umaPessoa.getQtd_carros(),
						umaPessoa.getQtd_amigos());
			}
			//Fechar os objetos
			rs.close();
			stm.close();
			con.close();	
		}catch(SQLException e){
			System.err.println(e);
		}catch(Exception e){
			System.err.println(e);
		}
	}
}
