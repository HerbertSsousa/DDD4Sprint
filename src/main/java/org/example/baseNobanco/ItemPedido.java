package org.example.baseNobanco;


import java.time.LocalDateTime;


public class ItemPedido {

    private int IdItem;
    private int pedidoID;
    private int produtoID;
    private int quantidade;
    private double precoUnitario;


    public ItemPedido(int pedidoID, int produtoID, int quantidade, double precoUnitario) {
        this.pedidoID = pedidoID;
        this.produtoID = produtoID;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }


    public int getID_item() {
        return IdItem;
    }

    public void setID_item(int ID_item) {
        this.IdItem = ID_item;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public LocalDateTime getDataPedido() {
        // TODO Auto-generated method stub
        return null;
    }

    public double getValorTotal() {
        // TODO Auto-generated method stub
        return 0;
    }




}
