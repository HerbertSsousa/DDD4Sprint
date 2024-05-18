package org.example.ApiRestful;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import org.example.baseNobanco.SuporteHumanizado;
import org.example.challengeClasses.SuporteHumanizadoDAO;


import java.util.List;

@Path("/suportes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SuporteResource {

    private final SuporteHumanizadoDAO suporteDAO;


    public SuporteResource(SuporteHumanizadoDAO suporteDAO) {
        this.suporteDAO = suporteDAO;
    }


    public SuporteResource() {
        this.suporteDAO = new SuporteHumanizadoDAO.SuporteHumanizadoServiceImpl();
    }

    @POST
    @Path("/registrar")
    public void registrarTicket(SuporteHumanizado ticket) {
        suporteDAO.registrarTicket(ticket);
    }

    @GET
    @Path("/{id}")
    public SuporteHumanizado obterTicketPorId(@PathParam("id") int idTicket) {
        return suporteDAO.obterTicketPorId(idTicket);
    }

    @PUT
    @Path("/{id}/resolver")
    public void resolverTicket(@PathParam("id") int idTicket) {
        suporteDAO.resolverTicket(idTicket);
    }

    @GET
    @Path("/pendentes")
    public List<SuporteHumanizado> listarTicketsPendentes() {
        return suporteDAO.listarTicketsPendentes();
    }

    @GET
    @Path("/resolvidos")
    public List<SuporteHumanizado> listarTicketsResolvidos() {
        return suporteDAO.listarTicketsResolvidos();
    }

    @GET
    @Path("/todos")
    public List<SuporteHumanizado> listarTodosTickets() {
        return suporteDAO.listarTodosTickets();
    }

    @GET
    @Path("/usuario/{id}")
    public List<SuporteHumanizado> listarTicketsPorUsuario(@PathParam("id") int idUsuario) {
        return suporteDAO.listarTicketsPorUsuario(idUsuario);
    }
}