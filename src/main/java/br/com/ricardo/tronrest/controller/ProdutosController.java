package br.com.ricardo.tronrest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardo.tronrest.model.Produto;
import br.com.ricardo.tronrest.repository.ProdutoRepository;

@RestController
public class ProdutosController {
	
	
	  @Autowired
	  private ProdutoRepository produtoRepository;
	  
	  @RequestMapping(value= "/produtos",method = RequestMethod.GET) 
	  public List<Produto> listar() { 
		  
		  return produtoRepository.findAll(); 
	  }
	  
	  @RequestMapping(value= "/produtos/{id}",method = RequestMethod.GET) 
	  public Optional<Produto> findById(@PathVariable("id") Long id) { 
		  
		  return produtoRepository.findById(id); 
	  }
	  
	  @RequestMapping(value = "/produtos/novo", method = RequestMethod.POST) 
	  public Produto post(@Valid @RequestBody Produto produto ) { 
		  return produtoRepository.save(produto); 
	  }
	 
	
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletar(@PathVariable(value = "id") Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
			if(produto.isPresent()) {
				produtoRepository.delete(produto.get());
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
	 }

	@RequestMapping(value = "produtos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> editar(@PathVariable(value = "id")Long id, @Valid @RequestBody Produto produto) {
		
		Optional<Produto> oldProduto = produtoRepository.findById(id);
		if(oldProduto.isPresent()) {
			produto.setId(id);
			produtoRepository.save(produto);
			return new ResponseEntity<>(produto, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
