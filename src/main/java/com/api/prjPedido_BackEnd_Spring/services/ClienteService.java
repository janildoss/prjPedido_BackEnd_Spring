package com.api.prjPedido_BackEnd_Spring.services;

import com.api.prjPedido_BackEnd_Spring.domain.Cliente;
import com.api.prjPedido_BackEnd_Spring.repositories.ClienteRepository;
import com.api.prjPedido_BackEnd_Spring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClienteService {
	
		@Autowired
		private ClienteRepository repo;

		//Tratamento para quando pesquisar categoria nao existente POR ID

		public Cliente buscar(Integer id) {
			Optional<Cliente> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
	
}
