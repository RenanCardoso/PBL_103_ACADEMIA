package ModelsDAO;

import Database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAO {

    //a primeira coisa a fazer é criar o atributo connection
    protected Connection connection = ConnectionFactory.instancia().getConnection();
    protected PreparedStatement statement;

    public DAO(){
    }

    public Connection getCon(){
        return connection;
    }

    public PreparedStatement getState(){
        return statement;
    }
}
