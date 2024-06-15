package com.autoshopping.stock_control.api.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/lojas")
public class LojasController {

    @Autowired
    private LojasService service;


    @GetMapping
    public ResponseEntity<Iterable<Lojas>> get(){return ResponseEntity.ok(service.getLojas());}

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Integer id){
        Optional<Lojas> loja=service.getLojasById(id);
        return loja
                .map(Lojas -> ResponseEntity.ok(loja))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/descricao/{descricao}")
    public ResponseEntity getgetLojasByDescricao(@PathVariable("descricao") String descricao){
        Optional<Lojas> loja=service.getLojasByDescricao(descricao);
        return loja
                .map(Lojas -> ResponseEntity.ok(loja))
                .orElse(ResponseEntity.notFound().build());
    }


    /*Adicionando uma nova loja*/
    @PostMapping
    public ResponseEntity post (@RequestBody Lojas loja) {
        Lojas novaLoja=service.insert(loja);
        return ResponseEntity.ok("Nova loja cadastrada com sucesso. " +novaLoja);
    }

    /*Atualizando uma loja*/
    @PutMapping(path="/{id}")
    public ResponseEntity put(@PathVariable("id") Integer id, @RequestBody Lojas loja){
        Lojas atualizarLojas=service.update(loja, id);
        return ResponseEntity.ok("Loja atualizada com sucesso. "+atualizarLojas);
    }

    /*Deletando uma loja*/
    @DeleteMapping(path="{id}")
    public ResponseEntity delete (@PathVariable("id") Integer id){
        boolean ok=service.delete(id);
        return ok?
                ResponseEntity.ok("Loja excluida com sucesso"):
                ResponseEntity.notFound().build();

    }
}
