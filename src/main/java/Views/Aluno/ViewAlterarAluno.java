package Views.Aluno;

import Modules.Controllers.AlunoController;
import Modules.Routes.RotasAluno;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ViewAlterarAluno {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JTextField nome;
    private static JLabel labelNome;
    private static JComboBox combobox;
    
    public ViewAlterarAluno() throws SQLException {
        verTelaAlterarAluno();
    }

    public static void verTelaAlterarAluno() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Alterar Aluno");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Alterar");
        btnSalvar.setActionCommand("alterarAluno");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Alunos");
        btnVoltarMenuUsuarios.setActionCommand("verTelaAlunos");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        combobox = new JComboBox();
        AlunoController alunoCon = new AlunoController();
        for (int i = 0; i < alunoCon.listarAlunos().size(); i++){
            combobox.addItem(alunoCon.listarAlunos().get(i).getNome());
        }

        labelNome = new JLabel("Insira o novo nome do Aluno: *");
        nome = new JTextField(30);

        frame.add(panel);
        frame.add(combobox);
        frame.add(labelNome);
        frame.add(nome);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new RotasAluno(btnSalvar, frame, nome, combobox)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasAluno(btnAcao, frame)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new RotasAluno(btnVoltarMenuUsuarios, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
