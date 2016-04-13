package crudwebapi.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import crudwebapi.domain.Produto;
import crudwebapi.service.ProdutoService;



@Path("/produto")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoRestService {

	@Inject
	private ProdutoService produtoSVC;
	
    @GET
    public List<Produto> obterProdutos() {
        return produtoSVC.obterProdutos();
    }
	
    @POST
    public Produto salvarProduto(Produto produto) {
    	return produtoSVC.salvarProduto(produto);
    }
    
    @PUT
    public void editarProduto(Produto produto) {
    	produtoSVC.editarProduto(produto);
    }
    
    @DELETE
    @Path("/{codigoProduto}")
    public void excluirProduto(@PathParam("codigoProduto") Integer codigoProduto) {
    	produtoSVC.excluirProduto(codigoProduto);
    }
    
}
