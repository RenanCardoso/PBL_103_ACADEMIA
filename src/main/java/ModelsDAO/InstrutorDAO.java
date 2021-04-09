package ModelsDAO;

import Database.ConnectionFactory;
import Models.Instrutor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrutorDAO {

    private Connection connection = null;
    private PreparedStatement statement = null;

    public InstrutorDAO(){
//        connection = new ConnectionFactory().getConnection();
    }

    public List<Instrutor> findAll() throws SQLException {

        String query = "SELECT * FROM instrutor";
        List<Instrutor> instrutores = new ArrayList<Instrutor>();
        statement = connection.prepareStatement(query);
        try (ResultSet res = statement.executeQuery()) {
            while (res.next()) {
                instrutores.add(new Instrutor(res.getInt("idinstrutor"), res.getString("nomeinstrutor")));
            }
        }

        return instrutores;
    }

    public Instrutor findById(Integer id) throws SQLException {
        //crio a minha query selecionando tudo da tabela instrutor filtrando apenas por um id
        String query = "SELECT * FROM instrutor WHERE idinstrutor = ?";

        statement = connection.prepareStatement(query);

        //aqui vou setar o meu valor
        statement.setInt(1, id);

        //logo depois eu faço o meu ResultSet
        ResultSet res = statement.executeQuery();

        //meu Models.Instrutor será criado para ser devolvido então crio uma instância nula
        Instrutor instrutor = null;
        while (res.next()){
            //atribuo uma nova instância aqui dentro onde vou passar o meu id e o name do instrutor
            instrutor = new Instrutor(res.getInt("idinstrutor"), res.getString("nomeinstrutor"));
        }

        return instrutor;
    }

    public void insert(Instrutor instrutor) throws SQLException {
        String query = "INSERT INTO instrutor (nomeinstrutor) VALUES (?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, instrutor.getNome()); //capturo através do meu getName
        statement.execute();
    }

    public void update(Integer idInstrutorOld, Instrutor instrutorNew) throws SQLException {
        String query = "UPDATE instrutor SET nomeinstrutor = ? WHERE idinstrutor = ?";
        statement = connection.prepareStatement(query);

        //seto meus valores
        statement.setString(1, instrutorNew.getNome());
        statement.setInt(2, idInstrutorOld);
        statement.execute();
    }

    // a parte de deletar eu vou receber o que de fato eu desejo deletar
    public void remove(Integer instrutor) throws SQLException {
        String query = "DELETE FROM instrutor WHERE idinstrutor = ?"; //para remover em tempo de execução usa interrogação

        statement = connection.prepareStatement(query);

        //logo depois seto o meu valor dinâmico
        statement.setInt(1, instrutor); //se usa o setInt já que estou trabalhando com o meu id (interrogação) e eu sei que é inteiro
        //quero trabalhar com índice 1 por que só tenho uma opção

        //finalizando
        statement.execute();
    }
}