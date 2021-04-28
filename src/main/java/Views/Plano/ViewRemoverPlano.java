package Views.Plano;

import Modules.Controllers.PlanoController;
import Modules.Routes.RotasPlano;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ViewRemoverPlano {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JComboBox combobox;

    public ViewRemoverPlano() throws SQLException {
        verTelaRemoverPlano();
    }

    public static void verTelaRemoverPlano() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Remover Plano");
        frame.setBounds(100, 100, 750, 550);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Remover");
        btnSalvar.setActionCommand("removerPlano");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Planos");
        btnVoltarMenuUsuarios.setActionCommand("verTelaPlanos");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        combobox = new JComboBox();
        PlanoController planoCon = new PlanoController();
        for (int i = 0; i < planoCon.listarPlanos().size(); i++){
            combobox.addItem(planoCon.listarPlanos().get(i).getNome());
        }


        frame.add(panel);
        frame.add(combobox);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new RotasPlano(btnSalvar, frame, combobox)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasPlano(btnAcao, frame)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new RotasPlano(btnVoltarMenuUsuarios, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
