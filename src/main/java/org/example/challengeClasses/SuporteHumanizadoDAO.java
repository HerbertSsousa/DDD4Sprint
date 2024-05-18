package org.example.challengeClasses;

import org.example.baseNobanco.SuporteHumanizado;

import java.util.ArrayList;
import java.util.List;

public interface SuporteHumanizadoDAO {

    void registrarTicket(SuporteHumanizado ticket);

    SuporteHumanizado obterTicketPorId(int idTicket);

    void resolverTicket(int idTicket);

    List<SuporteHumanizado> listarTicketsPendentes();

    List<SuporteHumanizado> listarTicketsResolvidos();

    List<SuporteHumanizado> listarTodosTickets();

    List<SuporteHumanizado> listarTicketsPorUsuario(int idUsuario);

    class SuporteHumanizadoServiceImpl implements SuporteHumanizadoDAO {

        private List<SuporteHumanizado> tickets;

        public SuporteHumanizadoServiceImpl() {
            this.tickets = new ArrayList<>();
        }

        @Override
        public void registrarTicket(SuporteHumanizado ticket) {
            tickets.add(ticket);
        }

        @Override
        public SuporteHumanizado obterTicketPorId(int idTicket) {
            for (SuporteHumanizado ticket : tickets) {
                if (ticket.getIdSuporte() == idTicket) {
                    return ticket;
                }
            }
            return null;
        }

        @Override
        public void resolverTicket(int idTicket) {
            SuporteHumanizado ticket = obterTicketPorId(idTicket);
            if (ticket != null) {
                ticket.setResolvido(true);
            }
        }


        @Override
        public List<SuporteHumanizado> listarTicketsPendentes() {
            List<SuporteHumanizado> pendentes = new ArrayList<>();
            for (SuporteHumanizado ticket : tickets) {
                if (!ticket.isResolvido()) {
                    pendentes.add(ticket);
                }
            }
            return pendentes;
        }


        @Override
        public List<SuporteHumanizado> listarTicketsResolvidos() {
            List<SuporteHumanizado> resolvidos = new ArrayList<>();
            for (SuporteHumanizado ticket : tickets) {
                if (ticket.isResolvido()) {
                    resolvidos.add(ticket);
                }
            }
            return resolvidos;
        }


        @Override
        public List<SuporteHumanizado> listarTodosTickets() {
            return new ArrayList<>(tickets);
        }

        @Override
        public List<SuporteHumanizado> listarTicketsPorUsuario(int idUsuario) {
            List<SuporteHumanizado> ticketsUsuario = new ArrayList<>();
            for (SuporteHumanizado ticket : tickets) {
                if (ticket.getIdSuporte() == idUsuario) {
                    ticketsUsuario.add(ticket);
                }
            }
            return ticketsUsuario;
        }

    }
}
