package org.example.baseNobanco;

public class TipoProduto {


    private int IdTipoProduto;
    private String nome;
    private String descricao;

    public int getID_tipo_produto() {
        return IdTipoProduto;
    }
    public void setID_tipo_produto(int iD_tipo_produto) {
        IdTipoProduto = iD_tipo_produto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }




}
