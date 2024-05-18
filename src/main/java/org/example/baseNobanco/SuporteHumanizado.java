package org.example.baseNobanco;

public class SuporteHumanizado {

    private int IdSuporte;
    private String nome;
    private String email;
    private String horarioAtendimento;
    private boolean resolvido;

    public int getIdSuporte() {
        return IdSuporte;
    }
    public void setID_suporte(int iD_suporte) {
        IdSuporte = iD_suporte;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }
    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }
    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }


}
