import Views.MenuPrincipalView;
import ModelsDAO.DAO;

public class Main {
    public static void main(String[] args) {
//        abro a conexão com o banco
        new DAO();
//        chamo a tela principal
        new MenuPrincipalView();
    }
}
