package Views.Treino;

import Modules.Controllers.TreinoController;
import Modules.Routes.RotasTreino;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ViewRemoverTreino {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JComboBox combobox;

    public ViewRemoverTreino() throws SQLException {
        verTelaRemoverTreino();
    }

    public static void verTelaRemoverTreino() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Remover Treino");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Remover");
        btnSalvar.setActionCommand("removerTreino");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Treinos");
        btnVoltarMenuUsuarios.setActionCommand("verTelaTreinos");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        combobox = new JComboBox();
        TreinoController treinoCon = new TreinoController();
        for (int i = 0; i < treinoCon.listarTreinos().size(); i++){
            combobox.addItem(treinoCon.listarTreinos().get(i).getNome());
        }


        frame.add(panel);
        frame.add(combobox);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new RotasTreino(btnSalvar, frame, combobox)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasTreino(btnAcao, frame)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new RotasTreino(btnVoltarMenuUsuarios, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
