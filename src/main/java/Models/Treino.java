package Models;

public class Treino {

    private Integer idtreino;
    private String nometreino;

    //construtor
    public Treino(){}

    public Treino(String nometreino){
        this.nometreino = nometreino;
    }

    public Treino(Integer idtreino, String nometreino){
        this.idtreino = idtreino;
        this.nometreino = nometreino;
    }

    public Integer getId() {
        return idtreino;
    }

    public void setId(Integer idtreino) {
        this.idtreino = idtreino;
    }

    public String getNome() {
        return nometreino;
    }

    public void setName(String nometreino) {
        this.nometreino = nometreino;
    }
}
