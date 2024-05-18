package org.example.baseNobanco;


import java.time.LocalDateTime;
import java.util.List;


public class Cliente {

    private int IDCliente;
    private String nomeCompleto;
    private String email;
    private String senhaLogin;
    private String cpf;

    public int getIDCliente() {
        return IDCliente;
    }
    public void setIDCliente(int iD_cliente) {
        IDCliente = iD_cliente;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenhaLogin() {
        return senhaLogin;
    }
    public void setSenhaLogin(String senhaLogin) {
        this.senhaLogin = senhaLogin;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public List<ItemPedido> getHistoricoCompra() {
        // TODO Auto-generated method stub
        return null;
    }
    public boolean isPremium() {
        // TODO Auto-generated method stub
        return false;
    }
    public LocalDateTime getUltimoAcesso() {
        // TODO Auto-generated method stub
        return null;
    }






}
