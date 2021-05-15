package Modules.Routes;

import Modules.Controllers.TreinoController;
import Views.MenuPrincipalView;
import Views.Treino.ViewAdicionarTreino;
import Views.Treino.ViewAlterarTreino;
import Views.Treino.ViewRemoverTreino;
import Views.Treino.ViewTreino;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RotasTreino implements ActionListener {

    private JButton btnOpcao;
    private JTextField txtNome;
    private JComboBox combobox = new JComboBox();

    TreinoController treinoCon = new TreinoController();

    //    construtor para voltar para tela principal de gerenciar treinos
    public RotasTreino(JButton btnAcao, JFrame frame){
        this.btnOpcao = btnAcao;

        frame.dispose();
    }

    //    construtor para adicionar treino
    public RotasTreino(JButton opcao, JFrame frame, JTextField txtNome){
        this.btnOpcao = opcao;
        this.txtNome = txtNome;

        frame.dispose();
    }

    //    construtor para editar treino
    public RotasTreino(JButton opcao, JFrame frame, JTextField txtNome, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;
        this.txtNome = txtNome;

        frame.dispose();
    }

    //    construtor para remover treino
    public RotasTreino(JButton opcao, JFrame frame, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;

        frame.dispose();
    }

    public void actionPerformed(ActionEvent actionEvent) {

        String btnOpcao = this.btnOpcao.getActionCommand();

        switch (btnOpcao) {
            case "verTelaTreinos":
                try {
                    new ViewTreino();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "verTelaAdicionarTreino":
                try {
                    new ViewAdicionarTreino();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "adicionarTreino":
                if (txtNome.getText().length() > 0){
                    try {
                        treinoCon.adicionarTreino(txtNome.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        JOptionPane.showMessageDialog(null, "Treino adicionado com sucesso");
                        new ViewTreino();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do treino é obrigatório");
                }
                break;
            case "verTelaAlterarTreino":
                try {
                    new ViewAlterarTreino();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "alterarTreino":
                if (txtNome.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idTreinoSelecionado = null;

                        for (int i = 0; i < treinoCon.listarTreinos().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idTreinoSelecionado = treinoCon.listarTreinos().get(i).getId();
                            }
                        }

                        treinoCon.editarTreino(idTreinoSelecionado, txtNome.getText());
                        JOptionPane.showMessageDialog(null, "Treino alterado com sucesso");

                        new ViewTreino();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do treino é obrigatório");
                }
                break;
            case "verTelaRemoverTreino":
                try {
                    new ViewRemoverTreino();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "removerTreino":
                try {
                    if (treinoCon.listarTreinos().size() > 0) {
                        try {
                            Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                            Integer idTreinoSelecionado = null;

                            for (int i = 0; i < treinoCon.listarTreinos().size(); i++) {
                                if (indiceComboboxSelecionado == i) {
                                    idTreinoSelecionado = treinoCon.listarTreinos().get(i).getId();
                                }
                            }

                            String nomeTemp = this.combobox.getSelectedItem().toString();
                            treinoCon.removerTreino(idTreinoSelecionado);
                            JOptionPane.showMessageDialog(null, "Treino " + nomeTemp + " removido com sucesso!");
                            new ViewTreino();
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
