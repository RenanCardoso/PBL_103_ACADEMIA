package Modules.Controllers;

import Views.Aluno.ViewAdicionarAluno;
import Views.Aluno.ViewAlterarAluno;
import Views.Aluno.ViewRemoverAluno;
import Views.Aparelho.ViewAdicionarAparelho;
import Views.Aparelho.ViewAlterarAparelho;
import Views.Aparelho.ViewAparelho;
import Views.Aparelho.ViewRemoverAparelho;
import Views.Instrutor.ViewAdicionarInstrutor;
import Views.Instrutor.ViewAlterarInstrutor;
import Views.Instrutor.ViewInstrutores;
import Views.Instrutor.ViewRemoverInstrutor;
import Views.MenuPrincipalView;
import Views.Aluno.ViewAluno;
import Views.Plano.ViewAdicionarPlano;
import Views.Plano.ViewAlterarPlano;
import Views.Plano.ViewPlano;
import Views.Plano.ViewRemoverPlano;
import Views.Treino.ViewAdicionarTreino;
import Views.Treino.ViewAlterarTreino;
import Views.Treino.ViewRemoverTreino;
import Views.Treino.ViewTreino;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Routes implements ActionListener {

    private JButton btnOpcao;
    private JTextField txt1 = new JTextField(30);
    private JComboBox combobox = new JComboBox();
    AlunoController alunoCon = new AlunoController();
    InstrutorController instrutorCon = new InstrutorController();
    AparelhoController aparelhoCon = new AparelhoController();
    TreinoController treinoCon = new TreinoController();
    PlanoController planoCon = new PlanoController();

    public Routes(JButton opcao, JFrame frame){
        this.btnOpcao = opcao;
        frame.dispose();
    }
    public Routes(JButton opcao, JFrame frame, JTextField txt1){
        this.btnOpcao = opcao;
        this.txt1 = txt1;

        frame.dispose();
    }
    public Routes(JButton opcao, JFrame frame, JTextField txt1, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;
        this.txt1 = txt1;

        frame.dispose();
    }
    public Routes(JButton opcao, JFrame frame, JComboBox combobox){
        this.btnOpcao = opcao;
        this.combobox = combobox;

        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String btnOpcao = this.btnOpcao.getActionCommand();

        switch (btnOpcao){
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
                    if (txt1.getText().length() > 0){
                        alunoCon.adicionarAluno(txt1.getText());
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
                if (txt1.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idAlunoSelecionado = null;

                        for (int i = 0; i < alunoCon.listarAlunos().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idAlunoSelecionado = alunoCon.listarAlunos().get(i).getId();
                            }
                        }

                        alunoCon.editarAluno(idAlunoSelecionado, txt1.getText());
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
                    if (txt1.getText().length() > 0){
                        try {
                            instrutorCon.adicionarInstrutor(txt1.getText());
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
                if (txt1.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idAlunoSelecionado = null;

                        for (int i = 0; i < instrutorCon.listarInstrutores().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idAlunoSelecionado = instrutorCon.listarInstrutores().get(i).getId();
                            }
                        }

                        instrutorCon.editarInstrutor(idAlunoSelecionado, txt1.getText());
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

                            for (int i = 0; i < alunoCon.listarAlunos().size(); i++) {
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
                if (txt1.getText().length() > 0){
                    try {
                        treinoCon.adicionarTreino(txt1.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        JOptionPane.showMessageDialog(null, "Treino adicionado com sucesso");
                        new ViewInstrutores();
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
                if (txt1.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idTreinoSelecionado = null;

                        for (int i = 0; i < treinoCon.listarTreinos().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idTreinoSelecionado = treinoCon.listarTreinos().get(i).getId();
                            }
                        }

                        treinoCon.editarTreino(idTreinoSelecionado, txt1.getText());
                        JOptionPane.showMessageDialog(null, "Treino alterado com sucesso");

                        new ViewInstrutores();
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
                            new ViewRemoverTreino();
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
                if (txt1.getText().length() > 0){
                    try {
                        planoCon.adicionarPlano(txt1.getText());
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
                if (txt1.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idPlanoSelecionado = null;

                        for (int i = 0; i < planoCon.listarPlanos().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idPlanoSelecionado = planoCon.listarPlanos().get(i).getId();
                            }
                        }

                        planoCon.editarPlano(idPlanoSelecionado, txt1.getText());
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
                if (txt1.getText().length() > 0){
                    try {
                        aparelhoCon.adicionarAparelho(txt1.getText());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        JOptionPane.showMessageDialog(null, "Aparelho adicionado com sucesso");
                        new ViewInstrutores();
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
                if (txt1.getText().length() > 0) {
                    try {
                        Integer indiceComboboxSelecionado = this.combobox.getSelectedIndex();
                        Integer idAparelhoSelecionado = null;

                        for (int i = 0; i < aparelhoCon.listarAparelhos().size(); i++) {
                            if (indiceComboboxSelecionado == i) {
                                idAparelhoSelecionado = aparelhoCon.listarAparelhos().get(i).getId();
                            }
                        }

                        aparelhoCon.editarAparelho(idAparelhoSelecionado, txt1.getText());
                        JOptionPane.showMessageDialog(null, "Aparelho alterado com sucesso");

                        new ViewInstrutores();
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
