package Views.Aparelho;

import Modules.Controllers.AparelhoController;
import Modules.Routes.RotasAparelho;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;

public class ViewAlterarAparelho {

    //    defino os componentes que serão utilizados
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnAcao;
    private static JButton btnSalvar;
    private static JButton btnVoltarMenuUsuarios;
    private static JLabel labelNome;
    private static JTextField nome;
    private static JLabel labelDescricao;
    private static JTextField descricao;
    private static JLabel labelCategoria;
    private static JComboBox categoria;
    private static JLabel labelColunaDePesoKG;
    private static JTextField colunaDePesoKG;
    private static JLabel labelComposicao;
    private static JTextField composicao;
    private static JLabel labelPesoDoAparelho;
    private static JTextField pesoDoAparelho;
    private static JLabel labelAlturaDoAparelho;
    private static JTextField alturaDoAparelho;
    private static JLabel labelPesoSuportado;
    private static JTextField pesoSuportado;
    private static JLabel labelLarguraDoAparelho;
    private static JTextField larguraDoAparelho;
    private static JLabel labelComprimentoDoAparelho;
    private static JTextField comprimentoDoAparelho;
    private static JLabel labelObsAparelho;
    private static JTextField obsAparelho;
    private static JLabel labelCor;
    private static JTextField cor;
    private static JLabel labelStatus;
    private static JComboBox status;
    private static JLabel labelComboAparelho;
    private static JComboBox comboaparelho;

    public ViewAlterarAparelho(Integer indiceAparelhoSelecionado) throws SQLException, ParseException {
        verTelaAlterarAparelho(indiceAparelhoSelecionado);
    }

    public static void verTelaAlterarAparelho(Integer indiceAparelhoSelecionado) throws SQLException, ParseException {

        //        crio o meu Jframe
        frame = new JFrame("Alterar Aparelho");
        frame.setBounds(100, 100, 1366, 768);
//        e coloco a operação de fechar padrão no botão x
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(0));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //abaixo eu crio os meus componentes
        btnSalvar = new JButton("Alterar");
        btnSalvar.setActionCommand("alterarAparelho");
        btnVoltarMenuUsuarios = new JButton("Voltar para o Menu de Gerenciar Aparelhos");
        btnVoltarMenuUsuarios.setActionCommand("verTelaAparelhos");
        btnAcao = new JButton("Voltar para o Menu Principal");
        btnAcao.setActionCommand("VoltarMenuPrincipal");

        labelNome = new JLabel("Nome do Aparelho");
        nome = new JTextField(30);

        labelCategoria = new JLabel("Categoria do Aparelho *");
        categoria = new JComboBox();
        categoria.addItem("Aparelho de Musculação"); //apmu
        categoria.addItem("Abdominal"); //abdo
        categoria.addItem("Anilhas"); //anil
        categoria.addItem("Acessórios"); //aces
        categoria.addItem("Aeróbico"); //aero
        categoria.addItem("Banco Supino"); //basu
        categoria.addItem("Barras"); //barr
        categoria.addItem("Esporte Lazer"); //esla
        categoria.addItem("Estação de Musculação"); //esmu
        categoria.addItem("Kits Barras e Anilhas"); //kban
        categoria.addItem("Peças de Reposição"); //pero
        categoria.addItem("Puxadores"); //puxa

        labelDescricao = new JLabel("Descrição do Aparelho: ");
        descricao = new JTextField(80);

        labelColunaDePesoKG = new JLabel("Coluna de peso(KG): ");
        colunaDePesoKG = new JFormattedTextField(new MaskFormatter("##"));
        colunaDePesoKG.setColumns(20);

        labelComposicao = new JLabel("Composição do Aparelho: ");
        composicao = new JTextField(80);

        labelPesoDoAparelho = new JLabel("Peso do Aparelho(KG): ");
        pesoDoAparelho = new JFormattedTextField(new MaskFormatter("##"));
        pesoDoAparelho.setColumns(20);

        labelAlturaDoAparelho = new JLabel("Altura do Aparelho: ");
        alturaDoAparelho = new JFormattedTextField(new MaskFormatter("#,##"));
        alturaDoAparelho.setColumns(20);

        labelLarguraDoAparelho = new JLabel("Largura do Aparelho: ");
        larguraDoAparelho = new JFormattedTextField(new MaskFormatter("#,##"));
        larguraDoAparelho.setColumns(20);

        labelComprimentoDoAparelho = new JLabel("Comprimento do Aparelho: ");
        comprimentoDoAparelho = new JFormattedTextField(new MaskFormatter("#,##"));
        comprimentoDoAparelho.setColumns(20);

        labelStatus = new JLabel("Status do Aparelho *");
        status = new JComboBox();
        status.addItem("Ativo");
        status.addItem("Inativo");

        labelPesoSuportado = new JLabel("Peso Suportado: ");
        pesoSuportado = new JFormattedTextField(new MaskFormatter("##"));
        pesoSuportado.setColumns(20);

        labelCor = new JLabel("Cor do Aparelho: ");
        cor = new JTextField(30);

        labelObsAparelho = new JLabel("Observação: ");
        obsAparelho = new JTextField(80);

        labelComboAparelho = new JLabel("Aluno:");
        comboaparelho = new JComboBox();
        AparelhoController aparelhoCon = new AparelhoController();

        if (indiceAparelhoSelecionado != null){
            comboaparelho.addItem(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getNome());
            nome.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getNome());
            categoria.addItem(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getCategoria());
            descricao.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getDescricao());
            colunaDePesoKG.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getColunadepesokg().toString());
            composicao.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getComposicao());
            pesoDoAparelho.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getPesodoaparelho().toString());
            alturaDoAparelho.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getAlturadoaparelho());
            larguraDoAparelho.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getLarguradoaparelho());
            comprimentoDoAparelho.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getComprimentoaparelho());
            status.addItem(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getStatus());
            pesoSuportado.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getPesosuportado().toString());
            cor.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getCor());
            obsAparelho.setText(aparelhoCon.listarAparelhos().get(indiceAparelhoSelecionado).getObsaparelho());
        }

        frame.add(panel);
        frame.add(labelComboAparelho);
        frame.add(comboaparelho);
        frame.add(labelNome);
        frame.add(nome);
        frame.add(labelDescricao);
        frame.add(descricao);
        frame.add(labelCategoria);
        frame.add(categoria);
        frame.add(labelColunaDePesoKG);
        frame.add(colunaDePesoKG);
        frame.add(labelComposicao);
        frame.add(composicao);
        frame.add(labelPesoDoAparelho);
        frame.add(pesoDoAparelho);
        frame.add(labelAlturaDoAparelho);
        frame.add(alturaDoAparelho);
        frame.add(labelLarguraDoAparelho);
        frame.add(larguraDoAparelho);
        frame.add(labelPesoSuportado);
        frame.add(pesoSuportado);
        frame.add(labelComprimentoDoAparelho);
        frame.add(comprimentoDoAparelho);
        frame.add(labelCor);
        frame.add(cor);
        frame.add(labelObsAparelho);
        frame.add(obsAparelho);
        frame.add(labelStatus);
        frame.add(status);
        frame.add(btnSalvar);
        frame.add(btnVoltarMenuUsuarios);
        frame.add(btnAcao);

//        aqui vou trabalhar com meus eventos
        btnSalvar.addActionListener(new RotasAparelho(btnSalvar, indiceAparelhoSelecionado, frame, nome, categoria, descricao, colunaDePesoKG, composicao, pesoDoAparelho, alturaDoAparelho, pesoSuportado, larguraDoAparelho, comprimentoDoAparelho, obsAparelho, cor, status)); //a partir daqui a Controller passará a assumir
//        btnSalvar.addActionListener(new RotasAparelho(btnSalvar, frame, nome, combobox)); //a partir daqui a Controller passará a assumir
        btnAcao.addActionListener(new RotasAparelho(btnAcao, frame)); //a partir daqui a Controller passará a assumir
        btnVoltarMenuUsuarios.addActionListener(new RotasAparelho(btnVoltarMenuUsuarios, frame)); //a partir daqui a Controller passará a assumir

        frame.setVisible(true);
    }
}
