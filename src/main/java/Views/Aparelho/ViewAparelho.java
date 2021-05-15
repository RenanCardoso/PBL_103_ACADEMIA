package Views.Aparelho;

import Modules.Controllers.AparelhoController;
import Modules.Routes.RotasAparelho;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ViewAparelho {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAdicionar;
    private static JButton btnAlterar;
    private static JButton btnRemover;
    private static JButton btnAcao;
    private static JTable tabela;
    private static JComboBox comboaparelho;
    private static JLabel labelComboAparelho;
    private static DefaultTableModel modelo = new DefaultTableModel();

    public ViewAparelho() throws SQLException {
        verTelaAparelho();
    }

    public static void verTelaAparelho() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Aparelhos");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        AparelhoController aparelho = new AparelhoController();
        labelComboAparelho = new JLabel("Selecione o Aparelho *");
        comboaparelho = new JComboBox();
        for (int i = 0; i < aparelho.listarAparelhos().size(); i++){
            comboaparelho.addItem(aparelho.listarAparelhos().get(i).getNome());
        }

        tabela = new JTable(modelo);
        if (modelo.getColumnCount() <= 0) {
            modelo.addColumn("Id");
            modelo.addColumn("Nome");
            modelo.addColumn("Categoria");
            modelo.addColumn("Descrição");
            modelo.addColumn("Coluna de peso (KG)");
            modelo.addColumn("Composição");
            modelo.addColumn("Peso do Aparelho");
            modelo.addColumn("Peso Suportado");
            modelo.addColumn("Altura do Aparelho");
            modelo.addColumn("Largura do Aparelho");
            modelo.addColumn("Comprimento do Aparelho");
            modelo.addColumn("Cor do Aparelho");
            modelo.addColumn("Observação do Aparelho");
            modelo.addColumn("Status");
        }

        tabela.setLayout(new GridBagLayout());
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(8).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(9).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(10).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(11).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(12).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(13).setPreferredWidth(100);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(7).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(8).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(9).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(10).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(11).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(12).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(13).setCellRenderer(centralizado);

        aparelho.listarAparelhosComTabela(modelo);

        JScrollPane barraRolagem = new JScrollPane(tabela);
        frame.add(barraRolagem);

        //abaixo eu crio os meus componentes
        btnAdicionar = new JButton("Adicionar um novo aparelho");
        btnAdicionar.setActionCommand("verTelaAdicionarAparelho");
        btnAlterar = new JButton("Alterar um aparelho");
        btnAlterar.setActionCommand("verTelaAlterarAparelho");
        btnRemover = new JButton("Remover um Aparelho");
        btnRemover.setActionCommand("verTelaRemoverAparelho");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        frame.add(panel);
        frame.add(btnAdicionar);
        frame.add(labelComboAparelho);
        frame.add(comboaparelho);
        frame.add(btnAlterar);
        frame.add(btnRemover);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnAdicionar.addActionListener(new RotasAparelho(btnAdicionar, frame)); //a partir daqui a Controller passará a assumir
        btnAlterar.addActionListener(new RotasAparelho(btnAlterar, frame, comboaparelho)); //a partir daqui a Controller passará a assumir
        btnRemover.addActionListener(new RotasAparelho(btnRemover, frame)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasAparelho(btnAcao, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
