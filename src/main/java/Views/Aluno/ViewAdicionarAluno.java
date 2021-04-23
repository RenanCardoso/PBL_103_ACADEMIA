package Views.Aluno;

import Modules.Controllers.Routes;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ViewAdicionarAluno {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JTextField nome;
    private static JLabel labelNome;

    public ViewAdicionarAluno() {
        verTelaAdicionarAluno();
    }

    public static void verTelaAdicionarAluno() {

        //        crio o meu Jframe
        frame = new JFrame("Adicionar Aluno");
        frame.setBounds(100, 100, 750, 550);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Salvar");
        btnSalvar.setActionCommand("adicionarAluno");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Alunos");
        btnVoltarMenuUsuarios.setActionCommand("verTelaAlunos");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        labelNome = new JLabel("Nome do Aluno");
        nome = new JTextField(30);

        frame.add(panel);
        frame.add(labelNome);
        frame.add(nome);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new Routes(btnSalvar, frame, nome)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new Routes(btnAcao, frame, nome)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new Routes(btnVoltarMenuUsuarios, frame, nome)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
