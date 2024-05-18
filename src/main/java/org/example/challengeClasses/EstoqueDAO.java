package org.example.challengeClasses;

import org.example.baseNobanco.Estoque;

import java.util.ArrayList;
import java.util.List;

public interface EstoqueDAO {

    void adicionarProdutoEstoque(Estoque estoque);

    Estoque obterEstoquePorId(int idEstoque);

    Estoque obterEstoquePorProduto(int produtoID);

    void atualizarQuantidadeEstoque(int idEstoque, int novaQuantidade);

    List<Estoque> listarEstoque();

    List<Estoque> listarEstoqueBaixo(int quantidadeMinima);


    class EstoqueServiceImpl implements EstoqueDAO {

        private List<Estoque> estoque;

        public EstoqueServiceImpl() {
            this.estoque = new ArrayList<>();
        }

        @Override
        public void adicionarProdutoEstoque(Estoque itemEstoque) {
            estoque.add(itemEstoque);
        }

        @Override
        public Estoque obterEstoquePorId(int idEstoque) {
            for (Estoque item : estoque) {
                if (item.getID_estoque() == idEstoque) {
                    return item;
                }
            }
            return null;
        }

        @Override
        public Estoque obterEstoquePorProduto(int produtoID) {
            for (Estoque item : estoque) {
                if (item.getProdutoID() == produtoID) {
                    return item;
                }
            }
            return null;
        }

        @Override
        public void atualizarQuantidadeEstoque(int idEstoque, int novaQuantidade) {
            Estoque item = obterEstoquePorId(idEstoque);
            if (item != null) {
                item.setQuantidade(novaQuantidade);
            }
        }

        @Override
        public List<Estoque> listarEstoque() {
            return new ArrayList<>(estoque);
        }

        @Override
        public List<Estoque> listarEstoqueBaixo(int quantidadeMinima) {
            List<Estoque> estoqueBaixo = new ArrayList<>();
            for (Estoque item : estoque) {
                if (item.getQuantidade() < quantidadeMinima) {
                    estoqueBaixo.add(item);
                }
            }
            return estoqueBaixo;
        }
    }
}
