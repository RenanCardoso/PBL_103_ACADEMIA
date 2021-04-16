package Models;

public class Instrutor extends Pessoa {

    //construtor
    public Instrutor(){}

    public Instrutor(String nomeinstrutor){
        this.nome = nomeinstrutor;
    }

    public Instrutor(Integer idinstrutor, String nomeinstrutor){
        this.id = idinstrutor;
        this.nome = nomeinstrutor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idinstrutor) {
        this.id = idinstrutor;
    }

    public String getNome() {
        return nome;
    }

    public void setName(String nomeinstrutor) {
        this.nome = nomeinstrutor;
    }
}
