package Views.Instrutor;

import Modules.Routes.RotasInstrutor;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ViewAdicionarInstrutor {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JTextField nome;
    private static JLabel labelNome;

    public ViewAdicionarInstrutor() throws SQLException {
        verTelaAdicionarInstrutor();
    }

    public static void verTelaAdicionarInstrutor() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Adicionar Instrutor");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Adicionar");
        btnSalvar.setActionCommand("adicionarInstrutor");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Instrutores");
        btnVoltarMenuUsuarios.setActionCommand("verTelaInstrutores");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        labelNome = new JLabel("Nome do Instrutor");
        nome = new JTextField(30);

        frame.add(panel);
        frame.add(labelNome);
        frame.add(nome);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new RotasInstrutor(btnSalvar, frame, nome)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasInstrutor(btnAcao, frame, nome)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new RotasInstrutor(btnVoltarMenuUsuarios, frame, nome)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
