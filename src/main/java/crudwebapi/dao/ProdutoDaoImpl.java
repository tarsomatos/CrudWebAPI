package crudwebapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import crudwebapi.domain.Produto;

public class ProdutoDaoImpl implements ProdutoDao {

	@PersistenceContext(unitName="CrudWebAPIPU")
	private EntityManager entity; 
	/* (non-Javadoc)
	 * @see crudwebapi.dao.ProdutoDao#obterProdutos()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> obterProdutos() {
		javax.persistence.Query query = entity.createQuery("from Produto");
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see crudwebapi.dao.ProdutoDao#salvarProduto(crudwebapi.domain.Produto)
	 */
	@Override
	public Produto salvarProduto(Produto produto) {
		entity.persist(produto);
		return produto;
	}

	/* (non-Javadoc)
	 * @see crudwebapi.dao.ProdutoDao#editarProduto(crudwebapi.domain.Produto)
	 */
	@Override
	public void editarProduto(Produto produto) {
		Produto produtoEditar = entity.merge(produto);
		entity.persist(produtoEditar);
	}

	/* (non-Javadoc)
	 * @see crudwebapi.dao.ProdutoDao#obterProduto(java.lang.Integer)
	 */
	@Override
	public Produto obterProduto(Integer codigoProduto) {
		return entity.getReference(Produto.class, codigoProduto);
	}

	/* (non-Javadoc)
	 * @see crudwebapi.dao.ProdutoDao#excluirProduto(crudwebapi.domain.Produto)
	 */
	@Override
	public void excluirProduto(Produto produto) {
		Produto produtoExcluirr = entity.merge(produto);
		entity.remove(produtoExcluirr);
		
	}

	
	
}
