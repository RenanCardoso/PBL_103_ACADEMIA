package Modules.Controllers;

import Models.Plano;
import ModelsDAO.PlanoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlanoController {

    //aqui vou criar o meu ModelsDAO.PlanoController
    PlanoDAO dao = new PlanoDAO();

    public Plano buscarPlanoPorID(Plano treino, Integer id) throws SQLException {
        treino = dao.findById(id);
        return treino;
    }

    public void listarPlanosComTabela(DefaultTableModel modelo) throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Plano> data = (ArrayList<Plano>) dao.findAll();

        modelo.setNumRows(0);

        for (Plano a : dao.findAll()) {
            modelo.addRow(new Object[]{a.getId(), a.getNome()});
        }
    }

    public ArrayList<Plano> listarPlanos() throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Plano> listaPlanos = (ArrayList<Plano>) dao.findAll();

        return listaPlanos;
    }

    public void adicionarPlano(String nome) throws SQLException {
        //aqui faço a inserção
        dao.insert(new Plano(nome));
        JOptionPane.showMessageDialog(null, "Plano adicionado com sucesso");
//        System.out.println("Plano adicionado com sucesso");
    }

    public void editarPlano(Integer idTreinoAntigo, String novoNomePlano) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */

        Plano novoPlano = new Plano(idTreinoAntigo, novoNomePlano); //criei a instância do objeto passando o nome que o usuário acabou de inserir
        dao.update(idTreinoAntigo, novoPlano);
        System.out.println("Plano alterado com sucesso");
    }

    public void removerPlano(Integer treinoExisteDelete) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */
        dao.remove(treinoExisteDelete);
    }



}