package com.autoshopping.stock_control.api.acesso;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("api/v1/acessos")
public class AcessosController {


    @Autowired
    private AcessosService service;

    /*Buscando todos os registros de entrada e saida*/
    @GetMapping
    public ResponseEntity <Iterable<Acessos>> get(){return ResponseEntity.ok(service.getAcessos());}

    @GetMapping("/historico/{idVeiculoAcessante}")
    public ResponseEntity get(@PathVariable("idVeiculoAcessante") Integer idVeiculoAcessante){
        List<Acessos> acessos=service.getAcessosByIdVeiculoAcessante(idVeiculoAcessante);
        if(!acessos.isEmpty()){
            return ResponseEntity.ok(acessos);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
