package Modules.Routes;

import Modules.Controllers.AlunoController;
import Modules.Controllers.InstrutorController;
import Modules.Controllers.PlanoController;
import Modules.Controllers.TreinoController;
import Modules.FormatterFields.FormatterField;
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
    private JComboBox comboaluno = new JComboBox();
    private JComboBox comboinstrutor = new JComboBox();
    private JComboBox comboplano = new JComboBox();
    private JComboBox combofichatreino = new JComboBox();
    private JComboBox combostatus= new JComboBox();
    private static JTextField txtaltura;
    private static JTextField txtpeso;
    private JButton btnOpcao;

    private static String cpfFormatado;
    private static String numPrincipalFormatado;
    private static String numSecundarioFormatado;
    private static String statusFormatado;

    AlunoController alunoCon = new AlunoController();
    InstrutorController instrutorCon = new InstrutorController();
    PlanoController planoCon = new PlanoController();
    TreinoController treinoCon = new TreinoController();

    //    construtor para voltar para tela principal de gerenciar alunos
    public RotasAluno(JButton btnAcao, JFrame frame){
        this.btnOpcao = btnAcao;

        frame.dispose();
    }

    //    construtor para adicionar aluno com todos os campos
    public RotasAluno(JButton btnSalvar, JFrame frame, JTextField nome, JTextField cpf, JTextField rg, JTextField idade, JTextField numPrincipal, JTextField numSecundario, JComboBox status, JComboBox plano, JComboBox instrutor, JComboBox fichaTreino, JTextField email, JTextField altura, JTextField peso) {
        this.btnOpcao = btnSalvar;
        this.comboinstrutor = instrutor;
        this.comboplano = plano;
        this.combofichatreino = fichaTreino;
        this.txtnome = nome;
        this.txtemail = email;
        this.txtcpf = cpf;
        this.txtrg = rg;
        this.txtidade = idade;
        this.txtaltura = altura;
        this.txtpeso = peso;
        this.txtnumPrincipal = numPrincipal;
        this.txtnumSecundario = numSecundario;
        this.combostatus = status;
        frame.dispose();
    }

    //    construtor para editar aluno
    public RotasAluno(JButton btnSalvar, JComboBox aluno, JFrame frame, JTextField nome, JTextField cpf, JTextField rg, JTextField idade, JTextField numPrincipal, JTextField numSecundario, JComboBox status, JComboBox plano, JComboBox instrutor, JComboBox fichaTreino, JTextField email, JTextField altura, JTextField peso) {

        this.btnOpcao = btnSalvar;
        this.comboaluno = aluno;
        this.comboinstrutor = instrutor;
        this.comboplano = plano;
        this.combofichatreino = fichaTreino;
        this.txtnome = nome;
        this.txtemail = email;
        this.txtcpf = cpf;
        this.txtrg = rg;
        this.txtidade = idade;
        this.txtaltura = altura;
        this.txtpeso = peso;
        this.txtnumPrincipal = numPrincipal;
        this.txtnumSecundario = numSecundario;
        this.combostatus = status;

        frame.dispose();
    }

    //    construtor para alterar e remover aluno
    public RotasAluno(JButton opcao, JFrame frame, JComboBox comboaluno){
        this.btnOpcao = opcao;
        this.comboaluno = comboaluno;

        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String btnOpcao = this.btnOpcao.getActionCommand();
        FormatterField formatar = new FormatterField();

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
                } catch (ParseException | SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "adicionarAluno":
                try {

                    int idade = Integer.parseInt(txtidade.getText());
                    cpfFormatado = formatar.formatarCPF(txtcpf);
                    numPrincipalFormatado = formatar.formatarCelular(txtnumPrincipal);
                    numSecundarioFormatado = formatar.formatarCelular(txtnumPrincipal);
                    statusFormatado = combostatus.getSelectedItem().toString();
                    Integer idPlanoSelecionado = planoCon.formatarIndicePlano(comboplano);
                    Integer idInstrutorSelecionado = instrutorCon.formatarIndiceInstrutor(comboinstrutor);
                    Integer idTreinoSelecionado = treinoCon.formatarIndiceTreino(combofichatreino);

                    if (statusFormatado == "Ativo"){
                        statusFormatado = "ati";
                    } else {
                        statusFormatado = "ina";
                    }

                    alunoCon.adicionarAluno(txtnome.getText(), cpfFormatado, txtrg.getText(), idade, numPrincipalFormatado, numSecundarioFormatado, statusFormatado, idPlanoSelecionado, idInstrutorSelecionado, idTreinoSelecionado, txtemail.getText(), txtaltura.getText(), txtpeso.getText());
                    JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso");
                    new ViewAluno();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "verTelaAlterarAlunos":
                try {
                    new ViewAlterarAluno(comboaluno.getSelectedIndex());
                } catch (SQLException | ParseException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "alterarAluno":
                try {
                    int idade = Integer.parseInt(txtidade.getText());
                    cpfFormatado = formatar.formatarCPF(txtcpf);
                    numPrincipalFormatado = formatar.formatarCelular(txtnumPrincipal);
                    numSecundarioFormatado = formatar.formatarCelular(txtnumPrincipal);
                    statusFormatado = combostatus.getSelectedItem().toString();
                    Integer idPlanoSelecionado = planoCon.formatarIndicePlano(comboplano);
                    Integer idInstrutorSelecionado = instrutorCon.formatarIndiceInstrutor(comboinstrutor);
                    Integer idTreinoSelecionado = treinoCon.formatarIndiceTreino(combofichatreino);

                    if (statusFormatado == "Ativo"){
                        statusFormatado = "ati";
                    } else {
                        statusFormatado = "ina";
                    }

                    alunoCon.editarAluno(alunoCon.listarAlunos().get(comboaluno.getSelectedIndex()).getId(), txtnome.getText(), cpfFormatado, txtrg.getText(), idade, numPrincipalFormatado, numSecundarioFormatado, idPlanoSelecionado, idInstrutorSelecionado, idTreinoSelecionado, txtemail.getText(), txtaltura.getText(), txtpeso.getText(), statusFormatado);

                    JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso");
                    new ViewAluno();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
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
                            Integer indiceComboboxSelecionado = this.comboaluno.getSelectedIndex();
                            Integer idAlunoSelecionado = null;

                            for (int i = 0; i < alunoCon.listarAlunos().size(); i++) {
                                if (indiceComboboxSelecionado == i) {
                                    idAlunoSelecionado = alunoCon.listarAlunos().get(i).getId();
                                }
                            }

                            String nomeTemp = this.comboaluno.getSelectedItem().toString();
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
