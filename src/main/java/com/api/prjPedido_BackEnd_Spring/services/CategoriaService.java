package com.api.prjPedido_BackEnd_Spring.services;

import com.api.prjPedido_BackEnd_Spring.domain.Categoria;
import com.api.prjPedido_BackEnd_Spring.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id){
       Optional<Categoria> obj = repo.findById(id);
        return obj.orElse(null);
    }
}
