package Views.Instrutor;

import Modules.Controllers.InstrutorController;
import Modules.Routes.RotasInstrutor;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ViewInstrutores {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAdicionar;
    private static JButton btnAlterar;
    private static JButton btnRemover;
    private static JButton btnAcao;
    private static JTable tabela;
    private static JComboBox comboinstrutor;
    private static JLabel labelComboInstrutor;
    private static DefaultTableModel modelo = new DefaultTableModel();

    public ViewInstrutores() throws SQLException {
        verTelaInstrutor();
    }

    public static void verTelaInstrutor() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Instrutores");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        InstrutorController instrutor = new InstrutorController();


        labelComboInstrutor = new JLabel("Selecione o Instrutor *");
        comboinstrutor = new JComboBox();
        for (int i = 0; i < instrutor.listarInstrutores().size(); i++){
            comboinstrutor.addItem(instrutor.listarInstrutores().get(i).getNome());
        }

        tabela = new JTable(modelo);
        if (modelo.getColumnCount() <= 0) {
            modelo.addColumn("Id");
            modelo.addColumn("Nome");
            modelo.addColumn("CPF");
            modelo.addColumn("RG");
            modelo.addColumn("Idade");
            modelo.addColumn("Número Principal");
            modelo.addColumn("Número Secundário");
            modelo.addColumn("Status");
            modelo.addColumn("E-mail");

        }
        tabela.setLayout(new GridBagLayout());
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setMinWidth(50);
        tabela.getColumnModel().getColumn(1).setMinWidth(250);
        tabela.getColumnModel().getColumn(2).setMinWidth(100);
        tabela.getColumnModel().getColumn(3).setMinWidth(100);
        tabela.getColumnModel().getColumn(4).setMinWidth(100);
        tabela.getColumnModel().getColumn(5).setMinWidth(100);
        tabela.getColumnModel().getColumn(6).setMinWidth(100);
        tabela.getColumnModel().getColumn(7).setMinWidth(100);
        tabela.getColumnModel().getColumn(8).setMinWidth(100);

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

        instrutor.listarInstrutoresComTabela(modelo);

        JScrollPane barraRolagem = new JScrollPane(tabela);
        frame.add(barraRolagem);

        //abaixo eu crio os meus componentes
        btnAdicionar = new JButton("Adicionar um novo instrutor");
        btnAdicionar.setActionCommand("verTelaAdicionarInstrutor");
        btnAlterar = new JButton("Alterar um instrutor");
        btnAlterar.setActionCommand("verTelaAlterarInstrutor");
        btnRemover = new JButton("Remover um Instrutor");
        btnRemover.setActionCommand("verTelaRemoverInstrutor");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        frame.add(panel);
        frame.add(labelComboInstrutor);
        frame.add(comboinstrutor);
        frame.add(btnAdicionar);
        frame.add(btnAlterar);
        frame.add(btnRemover);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnAdicionar.addActionListener(new RotasInstrutor(btnAdicionar, frame)); //a partir daqui a Controller passará a assumir
        btnAlterar.addActionListener(new RotasInstrutor(btnAlterar, frame, comboinstrutor)); //a partir daqui a Controller passará a assumir
        btnRemover.addActionListener(new RotasInstrutor(btnRemover, frame)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasInstrutor(btnAcao, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
