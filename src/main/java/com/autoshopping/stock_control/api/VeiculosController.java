package com.autoshopping.stock_control.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculosController {

    @Autowired
    private VeiculosService service;

    /*Buscando todos os veiculos do banco de dados*/
    @GetMapping
    public ResponseEntity<Iterable<Veiculos>> get(){
        return ResponseEntity.ok(service.getVeiculos());
    }

    /*Buscando os veiculos de acordo com criterios*/

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Integer id){
        Optional<Veiculos> veiculos=service.getVeiculosById(id);
        return veiculos
                .map(Veiculos -> ResponseEntity.ok(veiculos))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/loja/{loja}")
    public ResponseEntity getVeiculosByLoja(@PathVariable("loja")String loja){
        Optional<Veiculos> veiculos=service.getVeiculosByLoja();
        return veiculos
                .map(Veiculos -> ResponseEntity.ok(veiculos))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity getVeiculosByMarca(@PathVariable("marca")String marca){
        Optional<Veiculos> veiculos=service.getVeiculosByMarca();
        return veiculos
                .map(Veiculos -> ResponseEntity.ok(veiculos))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/modelo/{modelo}")
    public ResponseEntity getVeiculosByModelo(@PathVariable("modelo")String modelo){
        Optional<Veiculos>veiculos=service.getVeiculosByModelo();
        return veiculos
                .map(Veiculos -> ResponseEntity.ok(veiculos))
                .orElse(ResponseEntity.notFound().build());

    }

    /*Esse metodo foi criado para auxiliar na fuunção de atualizar um veiculo */
    @GetMapping("/placa/{placa}")
    public ResponseEntity getVeiculosByPlaca(@PathVariable("placa")String placa){
            Optional<Veiculos>veiculos=service.getVeiculosByPlaca(placa);
        return veiculos
                .map(Veiculos -> ResponseEntity.ok(veiculos))
                .orElse(ResponseEntity.notFound().build());
    }

    /*Cadastrando novos veiculos*/
    @PostMapping
    public ResponseEntity post (@RequestBody Veiculos veiculo) {
        Veiculos novo=service.insert(veiculo);
        return ResponseEntity.ok("Veiculo adicionado com sucesso");
    }

    /*Atualizando um veículo*/
    @PutMapping(path="/placa/{placa}")
    public ResponseEntity put(@PathVariable("placa") String placa, @RequestBody Veiculos veiculo){
        Veiculos atualizarVeiculo=service.update(veiculo, placa);
        return ResponseEntity.ok("Veiculo atualizado com sucesso");
    }

    /*Deletando um veículo*/
    @DeleteMapping(path="{id}")
    public ResponseEntity delete (@PathVariable("id") Integer id){
        boolean ok=service.delete(id);
        return ok?
            ResponseEntity.ok("Veiculo excluido com sucesso"):
            ResponseEntity.notFound().build();

    }

}