import api.Api;
import domain.Cadastro;
import domain.Categoria;
import domain.Produtos;
import forms.Login;
import mappers.*;

import java.sql.Connection;
import java.sql.*;

public class Main {

    private Connection connection;

    public void run() throws SQLException {
        try {
            connection = createConnection();
            PersonMapper<Cadastro> mapperCadastro = new CadastroMapper(connection);
            Mapper<Categoria> mapperCategoria = new CategoriaMapper(connection);
            Mapper<Produtos> mapperProdutos = new ProdutosMapper(connection);
            Api api = new Api(mapperCadastro, mapperCategoria, mapperProdutos);
            Login login = new Login(api);
            login.showMe();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://localhost/fromGuri", "root", null);
    }

    public static void main(String[] args) throws SQLException {

        (new Main()).run();




    }

}
