package mappers;


import domain.Cadastro;
import domain.Categoria;

import java.sql.*;

import java.util.HashMap;

import java.util.Map;

public class CategoriaMapper implements Mapper<Categoria> {

    private Connection connection;
    private Map<Integer, Categoria> loadedBrands;

    public CategoriaMapper(Connection connection) {
        this.connection = connection;
        loadedBrands = new HashMap<>();
    }

    @Override
    public Categoria findByID(int id) {
        return null;
    }

    public void insert(Categoria entity) throws SQLException {
        String sql = "INSERT INTO Categoria(categoria) VALUES(?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getCategoria());
            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()) {
                keys.next();
                int id = keys.getInt(1);
                entity.setId(id);
                loadedBrands.put(id, entity);
            }
        }
    }

    @Override
    public void update(Categoria entity) throws SQLException {
        String sql = "UPDATE Categoria SET categoria = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getCategoria());
            statement.setInt(2, entity.getId());
            statement.executeUpdate();
        }
    }


    public void delete(Categoria entity) throws SQLException {
        String sql = "DELETE FROM Categoria  WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
            loadedBrands.remove(entity.getId());
        }
    }

    private Categoria map(ResultSet resultSet) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getInt(1));
        categoria.setCategoria(resultSet.getString(2));
        loadedBrands.put(categoria.getId(), categoria);
        return categoria;
    }
}



