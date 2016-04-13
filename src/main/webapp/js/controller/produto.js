var moduloProduto = angular.module('moduloProduto',[]);

moduloProduto.controller('controleProduto',function($scope,$http) {

	// Variaveis Locais
	urlRestProduto = "/CrudWebAPI/rest/produto";
	 
	// Listagem de Produtos
	$scope.carregarProdutos = function() {
		//CHAMAR REST @GET
		$http.get(urlRestProduto).success(function(produtos) { 
			$scope.produtoListagem = produtos;
		}).error(function (error) {
			alert(error)
		});
	};
	
	// Selecionar Produto
	$scope.selecionarProduto = function(produto) {
			$scope.produto = produto;
			$('.inserir-produto').css('display','none')
			$('.editar-produto').css('display','block')
	};
	
	// Excluir Produto
	$scope.excluirProduto = function(produto) {
		// URL para DELETE
		urlRestExcluirProduto = urlRestProduto + "/" + produto.codigo;
		// CHAMAR REST @DELETE
		$http.delete(urlRestExcluirProduto).success(function() {
			$scope.carregarProdutos();
			$scope.novoProduto();
		}).error(function (error) {
			alert(error)
		});
		
		//$scope.produtoListagem.splice($scope.produtoListagem.indexOf(produto),1);
	};	
	
	// Salvar Produto
	$scope.salvarProduto = function() {
		if ($scope.produtoListagem.indexOf($scope.produto) == -1) {
			//CHAMAR REST @POST
			$http.post(urlRestProduto,$scope.produto).success(function(produto) {	
				$scope.novoProduto();
				$scope.carregarProdutos();
			}).error(function(error) {
				alert(error);
			});
				
		}
	};	
	
	$scope.editarProduto = function() {
			//CHAMAR REST @PUT
			$http.put(urlRestProduto,$scope.produto).success(function(produto) {	
				$scope.novoProduto();
				$scope.carregarProdutos();
			}).error(function(error) {
				alert(error);
			});
	};	
	
	// Novo Produto (Limpar Formulario)
	$scope.novoProduto = function() {
		$scope.produto = "";
		$('.inserir-produto').css('display','block')
		$('.editar-produto').css('display','none')
	};	
	
	// Carregar Dados
	$scope.carregarProdutos();
	
	
});