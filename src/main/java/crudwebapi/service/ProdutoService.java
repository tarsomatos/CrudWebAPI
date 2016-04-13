package crudwebapi.service;

import java.util.List;

import crudwebapi.domain.Produto;

public interface ProdutoService {

	List<Produto> obterProdutos();

	Produto salvarProduto(Produto produto);

	void editarProduto(Produto produto);

	void excluirProduto(Integer codigoProduto);

	Produto obterProduto(Integer codigoProduto);

}