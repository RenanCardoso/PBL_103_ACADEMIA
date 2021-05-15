package Views.Plano;

import Modules.Routes.RotasPlano;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;

public class ViewAdicionarPlano {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JTextField nome;
    private static JLabel labelNome;
    private static JComboBox duracao;
    private static JLabel labelDuracao;
    private static JTextField preco;
    private static JLabel labelPreco;
    private static JTextField limitePessoas;
    private static JLabel labelLimitePessoas;
    private static JComboBox flpromocao;
    private static JLabel labelFlpromocao;
    private static JTextField desconto;
    private static JLabel labelDesconto;

    public ViewAdicionarPlano() throws SQLException, ParseException {
        verTelaAdicionarPlano();
    }

    public static void verTelaAdicionarPlano() throws SQLException, ParseException {

        //        crio o meu Jframe
        frame = new JFrame("Adicionar Plano");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Adicionar");
        btnSalvar.setActionCommand("adicionarPlano");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Planos");
        btnVoltarMenuUsuarios.setActionCommand("verTelaPlanos");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        labelNome = new JLabel("Nome do Plano");
        nome = new JTextField(30);

        labelDuracao = new JLabel("Duração do Plano *");
        duracao = new JComboBox();
        duracao.addItem("Mensal");
        duracao.addItem("Trimestral");
        duracao.addItem("Semestral");
        duracao.addItem("Anual");

        labelPreco = new JLabel("Preço do Plano: ");
        preco = new JFormattedTextField(new MaskFormatter("###"));
        preco.setColumns(20);

        labelLimitePessoas = new JLabel("Limite de pessoas participantes do plano: ");
        limitePessoas = new JFormattedTextField(new MaskFormatter("###"));
        limitePessoas.setColumns(20);

        labelFlpromocao = new JLabel("Plano em promoção? *");
        flpromocao = new JComboBox();
        flpromocao.addItem("Sim");
        flpromocao.addItem("Não");

        labelDesconto = new JLabel("Desconto: ");
        desconto = new JFormattedTextField(new MaskFormatter("##"));
        desconto.setColumns(20);

        frame.add(panel);
        frame.add(labelNome);
        frame.add(nome);
        frame.add(labelDuracao);
        frame.add(duracao);
        frame.add(labelPreco);
        frame.add(preco);
        frame.add(labelLimitePessoas);
        frame.add(limitePessoas);
        frame.add(labelFlpromocao);
        frame.add(flpromocao);
        frame.add(labelDesconto);
        frame.add(desconto);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new RotasPlano(btnSalvar, frame, nome, duracao, preco, limitePessoas, flpromocao, desconto)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasPlano(btnAcao, frame)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new RotasPlano(btnVoltarMenuUsuarios, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
