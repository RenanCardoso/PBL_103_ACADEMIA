package Views;

import Modules.Routes.*;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView {

    //    defino os componentes que serão utilizados
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton btnAcaoAlunos;
    private JButton btnAcaoInstrutores;
    private JButton btnAcaoTreinos;
    private JButton btnAcaoAparelhos;
    private JButton btnAcaoPlanos;

    public MenuPrincipalView(){
        verMenuPrincipal();
    }

    private void verMenuPrincipal(){

//        crio o meu JFrame
        mainFrame = new JFrame("Sistema Academia");
        mainFrame.setBounds(100, 100, 750, 550);
//        e coloco a operação de fechar padrão no botão x
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(4,2));

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnAcaoTreinos = new JButton("Ver e Gerenciar Instrutores");
        btnAcaoTreinos.setActionCommand("verTelaInstrutores");
        btnAcaoInstrutores = new JButton("Ver e Gerenciar Treinos");
        btnAcaoInstrutores.setActionCommand("verTelaTreinos");
        btnAcaoAlunos = new JButton("Ver e Gerenciar Alunos");
        btnAcaoAlunos.setActionCommand("verTelaAlunos");
        btnAcaoAparelhos = new JButton("Ver e Gerenciar Aparelhos");
        btnAcaoAparelhos.setActionCommand("verTelaAparelhos");
        btnAcaoPlanos = new JButton("Ver e Gerenciar Planos");
        btnAcaoPlanos.setActionCommand("verTelaPlanos");

        mainFrame.add(mainPanel);
        mainFrame.add(btnAcaoInstrutores);
        mainFrame.add(btnAcaoTreinos);
        mainFrame.add(btnAcaoAlunos);
        mainFrame.add(btnAcaoAparelhos);
        mainFrame.add(btnAcaoPlanos);

//        aqui vou trabalhar com meus eventos
        btnAcaoAlunos.addActionListener(new RotasAluno(btnAcaoAlunos, mainFrame)); //a partir daqui a Controller passará a assumir
        btnAcaoInstrutores.addActionListener(new RotasInstrutor(btnAcaoInstrutores, mainFrame)); //a partir daqui a Controller passará a assumir
        btnAcaoTreinos.addActionListener(new RotasTreino(btnAcaoTreinos, mainFrame)); //a partir daqui a Controller passará a assumir
        btnAcaoAparelhos.addActionListener(new RotasAparelho(btnAcaoAparelhos, mainFrame)); //a partir daqui a Controller passará a assumir
        btnAcaoPlanos.addActionListener(new RotasPlano(btnAcaoPlanos, mainFrame)); //a partir daqui a Controller passará a assumir

        mainFrame.setVisible(true);
    }
}
