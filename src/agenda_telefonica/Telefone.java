package agenda_telefonica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Telefone {
	private int codigo_pessoa;
	private String telefone;
	
	static final String DATABASE_URL = "jdbc:postgresql://localhost/pibd?user=postgres&password=postgres";
	static Connection con = null;
	
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
	public void InsereTelefone(int codigo_pessoa, String telefone) {
		try {
			Telefone.con = DriverManager.getConnection(Telefone.DATABASE_URL);
			PreparedStatement insere = con.prepareStatement("insert into "
							+ "Telefone(codigo_pessoa, telefone) "
							+ "values (?,?)");
			insere.setInt(1,codigo_pessoa);
			insere.setString(2, telefone);
			
		}catch(SQLException e){
			System.err.println(e);
		}catch(Exception e){
			System.err.println(e);
		}
	
	}
}
