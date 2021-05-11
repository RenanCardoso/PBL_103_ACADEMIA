import Views.MenuPrincipalView;
import ModelsDAO.DAO;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        abro a conexão com o banco
        new DAO();
//        chamo a tela principal
        new MenuPrincipalView();
    }
}
