package Modules.Routes;

import Modules.Controllers.PlanoController;
import Views.MenuPrincipalView;
import Views.Plano.ViewAdicionarPlano;
import Views.Plano.ViewAlterarPlano;
import Views.Plano.ViewPlano;
import Views.Plano.ViewRemoverPlano;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RotasPlano implements ActionListener {

    private JButton btnOpcao;
    private JTextField txtNome;
    private JComboBox combobox = new JComboBox();

    PlanoController planoCon = new PlanoController();

    //    construtor para voltar para tela principal de gerenciar planos
    public RotasPlano(JButton btnAcao, JFrame frame){
        this.btnOpcao = btnAcao;

        frame.dispose();
    }

    //    construtor para adicionar plano
    public RotasPlano(JButton opcao, JFrame frame, JTextField txtNome){
        this.btnOpcao = opcao;
        this.txtNome = txtNome;

        frame.dispose();
    }

    //    construtor para editar plano
    public RotasPlano(JButton opcao, JFrame frame, JTextField txtNome, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;
        this.txtNome = txtNome;

        frame.dispose();
    }

    //    construtor para remover plano
    public RotasPlano(JButton opcao, JFrame frame, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;

        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String btnOpcao = this.btnOpcao.getActionCommand();

        switch (btnOpcao) {

            case "verTelaPlanos":
                try {
                    new ViewPlano();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "verTelaAdicionarPlano":
                try {
                    new ViewAdicionarPlano();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "adicionarPlano":
                if (txtNome.getText().length() > 0){
                    try {
                        planoCon.adicionarPlano(txtNome.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Plano adicionado com sucesso");
                    try {
                        new ViewPlano();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do plano é obrigatório");
                }
                break;
            case "verTelaAlterarPlano":
                try {
                    new ViewAlterarPlano();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "alterarPlano":
                if (txtNome.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idPlanoSelecionado = null;

                        for (int i = 0; i < planoCon.listarPlanos().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idPlanoSelecionado = planoCon.listarPlanos().get(i).getId();
                            }
                        }

                        planoCon.editarPlano(idPlanoSelecionado, txtNome.getText());
                        JOptionPane.showMessageDialog(null, "Plano alterado com sucesso");

                        new ViewPlano();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do plano é obrigatório");
                }
                break;
            case "verTelaRemoverPlano":
                try {
                    new ViewRemoverPlano();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "removerPlano":
                try {
                    if (planoCon.listarPlanos().size() > 0) {
                        try {
                            Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                            Integer idPlanoSelecionado = null;

                            for (int i = 0; i < planoCon.listarPlanos().size(); i++) {
                                if (indiceComboboxSelecionado == i) {
                                    idPlanoSelecionado = planoCon.listarPlanos().get(i).getId();
                                }
                            }

                            String nomeTemp = this.combobox.getSelectedItem().toString();
                            planoCon.removerPlano(idPlanoSelecionado);
                            JOptionPane.showMessageDialog(null, "Plano " + nomeTemp + " removido com sucesso!");
                            new ViewRemoverPlano();
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
