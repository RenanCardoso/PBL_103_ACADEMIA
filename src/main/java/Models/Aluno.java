package Models;

public class Aluno extends Pessoa {

    /* uma model é basicamente o espelho do nosso banco de dados. Basicamente cada instância que eu
     * criar da minha Models.Aluno vai ser um novo registro que vou gerar dentro do meu banco de dados na tabela movie
     */

    //construtor
    public Aluno(){}

    public Aluno(String nome){
        this.nome = nome;
    }

    public Aluno(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
