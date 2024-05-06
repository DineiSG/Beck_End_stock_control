package com.autoshopping.stock_control.api.Veiculos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculosController {

    @Autowired
    VeiculosRepository veiculosRepository;

    @Autowired
    private VeiculosService service;

    /*Buscando todos os veiculos do banco de dados*/
    @GetMapping
    public Iterable<Veiculos>get(){
        return service.getVeiculos();
    }

    /*Buscando os veiculos de acordo com criterios*/
    @GetMapping("/loja/{loja}")
    public Iterable<Veiculos>getVeiculosByLoja(@PathVariable("loja")String loja){
        return service.getVeiculosByLoja(loja);
    }
    @GetMapping("/marca/{marca}")
    public Iterable<Veiculos>getVeiculosByMarca(@PathVariable("marca")String marca){
        return service.getVeiculosByMarca(marca);
    }
    @GetMapping("/modelo/{modelo}")
    public Iterable<Veiculos>getVeiculosByModelo(@PathVariable("modelo")String modelo){
        return service.getVeiculosByModelo(modelo);
    }
    /*Esse metodo foi criado para auxiliar na fuunção de atualizar um veiculo */
    @GetMapping("/placa/{placa}")
    public Optional<Veiculos> getVeiculosByPlaca(@PathVariable("placa")String placa){
        return service.getVeiculosByPlaca(placa);
    }

    /*Cadastrando novos veiculos*/
    @PostMapping
    public String post (@RequestBody Veiculos veiculo) {
        Veiculos novo=service.insert(veiculo);
        return "Veiculo cadastrado com sucesso: " +novo.getPlaca();
    }

    /*Atualizando um veículo*/
    @PutMapping(path="/placa/{placa}")
    public String put(@PathVariable("placa") String placa, @RequestBody Veiculos veiculo){
        Veiculos atualizarVeiculo=service.update(veiculo, placa);
        return "Carro atualizado com sucesso: " +atualizarVeiculo.getPlaca();
    }
    /*Deletando um veículo*/




}