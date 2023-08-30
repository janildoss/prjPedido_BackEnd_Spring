package com.api.prjPedido_BackEnd_Spring;

import com.api.prjPedido_BackEnd_Spring.domain.Categoria;
import com.api.prjPedido_BackEnd_Spring.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController

@SpringBootApplication
public class PrjPedidoBackEndSpringApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(PrjPedidoBackEndSpringApplication.class, args);	}
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));

	}
}
