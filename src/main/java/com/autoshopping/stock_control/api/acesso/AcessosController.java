package com.autoshopping.stock_control.api.acesso;



import com.autoshopping.stock_control.api.veiculo.Veiculos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/acessos")
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
