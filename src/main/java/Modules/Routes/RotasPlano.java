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
import java.text.ParseException;

public class RotasPlano implements ActionListener {

    private JButton btnOpcao;
    private JTextField nome;
    private JLabel labelNome;
    private JComboBox duracao;
    private JLabel labelDuracao;
    private JTextField preco;
    private JLabel labelPreco;
    private JTextField limitePessoas;
    private JLabel labelLimitePessoas;
    private JComboBox flpromocao;
    private JLabel labelFlpromocao;
    private JTextField desconto;
    private JLabel labelDesconto;
    private JComboBox comboplano = new JComboBox();

    private String duracaoFormatado;
    private String promocaoFormatado;
    private Integer indicePlanoSelecionado;

    PlanoController planoCon = new PlanoController();

    //    construtor para voltar para tela principal de gerenciar planos
    public RotasPlano(JButton btnAcao, JFrame frame){
        this.btnOpcao = btnAcao;

        frame.dispose();
    }

    //    construtor para adicionar plano
    public RotasPlano(JButton opcao, JFrame frame, JTextField nome, JComboBox duracao, JTextField preco, JTextField limitePessoas, JComboBox flpromocao, JTextField desconto){
        this.btnOpcao = opcao;
        this.nome = nome;
        this.duracao = duracao;
        this.preco = preco;
        this.limitePessoas = limitePessoas;
        this.flpromocao = flpromocao;
        this.desconto = desconto;

        frame.dispose();
    }

    //    construtor para editar plano
    public RotasPlano(JButton opcao, JFrame frame, Integer indicePlanoSelecionado, JTextField nome, JComboBox duracao, JTextField preco, JTextField limitePessoas, JComboBox flpromocao, JTextField desconto){
        this.indicePlanoSelecionado = indicePlanoSelecionado;
        this.btnOpcao = opcao;
        this.nome = nome;
        this.duracao = duracao;
        this.preco = preco;
        this.limitePessoas = limitePessoas;
        this.flpromocao = flpromocao;
        this.desconto = desconto;

        frame.dispose();
    }

    //    construtor para remover plano
    public RotasPlano(JButton opcao, JFrame frame, JComboBox comboplano){
        this.btnOpcao = opcao;
        this.comboplano = comboplano;

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
                } catch (SQLException | ParseException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "adicionarPlano":
                if (nome.getText().length() > 0){
                    try {

                        duracaoFormatado = duracao.getSelectedItem().toString();
                        switch (duracaoFormatado) {

                            case "Mensal":
                                duracaoFormatado = "men";
                                break;
                            case "Trimestral":
                                duracaoFormatado = "tri";
                                break;
                            case "Semestral":
                                duracaoFormatado = "sem";
                                break;
                            case "Anual":
                                duracaoFormatado = "anul";
                                break;
                            default:
                        }

                        promocaoFormatado = flpromocao.getSelectedItem().toString();
                        String precoTemp = preco.getText().replace(",", ".");

                        Float precoFormatado = Float.parseFloat(precoTemp);
                        Integer limitePessoasFormatado = Integer.parseInt(limitePessoas.getText());
                        Integer descontoFormatado = Integer.parseInt(desconto.getText());

                        planoCon.adicionarPlano(nome.getText(), duracaoFormatado, precoFormatado, limitePessoasFormatado, promocaoFormatado, descontoFormatado);
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
                    new ViewAlterarPlano(comboplano.getSelectedIndex());
                } catch (SQLException | ParseException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "alterarPlano":
                if (nome.getText().length() > 0) {
                    try {
                        duracaoFormatado = duracao.getSelectedItem().toString();
                        switch (duracaoFormatado) {

                            case "Mensal":
                                duracaoFormatado = "men";
                                break;
                            case "Trimestral":
                                duracaoFormatado = "tri";
                                break;
                            case "Semestral":
                                duracaoFormatado = "sem";
                                break;
                            case "Anual":
                                duracaoFormatado = "anul";
                                break;
                            default:
                        }

                        promocaoFormatado = flpromocao.getSelectedItem().toString();
                        String precoTemp = preco.getText().replace(",", ".");

                        Float precoFormatado = Float.parseFloat(precoTemp);
                        Integer limitePessoasFormatado = Integer.parseInt(limitePessoas.getText());
                        Integer descontoFormatado = Integer.parseInt(desconto.getText());

                        planoCon.editarPlano(planoCon.listarPlanos().get(indicePlanoSelecionado).getId() , nome.getText(), duracaoFormatado, precoFormatado, limitePessoasFormatado, promocaoFormatado, descontoFormatado);
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
                            Integer indiceComboboxSelecionado = this.comboplano.getSelectedIndex();
                            Integer idPlanoSelecionado = null;

                            for (int i = 0; i < planoCon.listarPlanos().size(); i++) {
                                if (indiceComboboxSelecionado == i) {
                                    idPlanoSelecionado = planoCon.listarPlanos().get(i).getId();
                                }
                            }

                            String nomeTemp = this.comboplano.getSelectedItem().toString();
                            planoCon.removerPlano(idPlanoSelecionado);
                            JOptionPane.showMessageDialog(null, "Plano " + nomeTemp + " removido com sucesso!");
                            new ViewPlano();
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
