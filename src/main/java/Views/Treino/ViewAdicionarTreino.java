package Views.Treino;

import Modules.Routes.RotasTreino;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ViewAdicionarTreino {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JTextField nome;
    private static JLabel labelNome;

    public ViewAdicionarTreino() throws SQLException {
        verTelaAdicionarTreino();
    }

    public static void verTelaAdicionarTreino() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Adicionar Treino");
        frame.setBounds(100, 100, 750, 550);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Adicionar");
        btnSalvar.setActionCommand("adicionarTreino");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Treino");
        btnVoltarMenuUsuarios.setActionCommand("verTelaTreinos");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        labelNome = new JLabel("Nome do Treino");
        nome = new JTextField(30);

        frame.add(panel);
        frame.add(labelNome);
        frame.add(nome);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new RotasTreino(btnSalvar, frame, nome)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasTreino(btnAcao, frame, nome)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new RotasTreino(btnVoltarMenuUsuarios, frame, nome)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
