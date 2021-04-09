package Views.Aparelho;

import Modules.Controllers.AparelhoController;
import Modules.Controllers.Routes;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ViewRemoverAparelho {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JComboBox combobox;

    public ViewRemoverAparelho() throws SQLException {
        verTelaRemoverAparelho();
    }

    public static void verTelaRemoverAparelho() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Remover Aparelho");
        frame.setBounds(100, 100, 750, 550);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Salvar");
        btnSalvar.setActionCommand("removerAparelho");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Aparelhos");
        btnVoltarMenuUsuarios.setActionCommand("verTelaAparelhos");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        combobox = new JComboBox();
        AparelhoController alunoCon = new AparelhoController();
        for (int i = 0; i < alunoCon.listarAparelhos().size(); i++){
            combobox.addItem(alunoCon.listarAparelhos().get(i).getNome());
        }


        frame.add(panel);
        frame.add(combobox);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new Routes(btnSalvar, frame, combobox)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new Routes(btnAcao, frame)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new Routes(btnVoltarMenuUsuarios, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
