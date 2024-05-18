package org.example.challengeClasses;

import java.util.Scanner;


public class Login {

    /*  public boolean autenticar() {
            if (this.email.equals("teste@teste.com") && this.senha.equals("123456")) {
                return true;
            } else {
                return false;
            }
        }
    */
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String nomeCompleto;
    private String telefone;

    public Login(String nome, String email, String senha, String cpf, String nomeCompleto) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    //==============================================
    @Override
    public String toString() {
        return "Login: " +
                "nome= '" + nome + '\'' +
                ", email= '" + email + '\'' +
                ", senha= '" + senha + '\'' +
                ", cpf= '" + cpf + '\'' +
                ", nomeCompleto= '" + nomeCompleto + '\'' +
                ", telefone= '" + telefone + '\'' +
                '}';
    }


}
