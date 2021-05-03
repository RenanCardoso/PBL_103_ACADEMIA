package Views.Instrutor;

import Modules.Controllers.InstrutorController;
import Modules.Routes.RotasInstrutor;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ViewAlterarInstrutor {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JTextField nome;
    private static JLabel labelNome;
    private static JComboBox combobox;

    public ViewAlterarInstrutor() throws SQLException {
        verTelaAlterarInstrutor();
    }

    public static void verTelaAlterarInstrutor() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Alterar Instrutor");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Alterar");
        btnSalvar.setActionCommand("alterarInstrutor");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Instrutores");
        btnVoltarMenuUsuarios.setActionCommand("verTelaInstrutores");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        combobox = new JComboBox();
        InstrutorController InstrutorCon = new InstrutorController();
        for (int i = 0; i < InstrutorCon.listarInstrutores().size(); i++){
            combobox.addItem(InstrutorCon.listarInstrutores().get(i).getNome());
        }

        labelNome = new JLabel("Insira o novo nome do Instrutor: *");
        nome = new JTextField(30);

        frame.add(panel);
        frame.add(combobox);
        frame.add(labelNome);
        frame.add(nome);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new RotasInstrutor(btnSalvar, frame, nome, combobox)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasInstrutor(btnAcao, frame, nome)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new RotasInstrutor(btnVoltarMenuUsuarios, frame, nome)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
