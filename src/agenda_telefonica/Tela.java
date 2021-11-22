package agenda_telefonica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
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
	
	static String  select(String n) {
		 try{
			
			//Abrir a conexão
			con = DriverManager.getConnection(DATABASE_URL,"root","root");
			//Criar o comando
			stm = con.createStatement();
			rs = stm.executeQuery("select * from Pessoa where pessoa.nome = '" + n + "'");
			//Criar o metadado da tabela
			md = rs.getMetaData();
			int nroColunas = md.getColumnCount();
			//Exibir os metadados/dados
			for(int i = 1; i <= nroColunas; i++)
				System.out.printf("%s\t",
						md.getColumnName(i));
			
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
			//Usar os dados e mostra-los
			while(rs.next()){

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
			
			for(Pessoa umPessoa : d){
				sel = sel + umPessoa.getCodigo() + ", " +	umPessoa.getNome() + ", " + umPessoa.getData_nascimento() + ", " + umPessoa.getHomepage() + ", " + umPessoa.getCep()
                + ", " +	umPessoa.getNumero() + ", " + umPessoa.getComplemento() + ", " + umPessoa.getQtd_carros() + ", " + umPessoa.getQtd_amigos() + "\n " ;
						
				System.out.printf("\n%d\t%s\t%s\t%s\t%s\t%d\t%s\t%d\t%d",
                    umPessoa.getCodigo(),
                    umPessoa.getNome(),
                    umPessoa.getData_nascimento(),
                    umPessoa.getHomepage(),
                    umPessoa.getCep(),
                    umPessoa.getNumero(),
                    umPessoa.getComplemento(),
                    umPessoa.getQtd_carros(),
                    umPessoa.getQtd_amigos());
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
*/

class ActionEventDemo implements ActionListener {
    JFrame frame = new JFrame("Consulta da base de Pessoas");
    JButton send = new JButton("Listar Pessoas");
    
    JLabel label = new JLabel("Digite o nome da pessoa que voce quer procurar: ");
    JTextField tf = new JTextField(10); // accepts upto 10 characters
    JTextArea ta = new JTextArea();
    
    ActionEventDemo(){
        prepareGUI();
      
    }

    public void prepareGUI(){
    	//Creating the Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        //Creating the MenuBar and adding components
        /*JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);*/

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
                    
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        

        // Text Area at the Center
        

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        //frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    
        
        send.addActionListener(this);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    	if (e.getSource()== send)
    	    ta.setText(tf.getText() + "\n" + Pessoa.SelecionaPessoa(tf.getText()));
    	    	
    	tf.setText("");
       
     

    }
}

public class Tela {
    public static void main(String[] args)
    {
        new ActionEventDemo();
    }
}