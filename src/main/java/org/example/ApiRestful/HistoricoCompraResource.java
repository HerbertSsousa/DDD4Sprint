package org.example.ApiRestful;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.baseNobanco.HistoricoCompra;
import org.example.challengeClasses.HistoricoCompraDAO;
import org.example.challengeClasses.HistoricoCompraDAO.HistoricoCompraServiceImpl;

import java.util.List;

@Path("/historicoCompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoricoCompraResource {

    private final HistoricoCompraDAO historicoCompraDAO;

    public HistoricoCompraResource(HistoricoCompraDAO historicoCompraDAO) {
        this.historicoCompraDAO = historicoCompraDAO;
    }

    public HistoricoCompraResource() {
        this.historicoCompraDAO = new HistoricoCompraServiceImpl();
    }

    @POST
    @Path("/registrar")
    public void registrarHistoricoCompra(HistoricoCompra historicoCompra) {
        historicoCompraDAO.registrarHistoricoCompra(historicoCompra);
    }

    @GET
    @Path("/{id}")
    public HistoricoCompra obterHistoricoCompraPorId(@PathParam("id") int idHistoricoCompra) {
        return historicoCompraDAO.obterHistoricoCompraPorId(idHistoricoCompra);
    }

    @GET
    @Path("/cliente/{clienteId}")
    public List<HistoricoCompra> listarHistoricoComprasPorCliente(@PathParam("clienteId") int clienteID) {
        return historicoCompraDAO.listarHistoricoComprasPorCliente(clienteID);
    }

    @GET
    @Path("/produto/{produtoId}")
    public List<HistoricoCompra> listarHistoricoComprasPorProduto(@PathParam("produtoId") int produtoID) {
        return historicoCompraDAO.listarHistoricoComprasPorProduto(produtoID);
    }

    @GET
    public List<HistoricoCompra> listarHistoricoCompras() {
        return historicoCompraDAO.listarHistoricoCompras();
    }
}
