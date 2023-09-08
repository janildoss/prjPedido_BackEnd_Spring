package com.api.prjPedido_BackEnd_Spring;

import com.api.prjPedido_BackEnd_Spring.domain.*;
import com.api.prjPedido_BackEnd_Spring.domain.enums.TipoCliente;
import com.api.prjPedido_BackEnd_Spring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController

@SpringBootApplication
public class PrjPedidoBackEndSpringApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository  produtoRepository;

	@Autowired
	EstadoRepository  estadoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;

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

		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "São paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1 );
		Cidade c2 = new Cidade(null,"Sao Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente (null,"Maria Silva", "maria@gmail.com","36378912377", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("27330323","36744487"));
        Endereco e1 = new Endereco(null,"Rua Flores","300","Apto 303", "Jardim", "38220834",cli1,c1);
        Endereco e2 = new Endereco(null,"Avenida Matos","380","Sala 804", "Centro", "58220444",cli1,c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
    }
}
