package Modules.Routes;

import Modules.Controllers.AlunoController;
import Views.Aluno.ViewAdicionarAluno;
import Views.Aluno.ViewAlterarAluno;
import Views.Aluno.ViewAluno;
import Views.Aluno.ViewRemoverAluno;
import Views.MenuPrincipalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

public class RotasAluno implements ActionListener {

    private static JTextField txtnome;
    private static JTextField txtcpf;
    private static JTextField txtrg;
    private static JTextField txtidade;
    private static JTextField txtemail;
    private static JTextField txtnumPrincipal;
    private static JTextField txtnumSecundario;
    private JComboBox comboinstrutor = new JComboBox();
    private JComboBox comboplano = new JComboBox();
    private JComboBox combofichatreino = new JComboBox();
    private JComboBox combostatus= new JComboBox();
    private static JTextField txtaltura;
    private static JTextField txtpeso;
    private JButton btnOpcao;
    private JComboBox combobox = new JComboBox();

    AlunoController alunoCon = new AlunoController();

//    construtor para voltar para tela principal de gerenciar alunos
    public RotasAluno(JButton btnAcao, JFrame frame){
        this.btnOpcao = btnAcao;

        frame.dispose();
    }

    //    construtor para adicionar aluno com somente os campos obrigatórios
    public RotasAluno(JButton opcao, JFrame frame, JTextField nome, JTextField cpf, JTextField rg, JTextField idade, JTextField numPrincipal, JComboBox status, JComboBox planos, JComboBox instrutores){
        this.btnOpcao = opcao;
        this.comboinstrutor = instrutores;
        this.comboplano = planos;
        this.txtnome = nome;
        this.txtcpf = cpf;
        this.txtrg = rg;
        this.txtidade = idade;
        this.txtnumPrincipal = numPrincipal;
        this.combobox = status;
        frame.dispose();
    }

    //    construtor para editar aluno
    public RotasAluno(JButton opcao, JFrame frame, JTextField txtnome, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;
        this.txtnome = txtnome;

        frame.dispose();
    }

    //    construtor para remover aluno
    public RotasAluno(JButton opcao, JFrame frame, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;

        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String btnOpcao = this.btnOpcao.getActionCommand();

        switch (btnOpcao) {
            case "verTelaAlunos":
                try {
                    new ViewAluno();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "verTelaAdicionarAluno":
                try {
                    new ViewAdicionarAluno();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "adicionarAluno":
                try {
                    if (txtnome.getText().length() > 0) {
                        int idade = Integer.parseInt(txtidade.getText());
                        alunoCon.adicionarAluno(txtnome.getText(), txtcpf.getText(), txtrg.getText(), idade, txtnumPrincipal.getText(), combostatus.getActionCommand(), comboplano.getSelectedIndex(), comboinstrutor.getSelectedIndex());
                        JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso");
                        new ViewAluno();
                    } else {
                        JOptionPane.showMessageDialog(null, "Nome do aluno é obrigatório");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "verTelaAlterarAlunos":
                try {
                    new ViewAlterarAluno();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "alterarAluno":
                if (txtnome.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idAlunoSelecionado = null;

                        for (int i = 0; i < alunoCon.listarAlunos().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idAlunoSelecionado = alunoCon.listarAlunos().get(i).getId();
                            }
                        }

                        alunoCon.editarAluno(idAlunoSelecionado, txtnome.getText());
                        JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso");
                        new ViewAluno();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do aluno é obrigatório");
                }
                break;
            case "verTelaRemoverAluno":
                try {
                    new ViewRemoverAluno();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "removerAluno":
                try {
                    if (alunoCon.listarAlunos().size() > 0) {
                        try {
                            Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                            Integer idAlunoSelecionado = null;

                            for (int i = 0; i < alunoCon.listarAlunos().size(); i++) {
                                if (indiceComboboxSelecionado == i) {
                                    idAlunoSelecionado = alunoCon.listarAlunos().get(i).getId();
                                }
                            }

                            String nomeTemp = this.combobox.getSelectedItem().toString();
                            alunoCon.removerAluno(idAlunoSelecionado);
                            JOptionPane.showMessageDialog(null, "Aluno " + nomeTemp + " removido com sucesso!");
                            new ViewRemoverAluno();
                        } catch (SQLException throwables) {
                            JOptionPane.showMessageDialog(null, "Houve um erro ao tentar fazer a remoção.");
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
