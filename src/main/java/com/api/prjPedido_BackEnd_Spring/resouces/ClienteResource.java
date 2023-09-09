package com.api.prjPedido_BackEnd_Spring.resouces;


import com.api.prjPedido_BackEnd_Spring.domain.Cliente;
import com.api.prjPedido_BackEnd_Spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    @Autowired
    private ClienteService service;

    //@RequestMapping(method= RequestMethod.GET )
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> listarCli(@PathVariable Integer id){
         Cliente obj = service.buscar(id);
          return ResponseEntity.ok().body(obj);
    }
}
