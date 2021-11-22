package agenda_telefonica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

 class Sel {
	static final String DATABASE_URL =
			"jdbc:postgresql://localhost/agenda_telefonica";
	static Connection con = null;
	static Statement stm = null;
	static ResultSet rs = null;
	static ResultSetMetaData md = null;
	static String sel = "";
	
	 static String  select() {
		 try{
			
			//Abrir a conexão
			con = DriverManager.getConnection(DATABASE_URL,"root","root");
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
			
			ArrayList<DVD> d = new ArrayList<DVD>();
			int ser;
			String tit;
			String desc;
			double dur;
			DVD dvd1;
			sel = "";	
			//Usar os dados e mostra-los
			while(rs.next()){
				ser = rs.getInt("serial");
				tit = rs.getString("titulo");
				desc = rs.getString("descricao");
				dur = rs.getDouble("duracao");
				dvd1 = new DVD();
				dvd1.setSerial(ser);
				dvd1.setTitulo(tit);
				dvd1.setDescricao(desc);
				dvd1.setDuracao(dur);
				d.add(dvd1);
			}
			
			for(DVD umDVD : d){
				sel = sel + umDVD.getSerial() + ", " +	umDVD.getTitulo() + ", " + umDVD.getDescricao() + ", " + umDVD.getDescricao() + ", " + umDVD.getDuracao() + "\n " ;
						
				System.out.printf("\n%d\t%s\t%s\t%.2f",
						umDVD.getSerial(),
						umDVD.getTitulo(),
						umDVD.getDescricao(),
						umDVD.getDuracao());
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
		return sel;
	}
}


class ActionEventDemo implements ActionListener {
    JFrame frame = new JFrame("Consulta da base de DVDs");
    JButton send = new JButton("Consulta");
    
    JLabel label = new JLabel("Digite um texto: ");
    JTextField tf = new JTextField(10); // accepts upto 10 characters
    JTextArea ta = new JTextArea();
    
    ActionEventDemo(){
        prepareGUI();
      
    }

    public void prepareGUI(){
    	//Creating the Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
                    
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        

        // Text Area at the Center
        

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    
        
        send.addActionListener(this);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    	if (e.getSource()== send)
    	    ta.setText(tf.getText() + "\n" + Sel.select());
    	    	
    	tf.setText("");
       
     

    }
}

public class Tela {
    public static void main(String[] args)
    {
        new ActionEventDemo();
    }
}