package Modules.Routes;

import Modules.Controllers.AparelhoController;
import Views.Aparelho.ViewAdicionarAparelho;
import Views.Aparelho.ViewAlterarAparelho;
import Views.Aparelho.ViewAparelho;
import Views.Aparelho.ViewRemoverAparelho;
import Views.MenuPrincipalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RotasAparelho implements ActionListener {

    private JButton btnOpcao;
    private JTextField txtNome;
    private JComboBox combobox = new JComboBox();

    AparelhoController aparelhoCon = new AparelhoController();

    //    construtor para voltar para tela principal de gerenciar aparelhos
    public RotasAparelho(JButton btnAcao, JFrame frame){
        this.btnOpcao = btnAcao;

        frame.dispose();
    }

    //    construtor para adicionar aparelho
    public RotasAparelho(JButton opcao, JFrame frame, JTextField txtNome){
        this.btnOpcao = opcao;
        this.txtNome = txtNome;

        frame.dispose();
    }

    //    construtor para editar aparelho
    public RotasAparelho(JButton opcao, JFrame frame, JTextField txtNome, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;
        this.txtNome = txtNome;

        frame.dispose();
    }

    //    construtor para remover aparelho
    public RotasAparelho(JButton opcao, JFrame frame, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;

        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String btnOpcao = this.btnOpcao.getActionCommand();

        switch (btnOpcao) {

            case "verTelaAparelhos":
                try {
                    new ViewAparelho();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "verTelaAdicionarAparelho":
                new ViewAdicionarAparelho();
                break;
            case "adicionarAparelho":
                if (txtNome.getText().length() > 0){
                    try {
                        aparelhoCon.adicionarAparelho(txtNome.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        JOptionPane.showMessageDialog(null, "Aparelho adicionado com sucesso");
                        new ViewAparelho();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do aparelho é obrigatório");
                }
                break;
            case "verTelaAlterarAparelho":
                try {
                    new ViewAlterarAparelho();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "alterarAparelho":
                if (txtNome.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idAparelhoSelecionado = null;

                        for (int i = 0; i < aparelhoCon.listarAparelhos().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idAparelhoSelecionado = aparelhoCon.listarAparelhos().get(i).getId();
                            }
                        }

                        aparelhoCon.editarAparelho(idAparelhoSelecionado, txtNome.getText());
                        JOptionPane.showMessageDialog(null, "Aparelho alterado com sucesso");

                        new ViewAparelho();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do aparelho é obrigatório");
                }
                break;
            case "verTelaRemoverAparelho":
                try {
                    new ViewRemoverAparelho();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "removerAparelho":
                try {
                    if (aparelhoCon.listarAparelhos().size() > 0) {
                        try {
                            Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                            Integer idAparelhoSelecionado = null;

                            for (int i = 0; i < aparelhoCon.listarAparelhos().size(); i++) {
                                if (indiceComboboxSelecionado == i) {
                                    idAparelhoSelecionado = aparelhoCon.listarAparelhos().get(i).getId();
                                }
                            }

                            String nomeTemp = this.combobox.getSelectedItem().toString();
                            aparelhoCon.removerAparelho(idAparelhoSelecionado);
                            JOptionPane.showMessageDialog(null, "Aparelho " + nomeTemp + " removido com sucesso!");
                            new ViewRemoverAparelho();
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
