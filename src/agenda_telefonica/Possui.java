package agenda_telefonica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Possui extends Abstract{
	private int codigoPessoa;
	private String placa;
	
	static Connection con = null;
	static Statement stm = null;
	static ResultSet rs = null;
	static ResultSetMetaData md = null;
	
	static String sel = "";
	
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
	
	public static void InserePossui(int codigoPessoa, String placa) {
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
	public static String SelecionaPossuiporPessoa(String n) {
		try {
			// Abrir a conexão
			Possui.con = DriverManager.getConnection(Possui.DATABASE_URL);
			// Criar o comando
			stm = con.createStatement();
			if (n.length() > 0)
				rs = stm.executeQuery("select * from Possui where Possui.codigoPessoa = '" + n + "'");
			else
				rs = stm.executeQuery("select * from Possui");
			// Criar o metadado da tabela
			md = rs.getMetaData();
			int nroColunas = md.getColumnCount();
			// Exibir os metadados/dados
			for (int i = 1; i <= nroColunas; i++)
				System.out.printf("%s\t", md.getColumnName(i));

			ArrayList<Possui> d = new ArrayList<Possui>();

			Possui possui1;

			int codigoPessoa;
			String placa;

			sel = "";
			// Usar os dados e mostra-los
			while (rs.next()) {

				possui1 = new Possui();

				codigoPessoa = rs.getInt("codigoPessoa");
				placa = rs.getString("placa");

				possui1.setCodigoPessoa(codigoPessoa);
				possui1.setPlaca(placa);
				System.out.println("x");
			}

			for (Possui umPossui : d) {
				sel = sel + umPossui.getCodigoPessoa() + ", " + umPossui.getPlaca() 
						+ "\n ";

				System.out.printf("\n%d\t%s", umPossui.getCodigoPessoa(), umPossui.getPlaca());
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
	public static String SelecionaPossuiporCarro(String n) {
		try {
			// Abrir a conexão
			Possui.con = DriverManager.getConnection(Possui.DATABASE_URL);
			// Criar o comando
			stm = con.createStatement();
			if (n.length() > 0)
				rs = stm.executeQuery("select * from Possui where Possui.placa = '" + n + "'");
			else
				rs = stm.executeQuery("select * from Possui");
			// Criar o metadado da tabela
			md = rs.getMetaData();
			int nroColunas = md.getColumnCount();
			// Exibir os metadados/dados
			for (int i = 1; i <= nroColunas; i++)
				System.out.printf("%s\t", md.getColumnName(i));

			ArrayList<Possui> d = new ArrayList<Possui>();

			Possui possui1;

			int codigoPessoa;
			String placa;

			sel = "";
			// Usar os dados e mostra-los
			while (rs.next()) {

				possui1 = new Possui();

				codigoPessoa = rs.getInt("codigoPessoa");
				placa = rs.getString("placa");

				possui1.setCodigoPessoa(codigoPessoa);
				possui1.setPlaca(placa);
				System.out.println("x");
			}

			for (Possui umPossui : d) {
				sel = sel + umPossui.getCodigoPessoa() + ", " + umPossui.getPlaca() + ", "
						+ "\n ";

				System.out.printf("\n%d\t%s", umPossui.getCodigoPessoa(), umPossui.getPlaca());
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
