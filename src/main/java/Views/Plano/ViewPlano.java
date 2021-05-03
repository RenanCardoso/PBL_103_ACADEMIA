package Views.Plano;

import Modules.Controllers.PlanoController;
import Modules.Routes.RotasPlano;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ViewPlano {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAdicionar;
    private static JButton btnAlterar;
    private static JButton btnRemover;
    private static JButton btnAcao;
    private static JTable tabela;
    private static DefaultTableModel modelo = new DefaultTableModel();

    public ViewPlano() throws SQLException {
        verTelaPlano();
    }

    public static void verTelaPlano() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Planos");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        PlanoController plano = new PlanoController();

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

        plano.listarPlanosComTabela(modelo);

        JScrollPane barraRolagem = new JScrollPane(tabela);
        frame.add(barraRolagem);

        //abaixo eu crio os meus componentes
        btnAdicionar = new JButton("Adicionar um novo plano");
        btnAdicionar.setActionCommand("verTelaAdicionarPlano");
        btnAlterar = new JButton("Alterar um plano");
        btnAlterar.setActionCommand("verTelaAlterarPlano");
        btnRemover = new JButton("Remover um Plano");
        btnRemover.setActionCommand("verTelaRemoverPlano");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        frame.add(panel);
        frame.add(btnAdicionar);
        frame.add(btnAlterar);
        frame.add(btnRemover);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnAdicionar.addActionListener(new RotasPlano(btnAdicionar, frame)); //a partir daqui a Controller passará a assumir
        btnAlterar.addActionListener(new RotasPlano(btnAlterar, frame)); //a partir daqui a Controller passará a assumir
        btnRemover.addActionListener(new RotasPlano(btnRemover, frame)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasPlano(btnAcao, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
