package org.example.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.baseNobanco.Cliente;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ClienteRepository {

    public static final Logger LOGGER = LogManager.getLogger(ClienteRepository.class);
    public static String URL_ORACLE;
    public static String USER;
    public static String PASSWORD;

    public static final String TABLE_NAME = "CLIENTE";

    public static final Map<String, String> TABLE_COLUMNS = Map.of(
            "ID_CLIENTE", "ID_CLIENTE",
            "NOME_COMPLETO", "NOME_COMPLETO",
            "EMAIL", "EMAIL",
            "SENHA_LOGIN", "SENHA_LOGIN",
            "CPF", "CPF"
    );

    public ClienteRepository(){
        try(var inputStream = getClass().getClassLoader()
                .getResourceAsStream("database.properties"))
        {
            var properties = new Properties();
            properties.load(inputStream);
            URL_ORACLE = properties.getProperty("jdbc.url");
            USER = properties.getProperty("jdbc.username");
            PASSWORD = properties.getProperty("jdbc.password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getAll() {
        var clientes = new ArrayList<Cliente>();
        try (Connection connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
             var preparedStatement = connection.prepareStatement("SELECT * FROM " + TABLE_NAME);
             var resultSet = preparedStatement.executeQuery()
        ){
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIDCliente(resultSet.getInt(TABLE_COLUMNS.get("ID_CLIENTE")));
                cliente.setNomeCompleto(resultSet.getString(TABLE_COLUMNS.get("NOME_COMPLETO")));
                cliente.setEmail(resultSet.getString(TABLE_COLUMNS.get("EMAIL")));
                cliente.setSenhaLogin(resultSet.getString(TABLE_COLUMNS.get("SENHA_LOGIN")));
                cliente.setCpf(resultSet.getString(TABLE_COLUMNS.get("CPF")));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            LOGGER.error("Erro ao tentar pegar todos os clientes {}", e.getMessage());
        }
        LOGGER.info("Clientes retornados com sucesso");
        return clientes;
    }

    public void add(Cliente cliente){
        try(var connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
            var preparedStatement = connection.prepareStatement(
                    "INSERT INTO %s(%s,%s,%s,%s,%s) VALUES(?,?,?,?,?)"
                            .formatted(TABLE_NAME,
                                    TABLE_COLUMNS.get("ID_CLIENTE"),
                                    TABLE_COLUMNS.get("NOME_COMPLETO"),
                                    TABLE_COLUMNS.get("EMAIL"),
                                    TABLE_COLUMNS.get("SENHA_LOGIN"),
                                    TABLE_COLUMNS.get("CPF")
                            ))

        ) {
            preparedStatement.setInt(1, cliente.getIDCliente());
            preparedStatement.setString(2, cliente.getNomeCompleto());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getSenhaLogin());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void update(int id, Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cliente SET NOME_COMPLETO = ?, EMAIL = ?, SENHA_LOGIN = ?, CPF = ? WHERE ID_CLIENTE = ?")) {
            preparedStatement.setString(1, cliente.getNomeCompleto());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getSenhaLogin());
            preparedStatement.setString(4, cliente.getCpf());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cliente WHERE ID_CLIENTE = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
