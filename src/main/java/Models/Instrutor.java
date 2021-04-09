package Models;

public class Instrutor {

    private Integer idinstrutor;
    private String nomeinstrutor;

    //construtor
    public Instrutor(){}

    public Instrutor(String nomeinstrutor){
        this.nomeinstrutor = nomeinstrutor;
    }

    public Instrutor(Integer idinstrutor, String nomeinstrutor){
        this.idinstrutor = idinstrutor;
        this.nomeinstrutor = nomeinstrutor;
    }

    public Integer getId() {
        return idinstrutor;
    }

    public void setId(Integer idinstrutor) {
        this.idinstrutor = idinstrutor;
    }

    public String getNome() {
        return nomeinstrutor;
    }

    public void setName(String nomeinstrutor) {
        this.nomeinstrutor = nomeinstrutor;
    }
}
