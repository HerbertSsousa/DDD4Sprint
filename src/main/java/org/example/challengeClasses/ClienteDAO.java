package org.example.challengeClasses;

import java.util.ArrayList;
import java.util.List;
import org.example.baseNobanco.Cliente;

public interface ClienteDAO {

    void cadastrarCliente(Cliente cliente);

    Cliente obterClientePorID(int idCliente);

    void atualizarCliente(Cliente cliente);

    void excluirCliente(int idCliente);

    List<Cliente> listarClientes();

    class ClienteServiceImpl implements ClienteDAO {

        private final List<Cliente> clientes = new ArrayList<>();

        @Override
        public void cadastrarCliente(Cliente cliente) {
            clientes.add(cliente);
        }

        @Override
        public Cliente obterClientePorID(int idCliente) {
            for (Cliente cliente : clientes) {
                if (cliente.getIDCliente() == idCliente) {
                    return cliente;
                }
            }
            return null;
        }

        @Override
        public void atualizarCliente(Cliente clienteAtualizado) {
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                if (cliente.getIDCliente() == clienteAtualizado.getIDCliente()) {
                    clientes.set(i, clienteAtualizado);
                    return;
                }
            }
        }

        @Override
        public void excluirCliente(int idCliente) {
            clientes.removeIf(cliente -> cliente.getIDCliente() == idCliente);
        }

        @Override
        public List<Cliente> listarClientes() {
            return clientes;
        }
    }
}
