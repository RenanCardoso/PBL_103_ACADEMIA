package Modules.Controllers;

import Models.Aluno;
import ModelsDAO.AlunoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoController {

    //aqui vou criar o meu ModelsDAO.AlunoDAO
    AlunoDAO dao = new AlunoDAO();
    AlunoController alunoCon;

    public Aluno buscarAlunoporID(Aluno aluno, Integer id) throws SQLException {
        aluno = dao.findById(id);
        return aluno;
    }

    public void listarAlunosComTabela(DefaultTableModel modelo) throws SQLException {

        modelo.setNumRows(0);

        for (Aluno a : dao.findAll()) {
            modelo.addRow(new Object[]{a.getId(), a.getNome(), a.getCpf(), a.getRg(), a.getEmail(), a.getNumPrincipal(), a.getNumSecundario(), a.getIdade(), a.getAltura(), a.getPeso(), a.getInstrutorDoAluno(), a.getTreinoDoAluno(), a.getPlanoDoAluno(), a.getStatus()});
        }
    }

    public ArrayList<Aluno> listarAlunos() throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>) dao.findAll();

        return listaAlunos;
    }

    public void adicionarAluno(String nome, String cpf, String rg, Integer idade, String numcelular, String numcelularopc, String status, Integer idplano, Integer idinstrutor, Integer idtreino, String email, String altura, String peso) throws SQLException {
        //aqui faço a inserção
        dao.insert(new Aluno(nome, cpf, rg, idade, numcelular, numcelularopc, status, idplano, idinstrutor, idtreino, email, altura, peso));
        JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso");
//        System.out.println("Aluno adicionado com sucesso");
    }

    public void editarAluno(Integer idAlunoAntigo, String nome, String cpf, String rg, Integer idade, String numcelular, String numcelularopc, Integer idplano, Integer idinstrutor, Integer idtreino, String email, String altura, String peso, String status) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */

        Aluno novoAluno = new Aluno(idAlunoAntigo, nome, cpf, rg, idade, numcelular, numcelularopc, idplano, idinstrutor, idtreino, email, altura, peso, status); //criei a instância do objeto passando o nome que o usuário acabou de inserir
        dao.update(idAlunoAntigo, novoAluno);
        JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso");
//        System.out.println("Aluno alterado com sucesso");
    }

    public void removerAluno(Integer alunoExisteDelete) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */
        dao.remove(alunoExisteDelete);
    }

    public Integer formatarIndiceAluno(JComboBox combobox) throws SQLException {

        Integer indiceComboboxSelecionado = combobox.getSelectedIndex();
        Integer idAlunoSelecionado = null;

        for (int i = 0; i < alunoCon.listarAlunos().size(); i++) {
            if (indiceComboboxSelecionado == i) {
                idAlunoSelecionado = alunoCon.listarAlunos().get(i).getId();
            }
        }

        return idAlunoSelecionado;
    }

}
