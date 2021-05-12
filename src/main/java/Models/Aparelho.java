package Models;

public class Aparelho {

    private Integer idaparelho;
    private String nomeaparelho;
    private String categoria;
    private String descricao;
    private Integer colunadepesokg;
    private String composicao;
    private Integer pesodoaparelho;
    private Integer pesosuportado;
    private String alturadoaparelho;
    private String larguradoaparelho;
    private String comprimentoaparelho;
    private String cor;
    private String obsaparelho;
    private String status;

    public Aparelho(){}

    public Aparelho(Integer idaparelho) {
        this.idaparelho = idaparelho;
    }

    public Aparelho(String nomeaparelho) {
        this.nomeaparelho = nomeaparelho;
    }

    public Aparelho(Integer idaparelho, String nomeaparelho) {
        this.idaparelho = idaparelho;
        this.nomeaparelho = nomeaparelho;
    }

//    construtor usado para adicionar
    public Aparelho(Integer idaparelho, String nomeaparelho, String categoria, String descricao, Integer colunadepesokg, String composicao, Integer pesodoaparelho, Integer pesosuportado, String alturadoaparelho, String larguradoaparelho, String comprimentoaparelho, String cor, String obsaparelho, String status) {
        this.idaparelho = idaparelho;
        this.nomeaparelho = nomeaparelho;
        this.categoria = categoria;
        this.descricao = descricao;
        this.colunadepesokg = colunadepesokg;
        this.composicao = composicao;
        this.pesodoaparelho = pesodoaparelho;
        this.pesosuportado = pesosuportado;
        this.alturadoaparelho = alturadoaparelho;
        this.larguradoaparelho = larguradoaparelho;
        this.comprimentoaparelho = comprimentoaparelho;
        this.cor = cor;
        this.obsaparelho = obsaparelho;
        this.status = status;
    }

    //    construtor usado para editar
    public Aparelho(String nomeaparelho, String categoria, String descricao, Integer colunadepesokg, String composicao, Integer pesodoaparelho, Integer pesosuportado, String alturadoaparelho, String larguradoaparelho, String comprimentoaparelho, String cor, String obsaparelho, String status) {
        this.idaparelho = idaparelho;
        this.nomeaparelho = nomeaparelho;
        this.categoria = categoria;
        this.descricao = descricao;
        this.colunadepesokg = colunadepesokg;
        this.composicao = composicao;
        this.pesodoaparelho = pesodoaparelho;
        this.pesosuportado = pesosuportado;
        this.alturadoaparelho = alturadoaparelho;
        this.larguradoaparelho = larguradoaparelho;
        this.comprimentoaparelho = comprimentoaparelho;
        this.cor = cor;
        this.obsaparelho = obsaparelho;
        this.status = status;
    }

    public Integer getIdaparelho() {
        return idaparelho;
    }

    public String getNomeaparelho() {
        return nomeaparelho;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getColunadepesokg() {
        return colunadepesokg;
    }

    public String getComposicao() {
        return composicao;
    }

    public Integer getPesodoaparelho() {
        return pesodoaparelho;
    }

    public Integer getPesosuportado() {
        return pesosuportado;
    }

    public String getAlturadoaparelho() {
        return alturadoaparelho;
    }

    public String getLarguradoaparelho() {
        return larguradoaparelho;
    }

    public String getComprimentoaparelho() {
        return comprimentoaparelho;
    }

    public String getCor() {
        return cor;
    }

    public String getObsaparelho() {
        return obsaparelho;
    }

    public String getStatus() {
        return status;
    }

    public void setIdaparelho(Integer idaparelho) {
        this.idaparelho = idaparelho;
    }

    public void setNomeaparelho(String nomeaparelho) {
        this.nomeaparelho = nomeaparelho;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setColunadepesokg(Integer colunadepesokg) {
        this.colunadepesokg = colunadepesokg;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public void setPesodoaparelho(Integer pesodoaparelho) {
        this.pesodoaparelho = pesodoaparelho;
    }

    public void setPesosuportado(Integer pesosuportado) {
        this.pesosuportado = pesosuportado;
    }

    public void setAlturadoaparelho(String alturadoaparelho) {
        this.alturadoaparelho = alturadoaparelho;
    }

    public void setLarguradoaparelho(String larguradoaparelho) {
        this.larguradoaparelho = larguradoaparelho;
    }

    public void setComprimentoaparelho(String comprimentoaparelho) {
        this.comprimentoaparelho = comprimentoaparelho;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setObsaparelho(String obsaparelho) {
        this.obsaparelho = obsaparelho;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return idaparelho;
    }

    public void setId(Integer idaparelho) {
        this.idaparelho = idaparelho;
    }

    public String getNome() {
        return nomeaparelho;
    }

    public void setNome(String nomeaparelho) {
        this.nomeaparelho = nomeaparelho;
    }


}
