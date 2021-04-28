package Modules.Routes;

import Modules.Controllers.InstrutorController;
import Views.Instrutor.ViewAdicionarInstrutor;
import Views.Instrutor.ViewAlterarInstrutor;
import Views.Instrutor.ViewInstrutores;
import Views.Instrutor.ViewRemoverInstrutor;
import Views.MenuPrincipalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RotasInstrutor implements ActionListener {

    private JButton btnOpcao;
    private JTextField txtNome;
    private JComboBox combobox = new JComboBox();

    InstrutorController instrutorCon = new InstrutorController();

    //    construtor para voltar para tela principal de gerenciar instrutores
    public RotasInstrutor(JButton btnAcao, JFrame frame){
        this.btnOpcao = btnAcao;

        frame.dispose();
    }

    //    construtor para adicionar instrutor
    public RotasInstrutor(JButton opcao, JFrame frame, JTextField txtNome){
        this.btnOpcao = opcao;
        this.txtNome = txtNome;

        frame.dispose();
    }

    //    construtor para editar instrutor
    public RotasInstrutor(JButton opcao, JFrame frame, JTextField txtNome, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;
        this.txtNome = txtNome;

        frame.dispose();
    }

    //    construtor para remover instrutor
    public RotasInstrutor(JButton opcao, JFrame frame, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;

        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String btnOpcao = this.btnOpcao.getActionCommand();

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
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "adicionarInstrutor":
                if (txtNome.getText().length() > 0){
                    try {
                        instrutorCon.adicionarInstrutor(txtNome.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        JOptionPane.showMessageDialog(null, "Instrutor adicionado com sucesso");
                        new ViewInstrutores();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do instrutor é obrigatório");
                }
                break;
            case "verTelaAlterarInstrutor":
                try {
                    new ViewAlterarInstrutor();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "alterarInstrutor":
                if (txtNome.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idAlunoSelecionado = null;

                        for (int i = 0; i < instrutorCon.listarInstrutores().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idAlunoSelecionado = instrutorCon.listarInstrutores().get(i).getId();
                            }
                        }

                        instrutorCon.editarInstrutor(idAlunoSelecionado, txtNome.getText());
                        JOptionPane.showMessageDialog(null, "Instrutor alterado com sucesso");

                        new ViewInstrutores();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do instrutor é obrigatório");
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
                            new ViewRemoverInstrutor();
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
