package mappers;
import domain.Cadastro;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CadastroMapper implements  PersonMapper<Cadastro> {
    private Connection connection;
    private Map<String, Cadastro> loadedCadastro;

    public CadastroMapper(Connection connection) {
        this.connection = connection;
        loadedCadastro = new HashMap<>();

    }

    @Override
    public Cadastro findByID(int id) {
        return null;
    }

    public Cadastro findByCPF(String cpf) throws SQLException {
           Cadastro cadastro = loadedCadastro.get(cpf);
           if (cadastro == null) {
               String sql = "SELECT nome, cpf, datanasc, senha, email, rua, numero, cidade, uf FROM Cadastro WHERE cpf = ?";
               try (PreparedStatement statement = connection.prepareStatement(sql)) {
                   statement.setString(1, cpf);
                   try (ResultSet resultSet = statement.executeQuery()) {
                       if (resultSet.first()) {
                           cadastro = map(resultSet);
                       }
                   }
               }
           }
           return cadastro;
       }


    public void insert(Cadastro entity) throws SQLException {
        String sql = "INSERT INTO Cadastro(nome, cpf, datanasc, senha, email, rua, numero, cidade, uf) VALUES(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getNome());
            statement.setString(2, entity.getCpf());
            statement.setString(3, entity.getDataNascimento());
            statement.setString(4, entity.getSenha());
            statement.setString(5, entity.getEmail());
            statement.setString(6, entity.getRua());
            statement.setString(7, entity.getNumero());
            statement.setString(8, entity.getCidade());
            statement.setString(9, entity.getUf());
            statement.executeUpdate();

        }
    }

    @Override
    public void update(Cadastro entity) throws SQLException {
        //
        String sql = "UPDATE Cadastro SET nome = ?, datanasc = ?, senha = ?, email = ?, rua = ?, numero = ?, cidade = ?, uf = ? WHERE cpf = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getNome());
            statement.setString(2, entity.getDataNascimento());
            statement.setString(3, entity.getSenha());
            statement.setString(4, entity.getEmail());
            statement.setString(5, entity.getRua());
            statement.setString(6, entity.getNumero());
            statement.setString(7, entity.getCidade());
            statement.setString(8, entity.getUf());
            statement.setString(9, entity.getCpf());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Cadastro entity) throws SQLException {
        String sql = "DELETE FROM Cadastro  WHERE cpf = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getCpf());
            statement.executeUpdate();
            loadedCadastro.remove(entity.getCpf());
        }
    }



    private Cadastro map(ResultSet resultSet) throws SQLException {
        Cadastro cadastro = new Cadastro();
        cadastro.setCpf(resultSet.getString("cpf"));
        cadastro.setSenha(resultSet.getString("senha"));
        cadastro.setDataNascimento(resultSet.getString("datanasc"));
        cadastro.setNome(resultSet.getString("nome"));
        cadastro.setEmail(resultSet.getString("email"));
        cadastro.setRua(resultSet.getString("rua"));
        cadastro.setNumero(resultSet.getString("numero"));
        cadastro.setCidade(resultSet.getString("cidade"));
        cadastro.setUf(resultSet.getString("uf"));
        loadedCadastro.put(cadastro.getCpf(), cadastro);
        return cadastro;

    }

}
