package Modules.Routes;

import Modules.Controllers.InstrutorController;
import Modules.FormatterFields.FormatterField;
import Views.Instrutor.ViewAdicionarInstrutor;
import Views.Instrutor.ViewAlterarInstrutor;
import Views.Instrutor.ViewInstrutores;
import Views.Instrutor.ViewRemoverInstrutor;
import Views.MenuPrincipalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

public class RotasInstrutor implements ActionListener {

    private JButton btnOpcao;
    private JComboBox combobox = new JComboBox();

    private static JTextField txtnome;
    private static JTextField txtcpf;
    private static JTextField txtrg;
    private static JTextField txtidade;
    private static JTextField txtemail;
    private static JTextField txtnumPrincipal;
    private static JTextField txtnumSecundario;
    private JComboBox combostatus = new JComboBox();
    private JComboBox comboinstrutor = new JComboBox();

    private static String cpfFormatado;
    private static String numPrincipalFormatado;
    private static String numSecundarioFormatado;
    private static String statusFormatado;
    private static Integer indiceInstrutorSelecionado;

    InstrutorController instrutorCon = new InstrutorController();

    //    construtor para voltar para tela principal de gerenciar instrutores
    public RotasInstrutor(JButton btnAcao, JFrame frame){
        this.btnOpcao = btnAcao;

        frame.dispose();
    }

    //    construtor para adicionar instrutor
    public RotasInstrutor(JButton btnSalvar, JFrame frame, JTextField nome, JTextField cpf, JTextField rg, JTextField idade, JTextField numPrincipal, JTextField numSecundario, JComboBox status, JTextField email) {

        this.btnOpcao = btnSalvar;
        this.txtnome = nome;
        this.txtemail = email;
        this.txtcpf = cpf;
        this.txtrg = rg;
        this.txtidade = idade;
        this.txtnumPrincipal = numPrincipal;
        this.txtnumSecundario = numSecundario;
        this.combostatus = status;

        frame.dispose();
    }

    //    construtor para editar instrutor
    public RotasInstrutor (JButton btnSalvar, Integer indiceInstrutorSelecionado, JFrame frame, JTextField nome, JTextField cpf, JTextField rg, JTextField idade, JTextField numPrincipal, JTextField numSecundario, JComboBox status, JTextField email) {

        this.btnOpcao = btnSalvar;
        this.indiceInstrutorSelecionado = indiceInstrutorSelecionado;
        this.txtnome = nome;
        this.txtemail = email;
        this.txtcpf = cpf;
        this.txtrg = rg;
        this.txtidade = idade;
        this.txtnumPrincipal = numPrincipal;
        this.txtnumSecundario = numSecundario;
        this.combostatus = status;

        frame.dispose();
    }

    //    construtor para remover instrutor
    public RotasInstrutor(JButton opcao, JFrame frame, JComboBox comboinstrutor){
        this.btnOpcao = opcao;
        this.comboinstrutor = comboinstrutor;

        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String btnOpcao = this.btnOpcao.getActionCommand();
        FormatterField formatar = new FormatterField();

        switch (btnOpcao) {

            case "verTelaInstrutores":
                try {
                    new ViewInstrutores();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "verTelaAdicionarInstrutor":
                try {
                    new ViewAdicionarInstrutor();
                } catch (ParseException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "adicionarInstrutor":

                    try {
                        int idade = Integer.parseInt(txtidade.getText());
                        cpfFormatado = formatar.formatarCPF(txtcpf);
                        numPrincipalFormatado = formatar.formatarCelular(txtnumPrincipal);
                        numSecundarioFormatado = formatar.formatarCelular(txtnumPrincipal);
                        statusFormatado = combostatus.getSelectedItem().toString();

                        if (statusFormatado == "Ativo"){
                            statusFormatado = "ati";
                        } else {
                            statusFormatado = "ina";
                        }

                        instrutorCon.adicionarInstrutor(txtnome.getText(), cpfFormatado, txtrg.getText(), idade, numPrincipalFormatado, numSecundarioFormatado, statusFormatado, txtemail.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        JOptionPane.showMessageDialog(null, "Instrutor adicionado com sucesso");
                        new ViewInstrutores();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                break;
            case "verTelaAlterarInstrutor":
                try {
                    new ViewAlterarInstrutor(comboinstrutor.getSelectedIndex());
                } catch (SQLException | ParseException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "alterarInstrutor":

                    try {
                        int idade = Integer.parseInt(txtidade.getText());
                        cpfFormatado = formatar.formatarCPF(txtcpf);
                        numPrincipalFormatado = formatar.formatarCelular(txtnumPrincipal);
                        numSecundarioFormatado = formatar.formatarCelular(txtnumPrincipal);
                        statusFormatado = combostatus.getSelectedItem().toString();

                        if (statusFormatado == "Ativo"){
                            statusFormatado = "ati";
                        } else {
                            statusFormatado = "ina";
                        }

                        JOptionPane.showMessageDialog(null, "Instrutor alterado com sucesso");
                        instrutorCon.editarInstrutor(instrutorCon.listarInstrutores().get(indiceInstrutorSelecionado).getId(), txtnome.getText(), cpfFormatado, txtrg.getText(), idade, numPrincipalFormatado, numSecundarioFormatado, statusFormatado, txtemail.getText());

                        new ViewInstrutores();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                break;
            case "verTelaRemoverInstrutor":
                try {
                    new ViewRemoverInstrutor();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "removerInstrutor":
                try {
                    if (instrutorCon.listarInstrutores().size() > 0) {
                        try {
                            Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                            Integer idAInstrutorSelecionado = null;

                            for (int i = 0; i < instrutorCon.listarInstrutores().size(); i++) {
                                if (indiceComboboxSelecionado == i) {
                                    idAInstrutorSelecionado = instrutorCon.listarInstrutores().get(i).getId();
                                }
                            }

                            String nomeTemp = this.combobox.getSelectedItem().toString();
                            instrutorCon.removerInstrutor(idAInstrutorSelecionado);
                            JOptionPane.showMessageDialog(null, "Instrutor " + nomeTemp + " removido com sucesso!");
                            new ViewInstrutores();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Não é possível fazer a remoção se a lista está vazia.");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

            case "VoltarMenuPrincipal":
                new MenuPrincipalView();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");

        }
    }
}
