package org.example.baseNobanco;

public class Produto {

    private int idProduto;
    private String nome;
    private String descricao;
    private Double preco;
    private int categoriaProdutoID;
    private int quantidade;
    private String status;

    public Produto(int idProduto, String nome, String descricao, Double preco, int categoriaProdutoID, int quantidade, String status) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoriaProdutoID = categoriaProdutoID;
        this.quantidade = quantidade;
        this.status = status;
    }

    public Produto() { }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCategoriaProdutoID() {
        return categoriaProdutoID;
    }

    public void setCategoriaProdutoID(int categoriaProdutoID) {
        this.categoriaProdutoID = categoriaProdutoID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

