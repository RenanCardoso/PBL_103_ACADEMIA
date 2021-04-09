package Models;

public class Plano {

    private Integer idplano;
    private String nomeplano;

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

    public Integer getId() {
        return idplano;
    }

    public void setIdPlano(Integer idplano) {
        this.idplano = idplano;
    }

    public String getNome() {
        return nomeplano;
    }

    public void setNomePlano(String nomeplano) {
        this.nomeplano = nomeplano;
    }
}
