package org.example.ApiRestful;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.baseNobanco.Cliente;
import org.example.challengeClasses.ClienteDAO;
import org.example.challengeClasses.ClienteDAO.ClienteServiceImpl;
import java.util.List;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    private final ClienteDAO clienteDAO;


    public ClienteResource(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }


    public ClienteResource() {
        this.clienteDAO = new ClienteServiceImpl();
    }

    @POST
    public void cadastrarCliente(Cliente cliente) {
        clienteDAO.cadastrarCliente(cliente);
    }

    @GET
    @Path("/{id}")
    public Cliente obterClientePorID(@PathParam("id") int idCliente) {
        return clienteDAO.obterClientePorID(idCliente);
    }

    @PUT
    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizarCliente(cliente);
    }

    @DELETE
    @Path("/{id}")
    public void excluirCliente(@PathParam("id") int idCliente) {
        clienteDAO.excluirCliente(idCliente);
    }

    @GET
    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }
}
