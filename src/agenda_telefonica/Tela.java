package agenda_telefonica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ActionEventDemo implements ActionListener {
    JFrame frame = new JFrame("Consulta da base de Pessoas");
    JButton listar_pessoas = new JButton("Listar Pessoas");
    JButton send_criar_pessoa = new JButton("Criar Pessoa");
    JButton send_criar_carro = new JButton("Criar Carro");


    JLabel label = new JLabel("Digite o nome da pessoa que voce quer procurar: ");
    JTextField tf = new JTextField(10);  
    JTextArea ta = new JTextArea();

    JLabel codigo_l = new JLabel("codigo ");
    JLabel nome_l = new JLabel("nome");
    JLabel data_l = new JLabel("nascimento");
    JLabel cep_l = new JLabel("cep ");
    JLabel numero_l = new JLabel("numeo ");
    JLabel complemento_l = new JLabel("complemento ");
    JLabel homepage_l = new JLabel("homepage ");

    JLabel placa_l = new JLabel("placa ");
    JLabel ano_l = new JLabel("ano ");
    JLabel cor_l = new JLabel("cor ");
    JLabel modelo_l = new JLabel("modelo ");


    JTextField codigo = new JTextField(10);  
    JTextField nome = new JTextField(10);  
    JTextField data = new JTextField(10);  
    JTextField cep = new JTextField(10);  
    JTextField numero = new JTextField(10);  
    JTextField complemento = new JTextField(10);  
    JTextField homepage = new JTextField(10);  

    JTextField placa = new JTextField(10);  
    JTextField ano = new JTextField(10);  
    JTextField cor = new JTextField(10);  
    JTextField modelo = new JTextField(10);
     

    ActionEventDemo() {
        prepareGUI();

    }

    public void prepareGUI() {
        // Creating the Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        // Creating the MenuBar and adding components
        /*
         * JMenuBar mb = new JMenuBar(); JMenu m1 = new JMenu("FILE"); JMenu m2 = new
         * JMenu("Help"); mb.add(m1); mb.add(m2); JMenuItem m11 = new JMenuItem("Open");
         * JMenuItem m22 = new JMenuItem("Save as"); m1.add(m11); m1.add(m22);
         */

        // Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output

        JPanel criar = new JPanel();

        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(listar_pessoas);
        BoxLayout boxlayout = new BoxLayout(criar, BoxLayout.Y_AXIS);
        criar.setLayout(boxlayout);;

        criar.add(codigo_l);
        criar.add(codigo);

        criar.add(cep_l);
        criar.add(cep);

        criar.add(numero_l);
        criar.add(numero);

        criar.add(complemento_l);
        criar.add(complemento);

        criar.add(nome_l);
        criar.add(nome);

        criar.add(data_l);
        criar.add(data);

        criar.add(homepage_l);
        criar.add(homepage);

        criar.add(send_criar_pessoa);

        criar.add(placa_l);
        criar.add(placa);

        criar.add(ano_l);
        criar.add(ano);

        criar.add(modelo_l);
        criar.add(modelo);

        criar.add(cor_l);
        criar.add(cor);

        criar.add(send_criar_carro);


        // Text Area at the Center

        // Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        // frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.NORTH, criar);

        frame.setVisible(true);

        listar_pessoas.addActionListener(this);
        send_criar_pessoa.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == listar_pessoas)
            ta.setText(tf.getText() + "\n" + Pessoa.SelecionaPessoa(tf.getText()));
        else if (e.getSource() == send_criar_pessoa)
            Pessoa.InserePessoa(Integer.parseInt(codigo.getText()), nome.getText(), data.getText(), cep.getText(),
                    complemento.getText(), Integer.parseInt(numero.getText()), homepage.getText());
        tf.setText("");

    }
}

public class Tela {
    public static void main(String[] args) {
        new ActionEventDemo();
    }
}