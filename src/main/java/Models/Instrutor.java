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

    public Instrutor(String nome, String cpf, String rg, Integer idade, String numcelular, String numcelularopc, String status, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.idade = idade;
        this.email = email;
        this.numcelular = numcelular;
        this.numcelularopc = numcelularopc;
        this.status = status;
    }

    public Instrutor(Integer id, String nome, String cpf, String rg, Integer idade, String numcelular, String numcelularopc, String status, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.idade = idade;
        this.email = email;
        this.numcelular = numcelular;
        this.numcelularopc = numcelularopc;
        this.status = status;
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

    public String getCpf() {
        return cpf;
    }
    public String getRg() {
        return rg;
    }
    public Integer getIdade() {
        return idade;
    }
    public String getNumPrincipal() {
        return numcelular;
    }
    public String getNumSecundario() {
        return numcelularopc;
    }
    public String getStatus() {
        return status;
    }
    public String getEmail() { return email; }
}
