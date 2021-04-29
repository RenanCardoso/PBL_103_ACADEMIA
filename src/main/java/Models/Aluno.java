package Models;

public class Aluno extends Pessoa {

    /* uma model é basicamente o espelho do nosso banco de dados. Basicamente cada instância que eu
     * criar da minha Models.Aluno vai ser um novo registro que vou gerar dentro do meu banco de dados na tabela movie
     */

    float peso;
    float altura;
    float imc;
    Integer idinstrutor;
    Integer idplano;
    Integer idfichatreino;
//    String senha;

    //construtor
    public Aluno(){}

    public Aluno(String nome){
        this.nome = nome;
    }

    public Aluno(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Aluno(float peso, float altura, float imc, Integer idinstrutor, Integer idplano, Integer idfichatreino, Integer id, String nome, String cpf, String rg, Integer idade, String email, String numcelular, String numcelularopc, String status) {
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.idinstrutor = idinstrutor;
        this.idplano = idplano;
        this.idfichatreino = idfichatreino;
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

    public Aluno(String nome, String cpf, String rg, Integer idade, String numcelular, String status, Integer idplano, Integer idinstrutor) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.idade = idade;
        this.status = status;
        this.numcelular = numcelular;
        this.idplano = idplano;
        this.idinstrutor = idinstrutor;
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
    public String getStatus() {
        return status;
    }
    public Integer getPlanoDoAluno() {
        return idplano;
    }
    public Integer getInstrutorDoAluno() {
        return idplano;
    }
}