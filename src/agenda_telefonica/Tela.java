package agenda_telefonica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ActionEventDemo implements ActionListener {
    JFrame frame = new JFrame("Consulta da base de Pessoas");
    JButton send1 = new JButton("Listar Pessoas");
    JButton send2 = new JButton("Criar Pessoa");

    JLabel label = new JLabel("Digite o nome da pessoa que voce quer procurar: ");
    JTextField tf = new JTextField(10); // accepts upto 10 characters
    JTextArea ta = new JTextArea();

    JTextField codigo = new JTextField(10); // accepts upto 10 characters
    JTextField nome = new JTextField(10); // accepts upto 10 characters
    JTextField cep = new JTextField(10); // accepts upto 10 characters
    JTextField numero = new JTextField(10); // accepts upto 10 characters
    JTextField complemento = new JTextField(10); // accepts upto 10 characters
    JTextField homepage = new JTextField(10); // accepts upto 10 characters

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
        panel.add(send1);

        criar.add(codigo);
        criar.add(cep);
        criar.add(numero);
        criar.add(complemento);
        criar.add(nome);
        criar.add(homepage);
        criar.add(send2);

        // Text Area at the Center

        // Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        // frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.NORTH, criar);
        frame.setVisible(true);

        send1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == send1)
            ta.setText(tf.getText() + "\n" + Pessoa.SelecionaPessoa(tf.getText()));
        else if (e.getSource() == send2)
            Pessoa.InserePessoa(Integer.parseInt(codigo.getText()), nome.getText(), cep.getText(),
                    complemento.getText(), Integer.parseInt(numero.getText()), homepage.getText());
        tf.setText("");

    }
}

public class Tela {
    public static void main(String[] args) {
        new ActionEventDemo();
    }
}