package br.com.ricardo.tronrest.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.ricardo.tronrest.controller.ProdutosController;
import br.com.ricardo.tronrest.model.Produto;
import br.com.ricardo.tronrest.repository.ProdutoRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {ProdutoRepository.class})
@EntityScan(basePackageClasses = {Produto.class})
@ComponentScan(basePackageClasses = {ProdutosController.class})
public class TronrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TronrestApplication.class, args);
	}

}
