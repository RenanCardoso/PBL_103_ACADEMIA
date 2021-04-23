package Modules.Controllers;

import Models.Aparelho;
import ModelsDAO.AparelhoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class AparelhoController {

    //aqui vou criar o meu ModelsDAO.AparelhoDAO
    AparelhoDAO dao = new AparelhoDAO();

    public Aparelho buscarAparelhoporID(Aparelho aparelho, Integer id) throws SQLException {
        aparelho = dao.findById(id);
        return aparelho;
    }

    public void listarAparelhosComTabela(DefaultTableModel modelo) throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Aparelho> data = (ArrayList<Aparelho>) dao.findAll();

        modelo.setNumRows(0);

        for (Aparelho a : dao.findAll()) {
            modelo.addRow(new Object[]{a.getId(), a.getNome()});
        }
    }

    public ArrayList<Aparelho> listarAparelhos() throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Aparelho> listaAparelhos = (ArrayList<Aparelho>) dao.findAll();

        return listaAparelhos;
    }

    public void adicionarAparelho(String nome) throws SQLException {
        //aqui faço a inserção
        dao.insert(new Aparelho(nome));
        JOptionPane.showMessageDialog(null, "Aparelho adicionado com sucesso");
//        System.out.println("Aparelho adicionado com sucesso");
    }

    public void editarAparelho(Integer aparelhoAntigo, String novoNomeAparelho) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */

        Aparelho novoAparelho = new Aparelho(aparelhoAntigo, novoNomeAparelho); //criei a instância do objeto passando o nome que o usuário acabou de inserir
        dao.update(aparelhoAntigo, novoAparelho);
        System.out.println("Aparelho alterado com sucesso");
    }

    public void removerAparelho(Integer aparelhoExisteDelete) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */
        dao.remove(aparelhoExisteDelete);
    }



}