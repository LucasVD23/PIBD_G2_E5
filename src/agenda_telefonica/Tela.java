package agenda_telefonica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ActionEventDemo implements ActionListener {
    JFrame frame = new JFrame("Consulta da base de Agenda_Telefonica");
    JButton listar_pessoas = new JButton("Listar Pessoas");
    JButton listar_carros = new JButton("Listar Carros");
    JButton listar_amizades = new JButton("Listar Amizades");
    JButton listar_possui = new JButton("Listar Possui");
    JButton listar_telefones = new JButton("Listar Telefones");

    JButton send_criar_pessoa = new JButton("Criar Pessoa");
    JButton send_criar_carro = new JButton("Criar Carro");
    JButton send_criar_possui = new JButton("Criar Possui");
    JButton send_criar_amizade = new JButton("Criar Amizade");

    JLabel label_p = new JLabel("Digite o nome da pessoa que voce quer procurar: ");
    JLabel label_c = new JLabel("Digite o modelo do carro que voce quer procurar: ");
    JLabel label_Ami = new JLabel("Digite o codigo da pessoa para ver seus amigos: ");

    JTextField tf_p = new JTextField(10);  
    JTextField tf_c = new JTextField(10);  
    JTextField tf_Ami = new JTextField(10);  

    JTextArea ta = new JTextArea();

    JLabel codigo_l = new JLabel("codigo ");
    JLabel nome_l = new JLabel("nome");
    JLabel data_l = new JLabel("nascimento");
    JLabel cep_l = new JLabel("cep ");
    JLabel numero_l = new JLabel("numero ");
    JLabel complemento_l = new JLabel("complemento ");
    JLabel homepage_l = new JLabel("homepage ");

    JLabel placa_l = new JLabel("placa ");
    JLabel ano_l = new JLabel("ano ");
    JLabel cor_l = new JLabel("cor ");
    JLabel modelo_l = new JLabel("modelo ");

    JLabel codigo1_l = new JLabel("codigo 1");
    JLabel codigo2_l = new JLabel("codigo 2");

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
    
    JTextField codigo1 = new JTextField(10); 
    JTextField codigo2 = new JTextField(10); 

    ActionEventDemo() {
        prepareGUI();

    }

    public void prepareGUI() {
        // Creating the Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 720);

        // Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JPanel criar_P = new JPanel();
        JPanel criar_C = new JPanel();
        JPanel criar_Ami = new JPanel();
        JPanel criar_Pos = new JPanel();
        JPanel criar = new JPanel();

        panel.setLayout(new GridLayout(4,3));
        
        panel.add(label_p);
        panel.add(tf_p);
        panel.add(listar_pessoas);
        panel.add(label_c);
        panel.add(tf_c);
        panel.add(listar_carros);
        panel.add(label_Ami);
        panel.add(tf_Ami);
        panel.add(listar_amizades);

        panel.add(listar_possui);
        panel.add(listar_telefones);

        criar_P.setLayout(new BoxLayout(criar_P, BoxLayout.PAGE_AXIS));

        criar_P.add(codigo_l);
        criar_P.add(codigo);

        criar_P.add(cep_l);
        criar_P.add(cep);

        criar_P.add(numero_l);
        criar_P.add(numero);

        criar_P.add(complemento_l);
        criar_P.add(complemento);

        criar_P.add(nome_l);
        criar_P.add(nome);

        criar_P.add(data_l);
        criar_P.add(data);

        criar_P.add(homepage_l);
        criar_P.add(homepage);

        criar_P.add(send_criar_pessoa);

        criar_C.setLayout(new BoxLayout(criar_C, BoxLayout.Y_AXIS));

        criar_C.add(placa_l);
        criar_C.add(placa);

        criar_C.add(ano_l);
        criar_C.add(ano);

        criar_C.add(modelo_l);
        criar_C.add(modelo);

        criar_C.add(cor_l);
        criar_C.add(cor);

        criar_C.add(send_criar_carro);

        criar_Ami.setLayout(new BoxLayout(criar_Ami, BoxLayout.Y_AXIS));

        criar_Ami.add(codigo1_l);
        criar_Ami.add(codigo1);

        criar_Ami.add(codigo2_l);
        criar_Ami.add(codigo2);

        criar_Ami.add(send_criar_amizade);

        //criar_Ami.setBorder(BorderFactory.createLineBorder(Color.black));

        criar_Pos.setLayout(new BoxLayout(criar_Pos, BoxLayout.Y_AXIS));

        criar_Pos.add(codigo_l);
        criar_Pos.add(codigo);

        criar_Pos.add(placa_l);
        criar_Pos.add(placa);

        criar_Pos.add(send_criar_possui);

        criar.add(criar_C);
        criar.add(criar_P);
        criar.add(criar_Ami);
        criar.add(criar_Pos);
        // Text Area at the Center

        // Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, ta);
        frame.getContentPane().add(BorderLayout.CENTER, criar);
        //frame.getContentPane().add(BorderLayout.WEST, criar_C);


        frame.setVisible(true);

        listar_pessoas.addActionListener(this);
        listar_carros.addActionListener(this);
        listar_amizades.addActionListener(this);
        listar_possui.addActionListener(this);
        listar_telefones.addActionListener(this);

        send_criar_pessoa.addActionListener(this);
        send_criar_carro.addActionListener(this);
        send_criar_amizade.addActionListener(this);
        send_criar_possui.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == listar_pessoas)
            ta.setText(tf_p.getText() + "\n" + Pessoa.SelecionaPessoa(tf_p.getText()));
        else if (e.getSource() == listar_carros)
            ta.setText(tf_c.getText() + "\n" + Carro.SelecionaCarro(tf_c.getText()));
        else if (e.getSource() == listar_amizades)
            ta.setText(tf_Ami.getText() + "\n" + Amizade.SelecionaAmizade(tf_Ami.getText()));
        else if (e.getSource() == listar_possui)
            ta.setText(tf_c.getText() + "\n" + Carro.SelecionaCarro(tf_c.getText()));



        else if (e.getSource() == send_criar_pessoa)
            Pessoa.InserePessoa(Integer.parseInt(codigo.getText()), nome.getText(), data.getText(), cep.getText(),
                    complemento.getText(), Integer.parseInt(numero.getText()), homepage.getText());
        else if (e.getSource() == send_criar_carro)
            Carro.InsereCarro(placa.getText(), Integer.parseInt(ano.getText()), cor.getText(), modelo.getText());
        else if (e.getSource() == send_criar_amizade)
            Amizade.InsereAmizade(Integer.parseInt(codigo1.getText()), Integer.parseInt(codigo2.getText()), "10/10/10");
        else if (e.getSource() == send_criar_possui)
            Possui.InserePossui(Integer.parseInt(codigo.getText()), placa.getText());




        tf_p.setText("");
        tf_c.setText("");
        tf_Ami.setText("");

    }
}

public class Tela {
    public static void main(String[] args) {
        new ActionEventDemo();
    }
}