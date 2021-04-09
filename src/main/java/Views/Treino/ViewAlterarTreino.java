package Views.Treino;

import Modules.Controllers.TreinoController;
import Modules.Controllers.Routes;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ViewAlterarTreino {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JTextField nome;
    private static JLabel labelNome;
    private static JComboBox combobox;

    public ViewAlterarTreino() throws SQLException {
        verTelaAlterarTreino();
    }

    public static void verTelaAlterarTreino() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Alterar Treino");
        frame.setBounds(100, 100, 750, 550);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Salvar");
        btnSalvar.setActionCommand("alterarTreino");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Treinos");
        btnVoltarMenuUsuarios.setActionCommand("verTelaTreinos");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        combobox = new JComboBox();
        TreinoController treinoCon = new TreinoController();
        for (int i = 0; i < treinoCon.listarTreinos().size(); i++){
            combobox.addItem(treinoCon.listarTreinos().get(i).getNome());
        }

        labelNome = new JLabel("Insira o novo nome do Treino: *");
        nome = new JTextField(30);

        frame.add(panel);
        frame.add(combobox);
        frame.add(labelNome);
        frame.add(nome);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new Routes(btnSalvar, frame, nome, combobox)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new Routes(btnAcao, frame, nome)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new Routes(btnVoltarMenuUsuarios, frame, nome)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
