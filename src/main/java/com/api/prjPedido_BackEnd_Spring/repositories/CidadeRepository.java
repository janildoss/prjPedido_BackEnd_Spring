package com.api.prjPedido_BackEnd_Spring.repositories;

import com.api.prjPedido_BackEnd_Spring.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
