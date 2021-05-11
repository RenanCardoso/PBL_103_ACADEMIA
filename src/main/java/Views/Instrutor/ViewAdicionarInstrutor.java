package Views.Instrutor;

import Modules.Routes.RotasInstrutor;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class ViewAdicionarInstrutor {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JTextField nome;
    private static JLabel labelNome;
    private static JTextField cpf;
    private static JLabel labelCpf;
    private static JTextField rg;
    private static JLabel labelRg;
    private static JTextField idade;
    private static JLabel labelIdade;
    private static JTextField email;
    private static JLabel labelEmail;
    private static JTextField numPrincipal;
    private static JLabel labelNumPrincipal;
    private static JTextField numSecundario;
    private static JLabel labelNumSecundario;
    private static JLabel labelStatus;
    private static JComboBox status;

    public ViewAdicionarInstrutor() throws ParseException {
        verTelaAdicionarInstrutor();
    }

    public static void verTelaAdicionarInstrutor() throws ParseException {

        //        crio o meu Jframe
        frame = new JFrame("Adicionar Instrutor");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Adicionar");
        btnSalvar.setActionCommand("adicionarInstrutor");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Instrutores");
        btnVoltarMenuUsuarios.setActionCommand("verTelaInstrutores");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        labelNome = new JLabel("Nome do Instrutor");
        nome = new JTextField(30);
        labelCpf = new JLabel("CPF do Instrutor *");
        cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        labelRg = new JLabel("RG do Instrutor *");
        rg = new JTextField(30);
        labelIdade = new JLabel("Idade do Instrutor *");
        idade = new JFormattedTextField(new MaskFormatter("##"));
        idade.setColumns(20);
        labelNumPrincipal = new JLabel("Número de celular do Instrutor *");
        numPrincipal = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
        labelNumSecundario = new JLabel("Número de celular opcional do Instrutor");
        numSecundario = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
        labelEmail = new JLabel("E-mail do Instrutor");
        email = new JTextField(30);
        labelStatus = new JLabel("Status do Instrutor *");
        status = new JComboBox();
        status.addItem("Ativo");
        status.addItem("Inativo");

        frame.add(panel);
        frame.add(labelNome);
        frame.add(nome);
        frame.add(labelCpf);
        frame.add(cpf);
        frame.add(labelRg);
        frame.add(rg);
        frame.add(labelIdade);
        frame.add(idade);
        frame.add(labelNumPrincipal);
        frame.add(numPrincipal);
        frame.add(labelNumSecundario);
        frame.add(numSecundario);
        frame.add(labelEmail);
        frame.add(email);
        frame.add(labelStatus);
        frame.add(status);

//        botoes de acao
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new RotasInstrutor(btnSalvar, frame, nome, cpf, rg, idade, numPrincipal, numSecundario, status, email)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasInstrutor(btnAcao, frame)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new RotasInstrutor(btnVoltarMenuUsuarios, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
