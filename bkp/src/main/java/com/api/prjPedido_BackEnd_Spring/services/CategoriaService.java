package com.api.prjPedido_BackEnd_Spring.services;

import java.util.Optional;

import com.api.prjPedido_BackEnd_Spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.prjPedido_BackEnd_Spring.domain.Categoria;
import com.api.prjPedido_BackEnd_Spring.repositories.CategoriaRepository;
import java.lang.Throwable;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
    	Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ",  Tipo: " , Categoria.class.getName()));
//Categoria.class.getName()
    }

}
