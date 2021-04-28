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

public class RotasAluno implements ActionListener {

    private JButton btnOpcao;
    private JTextField txtNome;
    private JComboBox combobox = new JComboBox();

    AlunoController alunoCon = new AlunoController();

//    construtor para voltar para tela principal de gerenciar alunos
    public RotasAluno(JButton btnAcao, JFrame frame){
        this.btnOpcao = btnAcao;

        frame.dispose();
    }

    //    construtor para adicionar aluno
    public RotasAluno(JButton opcao, JFrame frame, JTextField txtNome){
        this.btnOpcao = opcao;
        this.txtNome = txtNome;

        frame.dispose();
    }

    //    construtor para editar aluno
    public RotasAluno(JButton opcao, JFrame frame, JTextField txtNome, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;
        this.txtNome = txtNome;

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
                new ViewAdicionarAluno();
                break;
            case "adicionarAluno":
                try {
                    if (txtNome.getText().length() > 0) {
                        alunoCon.adicionarAluno(txtNome.getText());
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
                if (txtNome.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idAlunoSelecionado = null;

                        for (int i = 0; i < alunoCon.listarAlunos().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idAlunoSelecionado = alunoCon.listarAlunos().get(i).getId();
                            }
                        }

                        alunoCon.editarAluno(idAlunoSelecionado, txtNome.getText());
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
