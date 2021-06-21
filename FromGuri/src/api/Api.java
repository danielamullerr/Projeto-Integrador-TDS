package api;

import domain.Cadastro;
import domain.Categoria;
import domain.Produtos;
import mappers.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Api {
    private PersonMapper<Cadastro> mapperCadastro;
    private Mapper<Categoria> mapperCategoria;
    private Mapper<Produtos> mapperProdutos;

    public Api(PersonMapper<Cadastro> mapperCadastro, Mapper<Categoria> mapperCategoria, Mapper<Produtos> mapperProdutos) {
        this.mapperCadastro = mapperCadastro;
        this.mapperCategoria = mapperCategoria;
        this.mapperProdutos = mapperProdutos;
    }

    public void logar(String cpf, String senha) throws Exception {
        if (cpf.length() == 0) {
            throw new Exception("Login inválido");
        }

        if (senha.length() == 0) {
            throw new Exception("Login inválido");
        }

        Cadastro cadastro = mapperCadastro.findByCPF(cpf);

        if (cadastro == null) {
            throw new Exception("Login inválido");
        }

        if (!cadastro.getSenha().equals(senha)) {
            throw new Exception("Login inválido");
        }
    }

    public void cadastrarProduto(String titulo, String descricao, String cep) throws Exception {
        if (titulo.length() == 0) {
            throw new Exception("Cadastro de Produto Inválido");
        }

        if (descricao.length() == 0) {
            throw new Exception("Cadastro de Produto Inválido");
        }

        if (cep.length() == 0) {
            throw new Exception("Cadastro de Produto Inválido");
        }
    }
    public void cadastrarUsuario(String nome, String cpf, String datanasc, String senha, String email, String rua, String numero, String cidade, String uf) throws Exception {

        if (nome.length() == 0) {

            throw new Exception("Cadastro de Usuário Inválido");

        }

        if (cpf.length() == 0) {

            throw new Exception("Cadastro de Usuário Inválido");

        }

        if (datanasc.length() == 0) {

            throw new Exception("Cadastro de Usuário Inválido");

        }



        if (senha.length() == 0) {

            throw new Exception("Cadastro de Usuário Inválido");

        }



        if (email.length() == 0) {

            throw new Exception("Cadastro de Usuário Inválido");

        }



        if (rua.length() == 0) {

            throw new Exception("Cadastro de Usuário Inválido");

        }



        if (numero.length() == 0) {

            throw new Exception("Cadastro de Usuário Inválido");

        }



        if (cidade.length() == 0) {

            throw new Exception("Cadastro de Usuário Inválido");

        }



        if (uf.length() == 0) {

            throw new Exception("Cadastro de Usuário Inválido");

        }





    }

    public void novoUsuario(Cadastro cadastro) throws SQLException {
       mapperCadastro.insert(cadastro);
    }

    public void novoProduto(Produtos produtos) {

    }

    public List<Produtos> marketPlace() {
        List<Produtos>  marketPlace = new ArrayList<>();

        Produtos produtos = new Produtos();
        produtos.setTitulo("Marceneria");
        produtos.setDescricao("Fábrica de móveis sob medida.");
        marketPlace.add(produtos);

        return marketPlace;
    }

}
