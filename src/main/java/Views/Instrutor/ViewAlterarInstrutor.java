package Views.Instrutor;

import Modules.Controllers.InstrutorController;
import Modules.Routes.RotasInstrutor;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;

public class ViewAlterarInstrutor {

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
    private static JComboBox status;
    private static JLabel labelStatus;
    private static JComboBox comboinstrutor;
    private static JLabel labelComboInstrutor;

    public ViewAlterarInstrutor(Integer indiceInstrutorSelecionado) throws SQLException, ParseException {
        verTelaAlterarInstrutor(indiceInstrutorSelecionado);
    }

    public static void verTelaAlterarInstrutor(Integer indiceInstrutorSelecionado) throws SQLException, ParseException {

        //        crio o meu Jframe
        frame = new JFrame("Alterar Instrutor");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        labelNome = new JLabel("Insira o novo nome do Instrutor: *");
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

        labelComboInstrutor = new JLabel("Instrutor:");
        comboinstrutor = new JComboBox();
        InstrutorController InstrutorCon = new InstrutorController();

        if (indiceInstrutorSelecionado != null){
            comboinstrutor.addItem(InstrutorCon.listarInstrutores().get(indiceInstrutorSelecionado).getNome());
            nome.setText(InstrutorCon.listarInstrutores().get(indiceInstrutorSelecionado).getNome());
            cpf.setText(InstrutorCon.listarInstrutores().get(indiceInstrutorSelecionado).getCpf());
            rg.setText(InstrutorCon.listarInstrutores().get(indiceInstrutorSelecionado).getRg());
            idade.setText(InstrutorCon.listarInstrutores().get(indiceInstrutorSelecionado).getIdade().toString());
            numPrincipal.setText(InstrutorCon.listarInstrutores().get(indiceInstrutorSelecionado).getNumPrincipal());
            numSecundario.setText(InstrutorCon.listarInstrutores().get(indiceInstrutorSelecionado).getNumSecundario());
            email.setText(InstrutorCon.listarInstrutores().get(indiceInstrutorSelecionado).getEmail());
        }

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Alterar");
        btnSalvar.setActionCommand("alterarInstrutor");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Instrutores");
        btnVoltarMenuUsuarios.setActionCommand("verTelaInstrutores");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        frame.add(panel);
        frame.add(labelComboInstrutor);
        frame.add(comboinstrutor);
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
        frame.add(btnSalvar);
        frame.add(btnAcao);
        frame.add(btnVoltarMenuUsuarios);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new RotasInstrutor(btnSalvar, indiceInstrutorSelecionado, frame, nome, cpf, rg, idade, numPrincipal, numSecundario, status, email)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasInstrutor(btnAcao, frame)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new RotasInstrutor(btnVoltarMenuUsuarios, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
