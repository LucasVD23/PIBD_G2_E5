package agenda_telefonica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Carro {
	private String placa;
	private int ano;
	private String cor;
	private String modelo;
	
	static final String DATABASE_URL = "jdbc:postgresql://localhost/pibd?user=postgres&password=postgres";
	static Connection con = null;
	
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
	
	public void InsereCarro(String placa, int ano, String cor, String modelo) {	
		try {
			Carro.con = DriverManager.getConnection(Carro.DATABASE_URL);
			PreparedStatement insere = con.prepareStatement("insert into "
							+ "Carro(placa,ano,cor,modelo) "
							+ "values (?,?,?,?)");
			insere.setString(1,placa);
			insere.setInt(2,ano);
			insere.setString(3,cor);
			insere.setString(4,modelo);
			
		}catch(SQLException e){
			System.err.println(e);
		}catch(Exception e){
			System.err.println(e);
		}
	}
}
