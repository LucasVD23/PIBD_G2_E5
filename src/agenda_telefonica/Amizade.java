package agenda_telefonica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Amizade extends Abstract{
	private int codigo1;
	private int codigo2;
	private String data_inicio;
	
	static Connection con = null;
	static Statement stm = null;
	static ResultSet rs = null;
	static ResultSetMetaData md = null;
	
	static String sel = "";
	
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
	
	public static void InsereAmizade(int codigo1, int codigo2, String data) {
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
	public static String SelecionaAmizade(String n) {
		try {
			// Abrir a conexão
			Amizade.con = DriverManager.getConnection(Amizade.DATABASE_URL);
			// Criar o comando
			stm = con.createStatement();
			if (n.length() > 0)
				rs = stm.executeQuery("select * from Amizade where Amizde.codigo1 = '" + n + "'");
			else
				rs = stm.executeQuery("select * from Amizade");
			// Criar o metadado da tabela
			md = rs.getMetaData();
			int nroColunas = md.getColumnCount();
			// Exibir os metadados/dados
			for (int i = 1; i <= nroColunas; i++)
				System.out.printf("%s\t", md.getColumnName(i));

			ArrayList<Amizade> d = new ArrayList<Amizade>();

			Amizade amizade1;

			int codigo1;
			int codigo2;
			String data_inicio;
			

			sel = "";
			// Usar os dados e mostra-los
			while (rs.next()) {

				amizade1 = new Amizade();

				codigo1= rs.getInt("codigo1");
				codigo2 = rs.getInt("codigo2");
				data_inicio = rs.getString("data_inicio");

				amizade1.setCodigo1(codigo1);
				amizade1.setCodigo2(codigo2);
				amizade1.setData_inicio(data_inicio);
				System.out.println("x");
			}

			for (Amizade umAmizade : d) {
				sel = sel + umAmizade.getCodigo1() + ", " + umAmizade.getCodigo2() + ", " + umAmizade.getData_inicio() + " "
						+ "\n ";

				System.out.printf("\n%d\t%d\t%s", umAmizade.getCodigo1(), umAmizade.getCodigo2(),umAmizade.getData_inicio());
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
