package Models;

public class Aparelho {

    private Integer idaparelho;
    private String nomeaparelho;

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
