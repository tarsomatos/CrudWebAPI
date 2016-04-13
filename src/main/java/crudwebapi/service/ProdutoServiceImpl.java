package crudwebapi.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import crudwebapi.dao.ProdutoDao;
import crudwebapi.domain.Produto;

public class ProdutoServiceImpl implements ProdutoService {

	@Inject
	private ProdutoDao produtoDao;
	
	
	/* (non-Javadoc)
	 * @see crudwebapi.service.ProdutoService#obterProdutos()
	 */
	@Override
	public List<Produto> obterProdutos() {
		return produtoDao.obterProdutos();
	}
	
	/* (non-Javadoc)
	 * @see crudwebapi.service.ProdutoService#salvarProdutos(crudwebapi.domain.Produto)
	 */
	@Override
	@Transactional
	public Produto salvarProduto(Produto produto) {
		return produtoDao.salvarProduto(produto);
	}
	
	/* (non-Javadoc)
	 * @see crudwebapi.service.ProdutoService#editarProdutos(crudwebapi.domain.Produto)
	 */
	@Override
	@Transactional
	public void editarProduto(Produto produto) {
		 produtoDao.editarProduto(produto);
	}

	/* (non-Javadoc)
	 * @see crudwebapi.service.ProdutoService#excluirProdutos(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void excluirProduto(Integer codigoProduto) {
		Produto produto = produtoDao.obterProduto(codigoProduto);
		produtoDao.excluirProduto(produto);
	}
	
	
	/* (non-Javadoc)
	 * @see crudwebapi.service.ProdutoService#obterProduto(java.lang.Integer)
	 */
	@Override
	public Produto obterProduto(Integer codigoProduto) {
		return produtoDao.obterProduto(codigoProduto);
	}
	
}
