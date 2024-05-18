package org.example.challengeClasses;

import java.time.LocalDateTime;

public class Pagamentos {

    private int IdPagamento;
    private int pedidoID;
    private String metodoPagamento;
    private double valorPago;
    private LocalDateTime dataPagamento;

    // Construtor
    public Pagamentos(int pedidoID, String metodoPagamento, double valorPago, LocalDateTime dataPagamento) {
        this.pedidoID = pedidoID;
        this.metodoPagamento = metodoPagamento;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    // Getters e Setters
    public int getID_pagamento() {
        return IdPagamento;
    }

    public void setID_pagamento(int ID_pagamento) {
        this.IdPagamento = ID_pagamento;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }



}
