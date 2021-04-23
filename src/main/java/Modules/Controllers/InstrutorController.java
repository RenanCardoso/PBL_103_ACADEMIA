package Modules.Controllers;

import Models.Instrutor;
import ModelsDAO.InstrutorDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstrutorController {

    //aqui vou criar o meu ModelsDAO.InstrutorDAO
    InstrutorDAO dao = new InstrutorDAO();

    public Instrutor buscarInstrutorPorID(Instrutor instrutor, Integer id) throws SQLException {
        instrutor = dao.findById(id);
        return instrutor;
    }

    public void listarInstrutoresComTabela(DefaultTableModel modelo) throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Instrutor> data = (ArrayList<Instrutor>) dao.findAll();

        modelo.setNumRows(0);

        for (Instrutor a : dao.findAll()) {
            modelo.addRow(new Object[]{a.getId(), a.getNome()});
        }
    }

    public ArrayList<Instrutor> listarInstrutores() throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Instrutor> listaInstrutores = (ArrayList<Instrutor>) dao.findAll();

        return listaInstrutores;
    }

    public void adicionarInstrutor(String nome) throws SQLException {
        //aqui faço a inserção
        dao.insert(new Instrutor(nome));
        JOptionPane.showMessageDialog(null, "Instrutor adicionado com sucesso");
//        System.out.println("Instrutor adicionado com sucesso");
    }

    public void editarInstrutor(Integer idInstrutorAntigo, String novoNomeInstrutor) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */

        Instrutor novoInstrutor = new Instrutor(idInstrutorAntigo, novoNomeInstrutor); //criei a instância do objeto passando o nome que o usuário acabou de inserir
        dao.update(idInstrutorAntigo, novoInstrutor);
        System.out.println("Instrutor alterado com sucesso");
    }

    public void removerInstrutor(Integer instrutorExisteDelete) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */
        dao.remove(instrutorExisteDelete);
    }



}
