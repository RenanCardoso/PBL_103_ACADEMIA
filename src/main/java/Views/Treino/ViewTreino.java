package Views.Treino;

import Modules.Controllers.TreinoController;
import Modules.Routes.RotasTreino;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ViewTreino {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAdicionar;
    private static JButton btnAlterar;
    private static JButton btnRemover;
    private static JButton btnAcao;
    private static JTable tabela;
    private static DefaultTableModel modelo = new DefaultTableModel();

    public ViewTreino() throws SQLException {
        verTelaTreino();
    }

    public static void verTelaTreino() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Treinos");
        frame.setBounds(100, 100, 750, 550);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        TreinoController treino = new TreinoController();

        tabela = new JTable(modelo);
        if (modelo.getColumnCount() <= 0) {
            modelo.addColumn("Id");
            modelo.addColumn("Nome");
        }
        tabela.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);

        treino.listarTreinosComTabela(modelo);

        JScrollPane barraRolagem = new JScrollPane(tabela);
        frame.add(barraRolagem);

        //abaixo eu crio os meus componentes
        btnAdicionar = new JButton("Adicionar um novo treino");
        btnAdicionar.setActionCommand("verTelaAdicionarTreino");
        btnAlterar = new JButton("Alterar um treino");
        btnAlterar.setActionCommand("verTelaAlterarTreinos");
        btnRemover = new JButton("Remover um Treino");
        btnRemover.setActionCommand("verTelaRemoverTreino");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        frame.add(panel);
        frame.add(btnAdicionar);
        frame.add(btnAlterar);
        frame.add(btnRemover);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnAdicionar.addActionListener(new RotasTreino(btnAdicionar, frame)); //a partir daqui a Controller passará a assumir
        btnAlterar.addActionListener(new RotasTreino(btnAlterar, frame)); //a partir daqui a Controller passará a assumir
        btnRemover.addActionListener(new RotasTreino(btnRemover, frame)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasTreino(btnAcao, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
