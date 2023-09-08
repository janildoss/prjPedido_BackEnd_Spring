package com.api.prjPedido_BackEnd_Spring.repositories;

import com.api.prjPedido_BackEnd_Spring.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer > {

}
