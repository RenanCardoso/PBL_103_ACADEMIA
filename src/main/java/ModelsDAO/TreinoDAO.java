package ModelsDAO;

import Database.ConnectionFactory;
import Models.Treino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreinoDAO {

    private Connection connection = null;
    private PreparedStatement statement = null;

    public TreinoDAO(){
        connection = new ConnectionFactory().getConnection();
    }

    public List<Treino> findAll() throws SQLException {

        String query = "SELECT * FROM treino";
        List<Treino> treinos = new ArrayList<Treino>();
        statement = connection.prepareStatement(query);
        try (ResultSet res = statement.executeQuery()) {
            while (res.next()) {
                treinos.add(new Treino(res.getInt("idtreino"), res.getString("nometreino")));
            }
        }

        return treinos;
    }

    public Treino findById(Integer id) throws SQLException {
        //crio a minha query selecionando tudo da tabela treino filtrando apenas por um id
        String query = "SELECT * FROM treino WHERE idtreino = ?";

        statement = connection.prepareStatement(query);

        //aqui vou setar o meu valor
        statement.setInt(1, id);

        //logo depois eu faço o meu ResultSet
        ResultSet res = statement.executeQuery();

        //meu Models.Treino será criado para ser devolvido então crio uma instância nula
        Treino treino = null;
        while (res.next()){
            //atribuo uma nova instância aqui dentro onde vou passar o meu id e o name do treino
            treino = new Treino(res.getInt("idtreino"), res.getString("nometreino"));
        }

        return treino;
    }

    public void insert(Treino treino) throws SQLException {
        String query = "INSERT INTO treino (nometreino) VALUES (?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, treino.getNome()); //capturo através do meu getName
        statement.execute();
    }

    public void update(Integer idTreinoOld, Treino treinoNew) throws SQLException {
        String query = "UPDATE treino SET nometreino = ? WHERE idtreino = ?";
        statement = connection.prepareStatement(query);

        //seto meus valores
        statement.setString(1, treinoNew.getNome());
        statement.setInt(2, idTreinoOld);
        statement.execute();
    }

    // a parte de deletar eu vou receber o que de fato eu desejo deletar
    public void remove(Integer idTreino) throws SQLException {
        String query = "DELETE FROM treino WHERE idtreino = ?"; //para remover em tempo de execução usa interrogação

        statement = connection.prepareStatement(query);

        //logo depois seto o meu valor dinâmico
        statement.setInt(1, idTreino); //se usa o setInt já que estou trabalhando com o meu id (interrogação) e eu sei que é inteiro
        //quero trabalhar com índice 1 por que só tenho uma opção

        //finalizando
        statement.execute();
    }
}