package com.api.prjPedido_BackEnd_Spring;

import com.api.prjPedido_BackEnd_Spring.domain.Categoria;
import com.api.prjPedido_BackEnd_Spring.domain.Produto;
import com.api.prjPedido_BackEnd_Spring.repositories.CategoriaRepository;
import com.api.prjPedido_BackEnd_Spring.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController

@SpringBootApplication
public class PrjPedidoBackEndSpringApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository  produtoRepository;
	public static void main(String[] args) {SpringApplication.run(PrjPedidoBackEndSpringApplication.class, args);	}
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");


		Produto p1 = new Produto(null, "Computador",2000.00 );
		Produto p2 = new Produto(null, "Impressora",800.00 );
		Produto p3 = new Produto(null, "Mouse",80.00 );
		//categoria conhece seus produtos
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList( p2));
		//produtos conhece suas categorias
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository .saveAll(Arrays.asList(p1, p2, p3));

	}
}
