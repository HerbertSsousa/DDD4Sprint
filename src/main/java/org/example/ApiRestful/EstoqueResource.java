package org.example.ApiRestful;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.baseNobanco.Estoque;
import org.example.challengeClasses.EstoqueDAO;
import org.example.challengeClasses.EstoqueDAO.EstoqueServiceImpl;

import java.util.List;

@Path("/estoque")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstoqueResource {

    private final EstoqueDAO estoqueDAO;

    public EstoqueResource(EstoqueDAO estoqueDAO) {
        this.estoqueDAO = estoqueDAO;
    }

    public EstoqueResource() {
        this.estoqueDAO = new EstoqueServiceImpl();
    }

    @POST
    @Path("/adicionar")
    public void adicionarProdutoEstoque(Estoque estoque) {
        estoqueDAO.adicionarProdutoEstoque(estoque);
    }

    @GET
    @Path("/{id}")
    public Estoque obterEstoquePorId(@PathParam("id") int idEstoque) {
        return estoqueDAO.obterEstoquePorId(idEstoque);
    }

    @GET
    @Path("/produto/{produtoId}")
    public Estoque obterEstoquePorProduto(@PathParam("produtoId") int produtoID) {
        return estoqueDAO.obterEstoquePorProduto(produtoID);
    }

    @PUT
    @Path("/{id}/atualizar-quantidade")
    public void atualizarQuantidadeEstoque(@PathParam("id") int idEstoque, int novaQuantidade) {
        estoqueDAO.atualizarQuantidadeEstoque(idEstoque, novaQuantidade);
    }

    @GET
    public List<Estoque> listarEstoque() {
        return estoqueDAO.listarEstoque();
    }

    @GET
    @Path("/baixo/{quantidadeMinima}")
    public List<Estoque> listarEstoqueBaixo(@PathParam("quantidadeMinima") int quantidadeMinima) {
        return estoqueDAO.listarEstoqueBaixo(quantidadeMinima);
    }
}
