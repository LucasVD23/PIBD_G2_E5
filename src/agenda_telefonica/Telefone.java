package agenda_telefonica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Telefone extends Abstract {
	private int codigo_pessoa;
	private String telefone;
	
	static Connection con = null;
	static Statement stm = null;
	static ResultSet rs = null;
	static ResultSetMetaData md = null;
	
	static String sel = "";
	
	public int getCodigo_pessoa() {
		return codigo_pessoa;
	}
	public void setCodigo_pessoa(int codigo_pessoa) {
		this.codigo_pessoa = codigo_pessoa;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public static void InsereTelefone(int codigo_pessoa, String telefone) {
		try {
			Telefone.con = DriverManager.getConnection(Telefone.DATABASE_URL);
			PreparedStatement insere = con.prepareStatement("insert into "
							+ "Telefone(codigo_pessoa, telefone) "
							+ "values (?,?)");
			insere.setInt(1,codigo_pessoa);
			insere.setString(2, telefone);

			insere.executeUpdate();
			
		}catch(SQLException e){
			System.err.println(e);
		}catch(Exception e){
			System.err.println(e);
		}
	
	}
	public static String SelecionaTelefones(String n) {
		try {
			// Abrir a conexão
			Telefone.con = DriverManager.getConnection(Telefone.DATABASE_URL);
			// Criar o comando
			stm = con.createStatement();
			if (n.length() > 0)
				rs = stm.executeQuery("select * from Telefone where codigo_pessoa = '" + n + "'");
			else
				rs = stm.executeQuery("select * from Telefone");
			// Criar o metadado da tabela
			md = rs.getMetaData();
			int nroColunas = md.getColumnCount();
			// Exibir os metadados/dados
			for (int i = 1; i <= nroColunas; i++)
				System.out.printf("%s\t", md.getColumnName(i));

			ArrayList<Telefone> d = new ArrayList<Telefone>();

			Telefone telefone1;

			int codigo_pessoa;
			String telefone;

			sel = "";
			// Usar os dados e mostra-los
			while (rs.next()) {

				telefone1 = new Telefone();

				codigo_pessoa = rs.getInt("codigo_pessoa");
				telefone = rs.getString("telefone");

				telefone1.setCodigo_pessoa(codigo_pessoa);
				telefone1.setTelefone(telefone);
				
				d.add(telefone1);
			}

			for (Telefone umTelefone : d) {
				sel = sel + umTelefone.getCodigo_pessoa() + ", " + umTelefone.getTelefone() 
						+ "\n ";

				System.out.printf("\n%d\t%s", umTelefone.getCodigo_pessoa(), umTelefone.getTelefone());
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
