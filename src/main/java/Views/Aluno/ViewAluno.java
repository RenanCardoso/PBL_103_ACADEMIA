package Views.Aluno;

import Modules.Controllers.AlunoController;
import Modules.Routes.RotasAluno;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ViewAluno {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAdicionar;
    private static JButton btnAlterar;
    private static JButton btnRemover;
    private static JButton btnAcao;
    private static JTable tabela;
    private static JComboBox comboaluno;
    private static JLabel labelComboAluno;
    private static DefaultTableModel modelo = new DefaultTableModel();

        public ViewAluno() throws SQLException {
            verTelaAluno();
        }

    public static void verTelaAluno() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Alunos");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        AlunoController aluno = new AlunoController();
        labelComboAluno = new JLabel("Selecione o Aluno *");
        comboaluno = new JComboBox();
        for (int i = 0; i < aluno.listarAlunos().size(); i++){
            comboaluno.addItem(aluno.listarAlunos().get(i).getNome());
        }

        tabela = new JTable(modelo);
        if (modelo.getColumnCount() <= 0) {
            modelo.addColumn("Id");
            modelo.addColumn("Nome");
            modelo.addColumn("CPF");
            modelo.addColumn("RG");
            modelo.addColumn("E-mail");
            modelo.addColumn("Número Principal");
            modelo.addColumn("Número Secundário");
            modelo.addColumn("Idade");
            modelo.addColumn("Altura");
            modelo.addColumn("Peso");
            modelo.addColumn("Instrutor do Aluno");
            modelo.addColumn("Treino do Aluno");
            modelo.addColumn("Plano do Aluno");
            modelo.addColumn("Status");
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
        tabela.getColumnModel().getColumn(9).setMinWidth(100);
        tabela.getColumnModel().getColumn(10).setMinWidth(100);
        tabela.getColumnModel().getColumn(11).setMinWidth(100);
        tabela.getColumnModel().getColumn(12).setMinWidth(100);

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

        aluno.listarAlunosComTabela(modelo);

        JScrollPane barraRolagem = new JScrollPane(tabela);
        frame.add(barraRolagem);

        //abaixo eu crio os meus componentes
        btnAdicionar = new JButton("Adicionar um novo aluno");
        btnAdicionar.setActionCommand("verTelaAdicionarAluno");
        btnAlterar = new JButton("Alterar um aluno");
        btnAlterar.setActionCommand("verTelaAlterarAlunos");
        btnRemover = new JButton("Remover um Aluno");
        btnRemover.setActionCommand("verTelaRemoverAluno");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        frame.add(panel);
        frame.add(btnAdicionar);
        frame.add(labelComboAluno);
        frame.add(comboaluno);
        frame.add(btnAlterar);
        frame.add(btnRemover);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnAdicionar.addActionListener(new RotasAluno(btnAdicionar, frame)); //a partir daqui a Controller passará a assumir
        btnAlterar.addActionListener(new RotasAluno(btnAlterar, frame, comboaluno)); //a partir daqui a Controller passará a assumir
        btnRemover.addActionListener(new RotasAluno(btnRemover, frame)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasAluno(btnAcao, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
