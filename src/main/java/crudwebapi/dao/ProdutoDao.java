package crudwebapi.dao;

import java.util.List;

import crudwebapi.domain.Produto;

public interface ProdutoDao {

	List<Produto> obterProdutos();

	Produto salvarProduto(Produto produto);

	void editarProduto(Produto produto);

	Produto obterProduto(Integer codigoProduto);

	void excluirProduto(Produto produto);

}