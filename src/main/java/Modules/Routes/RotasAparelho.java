package Modules.Routes;

import Modules.Controllers.AparelhoController;
import Modules.FormatterFields.FormatterField;
import Views.Aparelho.ViewAdicionarAparelho;
import Views.Aparelho.ViewAlterarAparelho;
import Views.Aparelho.ViewAparelho;
import Views.Aparelho.ViewRemoverAparelho;
import Views.MenuPrincipalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

public class RotasAparelho implements ActionListener {

    private JButton btnOpcao;
    private JLabel labelNome;
    private JTextField nome;
    private JLabel labelDescricao;
    private JTextField descricao;
    private JLabel labelCategoria;
    private JComboBox categoria;
    private JLabel labelColunaDePesoKG;
    private JTextField colunaDePesoKG;
    private JLabel labelComposicao;
    private JTextField composicao;
    private JLabel labelPesoDoAparelho;
    private JTextField pesoDoAparelho;
    private JLabel labelAlturaDoAparelho;
    private JTextField alturaDoAparelho;
    private JLabel labelPesoSuportado;
    private JTextField pesoSuportado;
    private JLabel labelLarguraDoAparelho;
    private JTextField larguraDoAparelho;
    private JLabel labelComprimentoDoAparelho;
    private JTextField comprimentoDoAparelho;
    private JLabel labelObsAparelho;
    private JTextField obsAparelho;
    private JLabel labelCor;
    private JTextField cor;
    private JLabel labelStatus;
    private JComboBox status;

    private JComboBox combobox = new JComboBox();
    AparelhoController aparelhoCon = new AparelhoController();

    private static String statusFormatado;
    private static String categoriaFormatado;

    //    construtor para voltar para tela principal de gerenciar aparelhos
    public RotasAparelho(JButton btnAcao, JFrame frame) {
        this.btnOpcao = btnAcao;

        frame.dispose();
    }

    //    construtor para adicionar aparelho
    public RotasAparelho(JButton opcao, JFrame frame, JTextField nome, JComboBox categoria, JTextField descricao, JTextField colunaDePesoKG, JTextField composicao, JTextField pesoDoAparelho, JTextField alturaDoAparelho, JTextField pesoSuportado, JTextField larguraDoAparelho, JTextField comprimentoDoAparelho, JTextField obsAparelho, JTextField cor, JComboBox status) {
        this.btnOpcao = opcao;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.colunaDePesoKG = colunaDePesoKG;
        this.composicao = composicao;
        this.pesoDoAparelho = pesoDoAparelho;
        this.alturaDoAparelho = alturaDoAparelho;
        this.pesoSuportado = pesoSuportado;
        this.larguraDoAparelho = larguraDoAparelho;
        this.comprimentoDoAparelho = comprimentoDoAparelho;
        this.obsAparelho = obsAparelho;
        this.cor = cor;
        this.status = status;

        frame.dispose();
    }

    //    construtor para editar aparelho
    public RotasAparelho(JButton opcao, JFrame frame, JTextField txtNome, JComboBox combobox) {
        this.btnOpcao = opcao;
        this.combobox = combobox;
        this.nome = txtNome;

        frame.dispose();
    }

    //    construtor para remover aparelho
    public RotasAparelho(JButton opcao, JFrame frame, JComboBox combobox) {
        this.btnOpcao = opcao;
        this.combobox = combobox;

        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String btnOpcao = this.btnOpcao.getActionCommand();
        FormatterField formatar = new FormatterField();

        switch (btnOpcao) {

            case "verTelaAparelhos":
                try {
                    new ViewAparelho();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "verTelaAdicionarAparelho":
                try {
                    new ViewAdicionarAparelho();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "adicionarAparelho":
                try {

                    int colunadepesokg = Integer.parseInt(colunaDePesoKG.getText());
                    int pesodoaparelho = Integer.parseInt(pesoDoAparelho.getText());
                    int pesosuportado = Integer.parseInt(pesoSuportado.getText());

                    categoriaFormatado = categoria.getSelectedItem().toString();
                    JOptionPane.showMessageDialog(null, "Cat antes" + categoriaFormatado);

                    switch (categoriaFormatado) {

                        case "Aparelho de Musculação":
                            categoriaFormatado = "apmu";
                            break;
                        case "Abdominal":
                            categoriaFormatado = "abdo";
                            break;
                        case "Anilhas":
                            categoriaFormatado = "anil";
                            break;
                        case "Acessórios":
                            categoriaFormatado = "aces";
                            break;
                        case "Aeróbico":
                            categoriaFormatado = "aero";
                            break;
                        case "Banco Supino":
                            categoriaFormatado = "basu";
                            break;
                        case "Barras":
                            categoriaFormatado = "barr";
                            break;
                        case "Esporte Lazer":
                            categoriaFormatado = "esla";
                            break;
                        case "Kits Barras e Anilhas":
                            categoriaFormatado = "kban";
                            break;
                        case "Peças de Reposição":
                            categoriaFormatado = "pero";
                            break;
                        case "Puxadores":
                            categoriaFormatado = "puxa";
                            break;
                        default:
                    }

                    statusFormatado = status.getSelectedItem().toString();

                    if (statusFormatado == "Ativo"){
                        statusFormatado = "ati";
                    } else {
                        statusFormatado = "ina";
                    }

                    aparelhoCon.adicionarAparelho(nome.getText(), categoriaFormatado, descricao.getText(), colunadepesokg, composicao.getText(), pesodoaparelho, alturaDoAparelho.getText(), pesosuportado, larguraDoAparelho.getText(), comprimentoDoAparelho.getText(), cor.getText(), obsAparelho.getText(), statusFormatado);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    JOptionPane.showMessageDialog(null, "Aparelho adicionado com sucesso");
                    new ViewAparelho();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
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
                try {
                    Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                    Integer idAparelhoSelecionado = null;

                    for (int i = 0; i < aparelhoCon.listarAparelhos().size(); i++) {
                        if (indiceComboboxSelecionado == i) {
                            idAparelhoSelecionado = aparelhoCon.listarAparelhos().get(i).getId();
                        }
                    }

                    aparelhoCon.editarAparelho(idAparelhoSelecionado, nome.getText());
                    JOptionPane.showMessageDialog(null, "Aparelho alterado com sucesso");

                    new ViewAparelho();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
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
