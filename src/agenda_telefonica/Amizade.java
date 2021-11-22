package agenda_telefonica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Amizade {
	private int codigo1;
	private int codigo2;
	private String data_inicio;
	
	static final String DATABASE_URL = "jdbc:postgresql://localhost/pibd?user=postgres&password=postgres";
	static Connection con = null;
	
	public int getCodigo1() {
		return codigo1;
	}
	public void setCodigo1(int codigo1) {
		this.codigo1 = codigo1;
	}
	public int getCodigo2() {
		return codigo2;
	}
	public void setCodigo2(int codigo2) {
		this.codigo2 = codigo2;
	}
	public String getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	public void InsereAmizade(int codigo1, int codigo2, String data) {
		try {
			Amizade.con = DriverManager.getConnection(Amizade.DATABASE_URL);
			PreparedStatement insere = con.prepareStatement("insert into "
							+ "Amizade(codigo1, codigo2,data_inicio) "
							+ "values (?,?,?)");
			insere.setInt(1,codigo1);
			insere.setInt(2,codigo2);
			insere.setString(3, data);
			
		}catch(SQLException e){
			System.err.println(e);
		}catch(Exception e){
			System.err.println(e);
		}
	
	}
	
}
