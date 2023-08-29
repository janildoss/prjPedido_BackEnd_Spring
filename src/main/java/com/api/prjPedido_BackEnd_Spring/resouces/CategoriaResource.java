package com.api.prjPedido_BackEnd_Spring.resouces;

import com.api.prjPedido_BackEnd_Spring.domain.Categoria;
import com.api.prjPedido_BackEnd_Spring.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService  service;
    //@RequestMapping(method= RequestMethod.GET )
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> listar(@PathVariable Integer id){
         Categoria obj = service.buscar(id);
          //return ResponseEntity.OK().body(obj);
          return ResponseEntity.ok().body(obj);
    }
}
