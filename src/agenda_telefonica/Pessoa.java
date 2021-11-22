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

	static String sel = "";

	static final String DATABASE_URL = "jdbc:postgresql://localhost/agenda_telefonica?user=root&password=root";
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

	public void InserePessoa(int codigo, String nome, String homepage, String cep, int numero, String complemento,
			int qtd_carros, int qtd_amigos) {
		try {
			Pessoa.con = DriverManager.getConnection(Pessoa.DATABASE_URL);
			PreparedStatement insere = con.prepareStatement(
					"insert into " + "Pessoa(codigo,nome,homepage,cep,numero,complemento,qtd_carros,qtd_amigos) "
							+ "values (?,?,?,?,?,?,?,?)");
			insere.setInt(1, codigo);
			insere.setString(2, nome);
			insere.setString(3, homepage);
			insere.setString(4, cep);
			insere.setInt(5, numero);
			insere.setString(6, complemento);
			insere.setInt(7, qtd_amigos);
			insere.setInt(8, qtd_amigos);

		} catch (SQLException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public static String SelecionaPessoa(String n) {
		try {
			// Abrir a conexão
			Pessoa.con = DriverManager.getConnection(Pessoa.DATABASE_URL);
			// Criar o comando
			stm = con.createStatement();
			rs = stm.executeQuery("select * from Pessoa where pessoa.nome = '" + n + "'");
			// Criar o metadado da tabela
			md = rs.getMetaData();
			int nroColunas = md.getColumnCount();
			// Exibir os metadados/dados
			for (int i = 1; i <= nroColunas; i++)
				System.out.printf("%s\t", md.getColumnName(i));

			ArrayList<Pessoa> d = new ArrayList<Pessoa>();

			Pessoa Pessoa1;

			int cod;
			String nome;
			String dtn;
			String home;
			String cep;
			int num;
			String compl;
			int qtd_c;
			int qtd_a;
			sel = "";
			// Usar os dados e mostra-los
			while (rs.next()) {

				Pessoa1 = new Pessoa();

				cod = rs.getInt("codigo");
				nome = rs.getString("nome");
				dtn = rs.getString("data_nascimento");
				home = rs.getString("homepage");
				cep = rs.getString("cep");
				compl = rs.getString("complemento");
				num = rs.getInt("numero");
				qtd_c = rs.getInt("qtd_carros");
				qtd_a = rs.getInt("qtd_amigos");

				Pessoa1.setCodigo(cod);
				Pessoa1.setNome(nome);
				Pessoa1.setData_nascimento(dtn);
				Pessoa1.setHomepage(home);
				Pessoa1.setCep(cep);
				Pessoa1.setNumero(num);
				Pessoa1.setComplemento(compl);
				Pessoa1.setQtd_carros(qtd_c);
				Pessoa1.setQtd_amigos(qtd_a);
				d.add(Pessoa1);
				System.out.println("x");
			}

			for (Pessoa umPessoa : d) {
				sel = sel + umPessoa.getCodigo() + ", " + umPessoa.getNome() + ", " + umPessoa.getData_nascimento()
						+ ", " + umPessoa.getHomepage() + ", " + umPessoa.getCep() + ", " + umPessoa.getNumero() + ", "
						+ umPessoa.getComplemento() + ", " + umPessoa.getQtd_carros() + ", " + umPessoa.getQtd_amigos()
						+ "\n ";

				System.out.printf("\n%d\t%s\t%s\t%s\t%s\t%d\t%s\t%d\t%d", umPessoa.getCodigo(), umPessoa.getNome(),
						umPessoa.getData_nascimento(), umPessoa.getHomepage(), umPessoa.getCep(), umPessoa.getNumero(),
						umPessoa.getComplemento(), umPessoa.getQtd_carros(), umPessoa.getQtd_amigos());
			}
			// Fechar os objetos
			rs.close();
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}
		return sel;
	}
}
