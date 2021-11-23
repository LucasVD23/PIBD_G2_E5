package agenda_telefonica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Carro extends Abstract{
	private String placa;
	private int ano;
	private String cor;
	private String modelo;
	
	static Connection con = null;
	static Statement stm = null;
	static ResultSet rs = null;
	static ResultSetMetaData md = null;
	
	static String sel = "";
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public static void InsereCarro(String placa, int ano, String cor, String modelo) {	
		try {
			Carro.con = DriverManager.getConnection(Carro.DATABASE_URL);
			PreparedStatement insere = con.prepareStatement("insert into "
							+ "Carro(placa,ano,cor,modelo) "
							+ "values (?,?,?,?)");
			insere.setString(1,placa);
			insere.setInt(2,ano);
			insere.setString(3,cor);
			insere.setString(4,modelo);

			insere.executeUpdate();
			
		}catch(SQLException e){
			System.err.println(e);
		}catch(Exception e){
			System.err.println(e);
		}
	}
	public static String SelecionaCarro(String n) {
		try {
			// Abrir a conexão
			Carro.con = DriverManager.getConnection(Carro.DATABASE_URL);
			// Criar o comando
			stm = con.createStatement();
			if (n.length() > 0)
				rs = stm.executeQuery("select * from Carro where placa = '" + n + "'");
			else
				rs = stm.executeQuery("select * from Carro");
			// Criar o metadado da tabela
			md = rs.getMetaData();
			int nroColunas = md.getColumnCount();
			// Exibir os metadados/dados
			for (int i = 1; i <= nroColunas; i++)
				System.out.printf("%s\t", md.getColumnName(i));

			ArrayList<Carro> d = new ArrayList<Carro>();

			Carro carro1;

			String placa;
			int ano;
			String cor;
			String modelo;
			

			sel = "";
			// Usar os dados e mostra-los
			while (rs.next()) {

				carro1 = new Carro();

				placa =  rs.getString("placa");
				ano = rs.getInt("ano");
				cor = rs.getString("cor");
				modelo = rs.getString("modelo");

				carro1.setPlaca(placa);
				carro1.setAno(ano);
				carro1.setCor(cor);
				carro1.setModelo(modelo);
				d.add(carro1);
			}

			for (Carro umCarro : d) {
				sel = sel + umCarro.getPlaca() + ", " + umCarro.getAno() + ", " + umCarro.getCor() + ", " + umCarro.getModelo()
						+ "\n ";

				System.out.printf("\n%s\t%d\t%s\t%s", umCarro.getPlaca(), umCarro.getAno(),umCarro.getCor(),umCarro.getModelo());
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
