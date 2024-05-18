package org.example.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.baseNobanco.SuporteHumanizado;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SuporteRepository {

    public static final Logger LOGGER = LogManager.getLogger(SuporteRepository.class);
    public static String URL_ORACLE;
    public static String USER;
    public static String PASSWORD;

    public static final String TABLE_NAME = "SUPORTE";

    public static final Map<String, String> TABLE_COLUMNS = Map.of(
            "ID_SUPORTE", "ID_SUPORTE",
            "NOME", "NOME",
            "EMAIL", "EMAIL",
            "HORARIO_ATENDIMENTO", "HORARIO_ATENDIMENTO",
            "RESOLVIDO", "RESOLVIDO"
    );

    public SuporteRepository(){
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

    public List<SuporteHumanizado> getAll() {
        var tickets = new ArrayList<SuporteHumanizado>();
        try (Connection connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
             var preparedStatement = connection.prepareStatement("SELECT * FROM " + TABLE_NAME);
             var resultSet = preparedStatement.executeQuery()
        ){
            while (resultSet.next()) {
                SuporteHumanizado ticket = new SuporteHumanizado();
                ticket.setID_suporte(resultSet.getInt(TABLE_COLUMNS.get("ID_SUPORTE")));
                ticket.setNome(resultSet.getString(TABLE_COLUMNS.get("NOME")));
                ticket.setEmail(resultSet.getString(TABLE_COLUMNS.get("EMAIL")));
                ticket.setHorarioAtendimento(resultSet.getString(TABLE_COLUMNS.get("HORARIO_ATENDIMENTO")));
                ticket.setResolvido(resultSet.getBoolean(TABLE_COLUMNS.get("RESOLVIDO")));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            LOGGER.error("Erro ao tentar pegar todos os tickets de suporte {}", e.getMessage());
        }
        LOGGER.info("Tickets de suporte retornados com sucesso");
        return tickets;
    }

    public void add(SuporteHumanizado ticket){
        try(var connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
            var preparedStatement = connection.prepareStatement(
                    "INSERT INTO %s(%s,%s,%s,%s,%s) VALUES(?,?,?,?,?)"
                            .formatted(TABLE_NAME,
                                    TABLE_COLUMNS.get("ID_SUPORTE"),
                                    TABLE_COLUMNS.get("NOME"),
                                    TABLE_COLUMNS.get("EMAIL"),
                                    TABLE_COLUMNS.get("HORARIO_ATENDIMENTO"),
                                    TABLE_COLUMNS.get("RESOLVIDO")
                            ))

        ) {
            preparedStatement.setInt(1, ticket.getIdSuporte());
            preparedStatement.setString(2, ticket.getNome());
            preparedStatement.setString(3, ticket.getEmail());
            preparedStatement.setString(4, ticket.getHorarioAtendimento());
            preparedStatement.setBoolean(5, ticket.isResolvido());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.error("Erro ao tentar adicionar ticket de suporte {}", e.getMessage());
        }
    }

    public void update(int id, SuporteHumanizado ticket) {
        try (Connection connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?"
                     .formatted(TABLE_NAME,
                             TABLE_COLUMNS.get("NOME"),
                             TABLE_COLUMNS.get("EMAIL"),
                             TABLE_COLUMNS.get("HORARIO_ATENDIMENTO"),
                             TABLE_COLUMNS.get("RESOLVIDO"),
                             TABLE_COLUMNS.get("ID_SUPORTE")
                     ))) {
            preparedStatement.setString(1, ticket.getNome());
            preparedStatement.setString(2, ticket.getEmail());
            preparedStatement.setString(3, ticket.getHorarioAtendimento());
            preparedStatement.setBoolean(4, ticket.isResolvido());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Erro ao tentar atualizar ticket de suporte {}", e.getMessage());
        }
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM %s WHERE %s = ?"
                     .formatted(TABLE_NAME, TABLE_COLUMNS.get("ID_SUPORTE")))) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Erro ao tentar excluir ticket de suporte {}", e.getMessage());
        }
    }
}
