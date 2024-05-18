package org.example.challengeClasses;

import org.example.baseNobanco.Produto;

import java.util.ArrayList;
import java.util.List;


public interface ProdutoDAO {



    void cadastrarProduto(Produto produto);

    Produto obterProdutoPorId(int idProduto);

    void atualizarProduto(Produto produto);

    void excluirProduto(int idProduto);

    List<Produto> listarProdutos();

    List<Produto> listarProdutosPorCategoria(int idCategoria);

    class ProdutoServiceImpl implements ProdutoDAO {

        private List<Produto> produtos;

        public ProdutoServiceImpl() {
            this.produtos = new ArrayList<>();
        }

        @Override
        public void cadastrarProduto(Produto produto) {
            produtos.add(produto);
        }

        @Override
        public Produto obterProdutoPorId(int idProduto) {
            for (Produto produto : produtos) {
                if (produto.getIdProduto() == idProduto) {
                    return produto;
                }
            }
            return null;
        }

        @Override
        public void atualizarProduto(Produto produtoAtualizado) {
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                if (produto.getIdProduto() == produtoAtualizado.getIdProduto()) {
                    produtos.set(i, produtoAtualizado);
                    return;
                }
            }
        }

        @Override
        public void excluirProduto(int idProduto) {
            produtos.removeIf(produto -> produto.getIdProduto() == idProduto);
        }

        @Override
        public List<Produto> listarProdutos() {
            return produtos;
        }

        @Override
        public List<Produto> listarProdutosPorCategoria(int idCategoria) {
            List<Produto> produtosPorCategoria = new ArrayList<>();
            for (Produto produto : produtos) {
                if (produto.getCategoriaProdutoID() == idCategoria) {
                    produtosPorCategoria.add(produto);
                }
            }
            return produtosPorCategoria;
        }
    }
}
