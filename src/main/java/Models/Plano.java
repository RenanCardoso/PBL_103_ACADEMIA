package Models;

public class Plano {

    private Integer idplano;
    private String nomeplano;
    private String duracao;
    private Float preco;
    private Integer limitepessoas;
    private String flpromocao;
    private Integer desconto;


    public Plano(){}

    public Plano(Integer idplano) {
        this.idplano = idplano;
    }

    public Plano(String nomeplano) {
        this.nomeplano = nomeplano;
    }

    public Plano(Integer idplano, String nomeplano) {
        this.idplano = idplano;
        this.nomeplano = nomeplano;
    }

    public Plano(String nomeplano, String duracao, Float preco, Integer limitepessoas, String flpromocao, Integer desconto) {
        this.nomeplano = nomeplano;
        this.duracao = duracao;
        this.preco = preco;
        this.limitepessoas = limitepessoas;
        this.flpromocao = flpromocao;
        this.desconto = desconto;
    }

    public Plano(Integer idplano, String nomeplano, String duracao, Float preco, Integer limitepessoas, String flpromocao, Integer desconto) {
        this.idplano = idplano;
        this.nomeplano = nomeplano;
        this.duracao = duracao;
        this.preco = preco;
        this.limitepessoas = limitepessoas;
        this.flpromocao = flpromocao;
        this.desconto = desconto;
    }

    public Integer getId() {
        return idplano;
    }

    public void setId(Integer idplano) {
        this.idplano = idplano;
    }

    public String getNome() {
        return nomeplano;
    }

    public void setNome(String nomeplano) {
        this.nomeplano = nomeplano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getLimitepessoas() {
        return limitepessoas;
    }

    public void setLimitepessoas(Integer limitepessoas) {
        this.limitepessoas = limitepessoas;
    }

    public String getFlpromocao() {
        return flpromocao;
    }

    public void setFlpromocao(String flpromocao) {
        this.flpromocao = flpromocao;
    }

    public Integer getDesconto() {
        return desconto;
    }

    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }
}
