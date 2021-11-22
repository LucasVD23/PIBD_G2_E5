package agenda_telefonica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Possui {
	private int codigoPessoa;
	private String placa;
	
	static final String DATABASE_URL = "jdbc:postgresql://localhost/pibd?user=postgres&password=postgres";
	static Connection con = null;
	
	public int getCodigoPessoa() {
		return codigoPessoa;
	}
	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public void InserePossui(int codigoPessoa, String placa) {
		try {
			Possui.con = DriverManager.getConnection(Possui.DATABASE_URL);
			PreparedStatement insere = con.prepareStatement("insert into "
							+ "Possui(codigoPessoa, placa) "
							+ "values (?,?)");
			insere.setInt(1,codigoPessoa);
			insere.setString(2, placa);
			
		}catch(SQLException e){
			System.err.println(e);
		}catch(Exception e){
			System.err.println(e);
		}
	
	}
}
