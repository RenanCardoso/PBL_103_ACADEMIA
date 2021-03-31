package Views;

import Models.Aluno;
import Modules.Controllers.AlunoController;
import Modules.Controllers.Routes;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewAluno {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAdicionar;
    private static JButton btnAlterar;
    private static JButton btnRemover;
    private static JButton btnAcao;
    private static JTable tabela;
    private static DefaultTableModel modelo = new DefaultTableModel();

        public ViewAluno() throws SQLException {
            verTelaAluno();
        }

    public static void verTelaAluno() throws SQLException {

        //        crio o meu Jframe
        frame = new JFrame("Alunos");
        frame.setBounds(100, 100, 750, 550);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        AlunoController aluno = new AlunoController();

        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);

        aluno.listarAlunos(modelo);

        JScrollPane barraRolagem = new JScrollPane(tabela);
        frame.add(barraRolagem);

        //abaixo eu crio os meus componentes
        btnAdicionar = new JButton("Adicionar um novo aluno");
        btnAdicionar.setActionCommand("adicionarAluno");
        btnAlterar = new JButton("Alterar um aluno");
        btnAlterar.setActionCommand("alterarAluno");
        btnRemover = new JButton("Remover um Aluno");
        btnRemover.setActionCommand("removerAluno");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        frame.add(panel);
        frame.add(btnAdicionar);
        frame.add(btnAlterar);
        frame.add(btnRemover);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnAlterar.addActionListener(new Routes(btnAlterar, frame)); //a partir daqui a Controller passará a assumir
        btnRemover.addActionListener(new Routes(btnRemover, frame)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new Routes(btnAcao, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
