package Modules.Controllers;

import Models.Aluno;
import ModelsDAO.AlunoDAO;

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

    public void listarAlunos(DefaultTableModel modelo) throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Aluno> data = (ArrayList<Aluno>) dao.findAll();

        modelo.setNumRows(0);

        for (Aluno a : dao.findAll()) {
            modelo.addRow(new Object[]{a.getId(), a.getNome()});
        }
    }

    public void adicionarAluno(String nome) throws SQLException {
        //aqui faço a inserção
        dao.insert(new Aluno(nome));
        System.out.println("Aluno adicionado com sucesso");
    }

    public void editarAluno(Aluno alunoAntigo, String novoNomeAluno) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */

        Aluno novoAluno = new Aluno(alunoAntigo.getId(), novoNomeAluno); //criei a instância do objeto passando o nome que o usuário acabou de inserir
        dao.update(alunoAntigo, novoAluno);
        System.out.println("Aluno alterado com sucesso");
    }

    public void removerAluno(Aluno alunoExisteDelete) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */
        dao.remove(alunoExisteDelete);
    }



}
