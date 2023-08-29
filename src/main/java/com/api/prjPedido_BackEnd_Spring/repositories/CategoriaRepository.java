package com.api.prjPedido_BackEnd_Spring.repositories;

import com.api.prjPedido_BackEnd_Spring.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer > {

}
