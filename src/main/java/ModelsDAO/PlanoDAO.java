package ModelsDAO;

import Database.ConnectionFactory;
import Models.Plano;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanoDAO {

    private Connection connection = null;
    private PreparedStatement statement = null;

    public PlanoDAO(){
        connection = new ConnectionFactory().getConnection();
    }

    public List<Plano> findAll() throws SQLException {

        String query = "SELECT * FROM plano";
        List<Plano> planos = new ArrayList<Plano>();
        statement = connection.prepareStatement(query);
        try (ResultSet res = statement.executeQuery()) {
            while (res.next()) {
                planos.add(new Plano(res.getInt("idplano"), res.getString("nomeplano")));
            }
        }

        return planos;
    }

    public Plano findById(Integer id) throws SQLException {
        //crio a minha query selecionando tudo da tabela plano filtrando apenas por um id
        String query = "SELECT * FROM plano WHERE idplano = ?";

        statement = connection.prepareStatement(query);

        //aqui vou setar o meu valor
        statement.setInt(1, id);

        //logo depois eu faço o meu ResultSet
        ResultSet res = statement.executeQuery();

        //meu Models.Plano será criado para ser devolvido então crio uma instância nula
        Plano plano = null;
        while (res.next()){
            //atribuo uma nova instância aqui dentro onde vou passar o meu id e o name do plano
            plano = new Plano(res.getInt("idplano"), res.getString("nomeplano"));
        }

        return plano;
    }

    public void insert(Plano plano) throws SQLException {
        String query = "INSERT INTO plano (nomeplano) VALUES (?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, plano.getNome()); //capturo através do meu getName
        statement.execute();
    }

    public void update(Integer idPlanoOld, Plano planoNew) throws SQLException {
        String query = "UPDATE plano SET nomeplano = ? WHERE idplano = ?";
        statement = connection.prepareStatement(query);

        //seto meus valores
        statement.setString(1, planoNew.getNome());
        statement.setInt(2, idPlanoOld);
        statement.execute();
    }

    // a parte de deletar eu vou receber o que de fato eu desejo deletar
    public void remove(Integer plano) throws SQLException {
        String query = "DELETE FROM plano WHERE idplano = ?"; //para remover em tempo de execução usa interrogação

        statement = connection.prepareStatement(query);

        //logo depois seto o meu valor dinâmico
        statement.setInt(1, plano); //se usa o setInt já que estou trabalhando com o meu id (interrogação) e eu sei que é inteiro
        //quero trabalhar com índice 1 por que só tenho uma opção

        //finalizando
        statement.execute();
    }
}