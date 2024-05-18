package org.example.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.ApiRestful.ProdutoResource;
import org.example.baseNobanco.Produto;

import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ProdutoRepository {

    public static final Logger LOGGER = LogManager.getLogger(ProdutoRepository.class);
    public static String URL_ORACLE;
    public static String USER;
    public static String PASSWORD;

    public static final String TABLE_NAME = "PRODUTO";

    public static final Map<String, String> TABLE_COLUMNS = Map.of(
            "ID_PRODUTO", "ID_PRODUTO",
            "NOME", "NOME",
            "PRECO", "PRECO",
            "DESCRICAO", "DESCRICAO",
            "CATEGORIAPRODUTOID", "CATEGORIAPRODUTOID",
            "QUANTIDADE", "QUANTIDADE",
            "STATUS", "STATUS"
    );

    public ProdutoRepository(){
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

    public List<Produto> getAll() {
        var produtos = new ArrayList<Produto>();
        try (Connection connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
             var preparedStatement = connection.prepareStatement("SELECT * FROM " + TABLE_NAME);
             var resultSet = preparedStatement.executeQuery()
        ){
            while (resultSet.next()) {
                Produto produto = new Produto(
                        resultSet.getInt(TABLE_COLUMNS.get("ID_PRODUTO")),
                        resultSet.getString(TABLE_COLUMNS.get("NOME")),
                        resultSet.getString(TABLE_COLUMNS.get("DESCRICAO")),
                        resultSet.getDouble(TABLE_COLUMNS.get("PRECO")),
                        resultSet.getInt(TABLE_COLUMNS.get("CATEGORIAPRODUTOID")),
                        resultSet.getInt(TABLE_COLUMNS.get("QUANTIDADE")),
                        resultSet.getString(TABLE_COLUMNS.get("STATUS"))
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            LOGGER.error("Erro ao tentar pegar todos os produtos {}",
                    e.getMessage());
        }
        LOGGER.info("Produtos retornados com sucesso");
        return produtos;
    }

    public void add(Produto produto){
        try(var connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
            var preparedStatement = connection.prepareStatement(
                    "INSERT INTO %s(%s,%s,%s,%s,%s,%s,%s) VALUES(?,?,?,?,?,?,?)"
                            .formatted(TABLE_NAME,
                                    TABLE_COLUMNS.get("ID_PRODUTO"),
                                    TABLE_COLUMNS.get("NOME"),
                                    TABLE_COLUMNS.get("PRECO"),
                                    TABLE_COLUMNS.get("DESCRICAO"),
                                    TABLE_COLUMNS.get("CATEGORIAPRODUTOID"),
                                    TABLE_COLUMNS.get("QUANTIDADE"),
                                    TABLE_COLUMNS.get("STATUS")
                            ))

        ) {
            preparedStatement.setInt(1, produto.getIdProduto());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setDouble(3, produto.getPreco());
            preparedStatement.setString(4, produto.getDescricao());
            preparedStatement.setInt(5, produto.getCategoriaProdutoID());
            preparedStatement.setInt(6, produto.getQuantidade());
            preparedStatement.setString(7, produto.getStatus());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

//    public void add(Produto produto) {
//        try (Connection connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
//             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto (NOME, PRECO, DESCRICAO, CATEGORIAPRODUTOID, QUANTIDADE, STATUS) VALUES (?, ?, ?, ?, ?, ?)")) {
//            preparedStatement.setString(1, produto.getNome());
//            preparedStatement.setDouble(2, produto.getPreco());
//            preparedStatement.setString(3, produto.getDescricao());
//            preparedStatement.setInt(4, produto.getCategoriaProdutoID());
//            preparedStatement.setInt(5, produto.getQuantidade());
//            preparedStatement.setString(6, produto.getStatus());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void update(int id, Produto produto) {
        try (Connection connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET NOME = ?, PRECO = ?, DESCRICAO = ?, CATEGORIAPRODUTOID = ?, QUANTIDADE = ?, STATUS = ? WHERE ID_PRODUTO = ?")) {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setDouble(2, produto.getPreco());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setInt(4, produto.getCategoriaProdutoID());
            preparedStatement.setInt(5, produto.getQuantidade());
            preparedStatement.setString(6, produto.getStatus());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produto WHERE ID_PRODUTO = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
