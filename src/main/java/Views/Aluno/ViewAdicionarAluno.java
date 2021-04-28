package Views.Aluno;

import Modules.Routes.RotasAluno;

import javax.swing.*;
import java.awt.*;

public class ViewAdicionarAluno {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuPrinc;
    private static JTextField nome;
    private static JLabel labelNome;
    private static JTextField cpf;
    private static JLabel labelCpf;
    private static JTextField rg;
    private static JLabel labelRg;
    private static JTextField idade;
    private static JLabel labelIdade;
    private static JTextField numPrincipal;
    private static JLabel labelNumPrincipal;
    private static JTextField numSecundario;
    private static JLabel labelNumSecundario;
    private static JTextField status;
    private static JLabel labelStatus;
    private static JTextField altura;
    private static JLabel labelAltura;
    private static JTextField peso;
    private static JLabel labelPeso;

    public ViewAdicionarAluno() {
        verTelaAdicionarAluno();
    }

    public static void verTelaAdicionarAluno() {

        //        crio o meu Jframe
        frame = new JFrame("Adicionar Aluno");
        frame.setBounds(100, 100, 750, 550);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Salvar");
        btnSalvar.setActionCommand("adicionarAluno");
        btnVoltarMenuPrinc = new JButton("Voltar para o Menu de Gerenciar Alunos");
        btnVoltarMenuPrinc.setActionCommand("verTelaAlunos");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

//        labels e botões do formulário
        labelNome = new JLabel("Nome do Aluno");
        nome = new JTextField(30);
        labelCpf = new JLabel("CPF do Aluno");
        cpf = new JTextField(30);
        labelRg = new JLabel("RG do Aluno");
        rg = new JTextField(30);
        labelIdade = new JLabel("Idade do Aluno");
        idade = new JTextField(30);
        labelNumPrincipal = new JLabel("Número de celular do Aluno");
        numPrincipal = new JTextField(30);
        labelNumSecundario = new JLabel("Número de celular opcional do Aluno");
        numSecundario = new JTextField(30);
        labelStatus = new JLabel("Status do Aluno");
        status = new JTextField(30);
        labelAltura = new JLabel("Altura do Aluno");
        altura = new JTextField(30);
        labelPeso = new JLabel("Peso do Aluno");
        peso = new JTextField(30);

//        formulário
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
        frame.add(labelStatus);
        frame.add(status);
        frame.add(labelAltura);
        frame.add(altura);
        frame.add(labelPeso);
        frame.add(peso);

//        botoes de acao
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuPrinc);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
//        btnSalvar.addActionListener(new Routes(btnSalvar, frame, nome, cpf, rg, idade, numPrincipal, numSecundario, status, altura, peso)); //a partir daqui a Controller passará a assumir
        btnSalvar.addActionListener(new RotasAluno(btnSalvar, frame, nome)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasAluno(btnAcao, frame)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuPrinc.addActionListener(new RotasAluno(btnVoltarMenuPrinc, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
