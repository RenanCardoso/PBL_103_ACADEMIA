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

    public Aluno buscarAlunoporID(Aluno aluno, Integer id) throws SQLException {
        aluno = dao.findById(id);
        return aluno;
    }

    public void listarAlunosComTabela(DefaultTableModel modelo) throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Aluno> data = (ArrayList<Aluno>) dao.findAll();

        modelo.setNumRows(0);

        for (Aluno a : dao.findAll()) {
            modelo.addRow(new Object[]{a.getId(), a.getNome()});
        }
    }

    public ArrayList<Aluno> listarAlunos() throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>) dao.findAll();

        return listaAlunos;
    }

    public void adicionarAluno(String nome) throws SQLException {
        //aqui faço a inserção
        dao.insert(new Aluno(nome));
        JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso");
//        System.out.println("Aluno adicionado com sucesso");
    }

    public void editarAluno(Integer idAlunoAntigo, String novoNomeAluno) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */

        Aluno novoAluno = new Aluno(idAlunoAntigo, novoNomeAluno); //criei a instância do objeto passando o nome que o usuário acabou de inserir
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

}
