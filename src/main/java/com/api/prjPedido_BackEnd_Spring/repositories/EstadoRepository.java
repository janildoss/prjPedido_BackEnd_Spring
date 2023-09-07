package com.api.prjPedido_BackEnd_Spring.repositories;

import com.api.prjPedido_BackEnd_Spring.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
