package Modules.Controllers;

import Models.Treino;
import ModelsDAO.TreinoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class TreinoController {

    //aqui vou criar o meu ModelsDAO.TreinoController
    TreinoDAO dao = new TreinoDAO();

    public Treino buscarTreinoPorID(Treino treino, Integer id) throws SQLException {
        treino = dao.findById(id);
        return treino;
    }

    public void listarTreinosComTabela(DefaultTableModel modelo) throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Treino> data = (ArrayList<Treino>) dao.findAll();

        modelo.setNumRows(0);

        for (Treino a : dao.findAll()) {
            modelo.addRow(new Object[]{a.getId(), a.getNome()});
        }
    }

    public ArrayList<Treino> listarTreinos() throws SQLException {
        //tem que fazer um cast indicando que vou utilizar de fato uma lista
        ArrayList<Treino> listaTreinos = (ArrayList<Treino>) dao.findAll();

        return listaTreinos;
    }

    public void adicionarTreino(String nome) throws SQLException {
        //aqui faço a inserção
        dao.insert(new Treino(nome));
        JOptionPane.showMessageDialog(null, "Treino adicionado com sucesso");
//        System.out.println("Treino adicionado com sucesso");
    }

    public void editarTreino(Integer idTreinoAntigo, String novoNomeTreino) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */

        Treino novoTreino = new Treino(idTreinoAntigo, novoNomeTreino); //criei a instância do objeto passando o nome que o usuário acabou de inserir
        dao.update(idTreinoAntigo, novoTreino);
        System.out.println("Treino alterado com sucesso");
    }

    public void removerTreino(Integer idTreinoExisteDelete) throws SQLException {
        /* o meu dao.update espera dois argumentos, o primeiro é o antigo dado(clienteExists)
         * e o segundo é o novo dado (uma instância nova)
         */
        dao.remove(idTreinoExisteDelete);
    }

    public Integer formatarIndiceTreino(JComboBox combotreino) throws SQLException {

        Integer indiceComboboxSelecionado = combotreino.getSelectedIndex();
        Integer idTreinoSelecionado = null;
        TreinoController treinoCon = new TreinoController();

        for (int i = 0; i < treinoCon.listarTreinos().size(); i++) {

            if (indiceComboboxSelecionado == i) {
                idTreinoSelecionado = treinoCon.listarTreinos().get(i).getId();
            }
        }

        return idTreinoSelecionado;
    }

}