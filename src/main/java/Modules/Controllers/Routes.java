package Modules.Controllers;

import Views.MenuPrincipalView;
import Views.ViewAluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Routes implements ActionListener {

    private JButton btnOpcao;

    public Routes(JButton opcao, JFrame frame){
        this.btnOpcao = opcao;
        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String btnOpcao = this.btnOpcao.getActionCommand();

        switch (btnOpcao){
            case "verTelaAlunos":
                try {
                    new ViewAluno();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "listarAlunos":
                new MenuPrincipalView();
                break;
            case "adicionarAluno":
                new MenuPrincipalView();
                break;
            case "alterarAluno":
                new MenuPrincipalView();
                break;
            case "removerAluno":
                new MenuPrincipalView();
                break;
            case "VoltarMenuPrincipal":
                new MenuPrincipalView();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
        }

    }

}
