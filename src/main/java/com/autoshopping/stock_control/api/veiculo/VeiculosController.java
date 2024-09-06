package com.autoshopping.stock_control.api.veiculo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
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

    // Buscando os dados da API do DENATRAN
    @GetMapping("/dados")
    public ResponseEntity<Map<String, Object>> getDados(@RequestParam String placa){
        HttpClient client=HttpClient.newHttpClient();

        String uri = "https://www.vistoriago.com.br/webservice/tp15/15BdvNacional.php?clie=7048&user=8001&cons=15&serial=c40d4850013e8351091314c7b29c4e&placa="+placa;

        HttpRequest request= HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody=response.body();

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap = objectMapper.readValue(responseBody, Map.class);

            return ResponseEntity.ok(jsonMap);

        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(500).body(Map.of("erro", "Erro ao obter dados para a placa: " +placa));
        }
    }

    @GetMapping("/unidade/{unidade}")
    public Iterable<Veiculos>getVeiculosByUnidade(@PathVariable("unidade")String unidade){
        return service.getVeiculosByUnidade(unidade);
    }

    @GetMapping("/modelo/{modelo}")
    public Iterable<Veiculos>getVeiculosByModelo(@PathVariable("modelo")String modelo){
        return service.getVeiculosByModelo(modelo);
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
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Veiculo atualizado com sucesso");
        response.put("veiculo", atualizarVeiculo);
        return ResponseEntity.ok(response);
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