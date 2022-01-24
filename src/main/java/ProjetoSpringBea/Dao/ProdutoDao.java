package ProjetoSpringBea.Dao;

import ProjetoSpringBea.Connection.ConnectionFactory;
import ProjetoSpringBea.Domain.Produto;
import ProjetoSpringBea.Domain.VendaProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDao {

    public Produto getProdutoById(int idProduto) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement validProd = connection.prepareStatement("SELECT idProduto, nome, quantidade, preço FROM PRODUTO WHERE idProduto = ?");
            validProd.setInt(1, idProduto);
            validProd.executeQuery();
            ResultSet resultProduct = validProd.getResultSet();
            while (resultProduct.next()) {
                Produto produto = new Produto(idProduto,
                        resultProduct.getString("nome"),
                        resultProduct.getInt("quantidade"),
                        resultProduct.getInt("preço"));
                return produto;
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Produto updateQuantidade(int idProduto) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement updateQuantidadeProdutos = connection.prepareStatement("UPDATE PRODUTO SET quantidade = ? WHERE idProduto = ?");
            updateQuantidadeProdutos.setInt(1, (quantidadeProdutoAtual - vendaProduto.getQuantidade()));
            updateQuantidadeProdutos.setInt(2, vendaProduto.getIdProduto());

            updateQuantidadeProdutos.execute();

    } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }