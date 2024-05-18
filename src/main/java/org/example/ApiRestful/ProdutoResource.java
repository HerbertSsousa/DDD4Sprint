package org.example.ApiRestful;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Response;
import org.example.baseNobanco.Produto;
import org.example.repositories.ProdutoRepository;

@Path("produto")
public class ProdutoResource {

    private static List<Produto> produtos = new ArrayList<>();
    private final ProdutoRepository produtoRepository;

    public ProdutoResource(){
        produtoRepository = new ProdutoRepository();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getProduto(@PathParam("id") int id) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == id) {
                return produto.toString();
            }
        }
        return "Produto não encontrado";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> getProdutos(){
        return produtoRepository.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduto(Produto produto){
        produtoRepository.add(produto);
        return Response.status(Response.Status.CREATED).build();
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
//    public String addProduto(Produto produto) {
//        // produtos.add(produto);
//        return "Produto adicionado com sucesso";
//    }
@OPTIONS
public Response optionsDados() {
    return Response.ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Methods", "POST, OPTIONS")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Max-Age", "1209600")
            .build();
}

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateProduto(@PathParam("id") int id, Produto produto) {

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getIdProduto() == id) {
                produtos.set(i, produto);
                return "Produto atualizado com sucesso";
            }
        }
        return "Produto não encontrado";
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteProduto(@PathParam("id") int id) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == id) {
                produtos.remove(produto);
                return "Produto excluído com sucesso";
            }
        }
        return "Produto não encontrado";
    }




}
