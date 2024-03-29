package ProjetoSpringBea.Service;

import ProjetoSpringBea.Dao.ProdutoDao;
import ProjetoSpringBea.Domain.Produto;

public class ProdutoService {
    public ProdutoDao produtoDao = new ProdutoDao();

    public Produto getProdutoById(int idProduto) {
        return produtoDao.getProdutoById(idProduto);
    }

    public void updateQuantidadeProduto(Produto produto, int quantidade) {
        produtoDao.updateQuantidadeProduto(produto, quantidade);
}
}
