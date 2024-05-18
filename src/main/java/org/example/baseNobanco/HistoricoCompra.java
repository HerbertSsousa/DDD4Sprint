package org.example.baseNobanco;

import java.time.LocalDateTime;


public class HistoricoCompra {

    private int IdHistoricoCompra;
    private int clienteID;
    private String consulta;
    private String historicoCompras;
    private int produtoID;
    private LocalDateTime dataHora;


    public int getID_historico_compra() {
        return IdHistoricoCompra;
    }
    public void setID_historico_compra(int iD_historico_compra) {
        IdHistoricoCompra = iD_historico_compra;
    }
    public int getClienteID() {
        return clienteID;
    }
    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }
    public String getConsulta() {
        return consulta;
    }
    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }
    public String getHistoricoCompras() {
        return historicoCompras;
    }
    public void setHistoricoCompras(String historicoCompras) {
        this.historicoCompras = historicoCompras;
    }
    public int getProdutoID() {
        return produtoID;
    }
    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public int getCategoriaProdutoID() {
        return categoriaProdutoID;
    }
    public void setCategoriaProdutoID(int categoriaProdutoID) {
        this.categoriaProdutoID = categoriaProdutoID;
    }
    private int categoriaProdutoID;




}
