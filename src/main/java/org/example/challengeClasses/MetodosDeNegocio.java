package org.example.challengeClasses;


import java.time.LocalDateTime;
import java.util.List;
import org.example.baseNobanco.ItemPedido;
import org.example.baseNobanco.Cliente;
import org.example.baseNobanco.Produto;

public class MetodosDeNegocio {


    //===============================================
// fizemos o m�todo para verificar se um cliente atingiu um determinado n�vel de fidelidade

    public boolean verificarFidelidadeCliente(Cliente cliente) {
        int totalCompras = cliente.getHistoricoCompra().size();
        return totalCompras >= 5;
    }

    //==============================================
// fizemos o m�todo para calcular o total de vendas em um determinado per�odo
    public double calcularTotalVendas(List<ItemPedido> pedidos, LocalDateTime inicio, LocalDateTime fim) {
        double totalVendas = 0;
        for (ItemPedido pedido : pedidos) {
            LocalDateTime dataPedido = pedido.getDataPedido();
            if (dataPedido.isAfter(inicio) && dataPedido.isBefore(fim)) {
                totalVendas += pedido.getValorTotal();
            }
        }
        return totalVendas;
    }


    //===============================================
    // fizemos o m�todo para verificar se o produto est� em oferta




    //===============================================
    // fizemos o m�todo para calcular o n�mero de clientes ativos

    public int calcularClientesAtivos(List<Cliente> clientes) {
        int clientesAtivos = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getUltimoAcesso().isAfter(LocalDateTime.now().minusMonths(1))) {
                clientesAtivos++;
            }
        }
        return clientesAtivos;
    }

    //===============================================

//fizemos o m�todo para calcular a m�dia de vendas por cliente

    public double calcularMediaVendasPorCliente(List<Cliente> clientes, List<ItemPedido> pedidos) {
        if (clientes.isEmpty()) {
            return 0;
        }
        int totalVendas = pedidos.size();
        int totalClientes = clientes.size();
        return (double) totalVendas / totalClientes;
    }


}
