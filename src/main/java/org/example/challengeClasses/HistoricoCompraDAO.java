package org.example.challengeClasses;


import org.example.baseNobanco.HistoricoCompra;

import java.util.ArrayList;
import java.util.List;

public interface HistoricoCompraDAO {

    void registrarHistoricoCompra(HistoricoCompra historicoCompra);

    HistoricoCompra obterHistoricoCompraPorId(int idHistoricoCompra);

    List<HistoricoCompra> listarHistoricoComprasPorCliente(int clienteID);

    List<HistoricoCompra> listarHistoricoComprasPorProduto(int produtoID);

    List<HistoricoCompra> listarHistoricoCompras();


    class HistoricoCompraServiceImpl implements HistoricoCompraDAO {

        private List<HistoricoCompra> historicoCompras;

        public HistoricoCompraServiceImpl() {
            this.historicoCompras = new ArrayList<>();
        }

        @Override
        public void registrarHistoricoCompra(HistoricoCompra historicoCompra) {
            historicoCompras.add(historicoCompra);
        }

        @Override
        public HistoricoCompra obterHistoricoCompraPorId(int idHistoricoCompra) {
            for (HistoricoCompra historicoCompra : historicoCompras) {
                if (historicoCompra.getID_historico_compra() == idHistoricoCompra) {
                    return historicoCompra;
                }
            }
            return null;
        }

        @Override
        public List<HistoricoCompra> listarHistoricoComprasPorCliente(int clienteID) {
            List<HistoricoCompra> historicoComprasPorCliente = new ArrayList<>();
            for (HistoricoCompra historicoCompra : historicoCompras) {
                if (historicoCompra.getClienteID() == clienteID) {
                    historicoComprasPorCliente.add(historicoCompra);
                }
            }
            return historicoComprasPorCliente;
        }

        @Override
        public List<HistoricoCompra> listarHistoricoComprasPorProduto(int produtoID) {
            List<HistoricoCompra> historicoComprasPorProduto = new ArrayList<>();
            for (HistoricoCompra historicoCompra : historicoCompras) {
                if (historicoCompra.getProdutoID() == produtoID) {
                    historicoComprasPorProduto.add(historicoCompra);
                }
            }
            return historicoComprasPorProduto;
        }

        @Override
        public List<HistoricoCompra> listarHistoricoCompras() {
            return historicoCompras;
        }
    }
}
