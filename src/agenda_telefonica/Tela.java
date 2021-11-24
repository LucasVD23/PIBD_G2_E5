package agenda_telefonica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;

class ActionEventDemo implements ActionListener {
    JFrame frame = new JFrame("Consulta da base de Agenda_Telefônica");
    JButton listar_pessoas = new JButton("Listar/Procurar Pessoas");
    JButton listar_carros = new JButton("Listar/Procurar Carros");
    JButton listar_amizades = new JButton("Listar/Procurar Amizades");
    JButton listar_possui = new JButton("Listar/Procurar Possui");
    JButton listar_telefones = new JButton("Listar/Procurar Telefones");

    JButton send_criar_pessoa = new JButton("Criar Pessoa");
    JButton send_criar_carro = new JButton("Criar Carro");
    JButton send_criar_possui = new JButton("Criar Possui");
    JButton send_criar_amizade = new JButton("Criar Amizade");
    JButton send_criar_telefone = new JButton("Criar Telefone");

    JLabel label_p = new JLabel("Digite o nome da pessoa que você quer procurar: ");
    JLabel label_c = new JLabel("Digite o modelo do carro que você quer procurar: ");
    JLabel label_Ami = new JLabel("Digite o código da pessoa para ver seus amigos: ");
    JLabel label_Pos = new JLabel("Digite o código da pessoa ou a placa do carro: ");
    JLabel label_tel = new JLabel("Digite o código da pessoa para buscar seus telefones: ");

    JTextField tf_p = new JTextField(10);  
    JTextField tf_c = new JTextField(10);  
    JTextField tf_Ami = new JTextField(10); 
    JTextField tf_Pos = new JTextField(10);   
    JTextField tf_tel = new JTextField(10);   

    JTextArea ta = new JTextArea(/*20, 20*/);

    JLabel codigo_l = new JLabel("Código");
    JLabel nome_l = new JLabel("Nome");
    JLabel data_l = new JLabel("Nascimento");
    JLabel cep_l = new JLabel("CEP");
    JLabel numero_l = new JLabel("Número");
    JLabel complemento_l = new JLabel("Complemento");
    JLabel homepage_l = new JLabel("homepage");

    JLabel placa_l = new JLabel("Placa");
    JLabel ano_l = new JLabel("Ano");
    JLabel cor_l = new JLabel("Cor");
    JLabel modelo_l = new JLabel("Modelo");

    JLabel codigo1_l = new JLabel("Código 1");
    JLabel codigo2_l = new JLabel("Código 2");
    JLabel data_amizade_l = new JLabel("Data de criação da amizade");

    JLabel codigoP_l = new JLabel("Código da pessoa");
    JLabel placaP_l = new JLabel("Placa do carro");

    JLabel codigoT_l = new JLabel("Código da pessoa");
    JLabel telefone_l = new JLabel("Telefone");

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
    JTextField data_amizade = new JTextField(10); 

    JTextField codigoP = new JTextField(10); 
    JTextField placaP = new JTextField(10); 

    JTextField codigoT = new JTextField(10); 
    JTextField telefone = new JTextField(10); 

    ActionEventDemo() {
        prepareGUI();

    }

    public void prepareGUI() {
        // Creating the Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 800);

        // Creating the panel at bottom and adding components
        JPanel panel = new JPanel();
        JPanel criar_P = new JPanel();
        JPanel criar_C = new JPanel();
        JPanel criar_Ami = new JPanel();
        JPanel criar_Pos = new JPanel();
        JPanel criar_tel = new JPanel();
        JPanel criar = new JPanel();

        //criar.setLayout(new GridLayout(1,7));
        //criar.setLayout(new BoxLayout(criar, BoxLayout.Y_AXIS));
        criar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.setLayout(new GridLayout(5,3));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        panel.add(label_p);
        panel.add(tf_p);
        panel.add(listar_pessoas);
        panel.add(label_c);
        panel.add(tf_c);
        panel.add(listar_carros);
        panel.add(label_Ami);
        panel.add(tf_Ami);
        panel.add(listar_amizades);
        panel.add(label_Pos);
        panel.add(tf_Pos);
        panel.add(listar_possui);
        panel.add(label_tel);
        panel.add(tf_tel);
        panel.add(listar_telefones);

        criar_P.setLayout(new BoxLayout(criar_P, BoxLayout.Y_AXIS));
/*
        criar_P.add(codigo_l);
        criar_P.add(codigo);
*/
        criar_P.add(nome_l);
        criar_P.add(nome);

        criar_P.add(data_l);
        criar_P.add(data);

        criar_P.add(homepage_l);
        criar_P.add(homepage);

        JPanel criar_P_local = new JPanel();
        criar_P_local.setLayout(new GridLayout(2,6));
        
        criar_P_local.add(cep_l);
        criar_P_local.add(numero_l);
        criar_P_local.add(complemento_l);

        criar_P_local.add(cep);
        criar_P_local.add(numero);
        criar_P_local.add(complemento);

        criar_P.add(criar_P_local);

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
/*
        JPanel criar_Ami_cods = new JPanel();
        criar_Ami_cods.setLayout(new GridLayout(2,4));

        criar_Ami_cods.add(codigo1_l);
        criar_Ami_cods.add(codigo2_l);
        criar_Ami_cods.add(codigo1);        
        criar_Ami_cods.add(codigo2);

        criar_Ami.add(criar_Ami_cods);

        criar_Ami.add(data_amizade_l);
        criar_Ami.add(data_amizade);
*/
        criar_Ami.add(codigo1_l);
        criar_Ami.add(codigo1);        
        criar_Ami.add(codigo2_l);
        criar_Ami.add(codigo2);

        criar_Ami.add(send_criar_amizade);

        criar_Pos.setLayout(new BoxLayout(criar_Pos, BoxLayout.Y_AXIS));

        criar_Pos.add(codigoP_l);
        criar_Pos.add(codigoP);

        criar_Pos.add(placaP_l);
        criar_Pos.add(placaP);

        criar_Pos.add(send_criar_possui);

        criar_tel.setLayout(new BoxLayout(criar_tel, BoxLayout.Y_AXIS));

        criar_tel.add(codigoT_l);
        criar_tel.add(codigoT);

        criar_tel.add(telefone_l);
        criar_tel.add(telefone);

        criar_tel.add(send_criar_telefone);

        criar_C.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        criar_P.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        criar_Ami.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        criar_Pos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        criar_tel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        criar.add(criar_C);
        criar.add(criar_P);
        criar.add(criar_Ami);
        criar.add(criar_Pos);
        criar.add(criar_tel);

        // Text Area at the Center

        // Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, ta);
        frame.getContentPane().add(BorderLayout.CENTER, criar);

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
        send_criar_telefone.addActionListener(this);
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
            ta.setText(tf_Pos.getText() + "\n" + Possui.SelecionaPossui(tf_Pos.getText()));
        else if (e.getSource() == listar_telefones)
            ta.setText(tf_tel.getText() + "\n" + Telefone.SelecionaTelefones(tf_tel.getText()));

        else if (e.getSource() == send_criar_pessoa)
            Pessoa.InserePessoa(nome.getText(), data.getText(), cep.getText(),
                    complemento.getText(), Integer.parseInt(numero.getText()), homepage.getText());
        else if (e.getSource() == send_criar_carro)
            Carro.InsereCarro(placa.getText(), Integer.parseInt(ano.getText()), cor.getText(), modelo.getText());
        else if (e.getSource() == send_criar_amizade){
            Date date;
        	/*if (data_amizade.getText().length() > 0) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String data_a = data_amizade.getText();
                date = format.parse(data_a);
            }
            else {*/
                LocalDate obj = LocalDate.now();
                date = Date.valueOf(obj);
            //}
            Amizade.InsereAmizade(Integer.parseInt(codigo1.getText()), Integer.parseInt(codigo2.getText()), date);
            
        }
        else if (e.getSource() == send_criar_possui)
            Possui.InserePossui(Integer.parseInt(codigoP.getText()), placaP.getText());
        else if (e.getSource() == send_criar_telefone)
            Telefone.InsereTelefone(Integer.parseInt(codigoT.getText()), telefone.getText());


        tf_p.setText("");
        tf_c.setText("");
        tf_Ami.setText("");
        tf_Pos.setText("");
        tf_tel.setText("");
    }
}

public class Tela {
    public static void main(String[] args) {
        new ActionEventDemo();
    }
}