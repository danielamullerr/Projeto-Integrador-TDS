package mappers;

import domain.Cadastro;
import domain.Categoria;
import domain.Produtos;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ProdutosMapper implements Mapper<Produtos>{
    private Connection connection;
    private Map<Integer, Produtos> loadedBrands;

    public ProdutosMapper(Connection connection) {
        this.connection = connection;
        loadedBrands = new HashMap<>();

    }

    @Override
    public Produtos findByID(int id) {
        return null;
    }

    public void insert(Produtos entity) throws SQLException {
        String sql = "INSERT INTO Produtos(id_categoria, titulo, descricao, cep) VALUES(?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, entity.getId_produto());
            statement.setString(2, entity.getTitulo());
            statement.setString(3, entity.getDescricao());
            statement.setString(4, entity.getCep());
            statement.executeUpdate();

        }
    }


    public void update(Produtos entity) throws SQLException {

        String sql = "UPDATE Produtos SET titulo = ?, descricao = ?, cep = ? WHERE id_categoria = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getTitulo());
            statement.setString(2, entity.getDescricao());
            statement.setString(3, entity.getCep());
            statement.setInt(7, entity.getId_produto());
            statement.executeUpdate();
        }
    }


    public void delete(Produtos entity) throws SQLException {
        String sql = "DELETE FROM Produtos  WHERE id_categoria = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId_produto());
            statement.executeUpdate();
            loadedBrands.remove(entity.getId_produto());
        }
    }



    private Produtos map(ResultSet resultSet) throws SQLException {
        Produtos produtos = new Produtos();
        produtos.setId_produto(resultSet.getInt(1));
        loadedBrands.put(produtos.getId_produto(), produtos);
        return produtos;
    }

}

