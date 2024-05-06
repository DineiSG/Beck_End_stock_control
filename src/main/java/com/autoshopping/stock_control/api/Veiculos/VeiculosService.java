package com.autoshopping.stock_control.api.Veiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepository rep;
    private Iterable<Veiculos> optional;


    public Iterable<Veiculos> getVeiculos(){
        return rep.findAll();
    }


    public Iterable<Veiculos> getVeiculosByLoja(String loja) {
        return rep.getVeiculosByLoja(loja);
    }
    public Iterable<Veiculos> getVeiculosByMarca(String marca) {
        return rep.getVeiculosByMarca(marca);
    }
    public Iterable<Veiculos> getVeiculosByModelo(String modelo) {
        return rep.getVeiculosByModelo(modelo);
    }
    public Optional<Veiculos> getVeiculosByPlaca(String placa) {
        return rep.getVeiculosByPlaca(placa);
    }

    /*Metodo para salvar um veículo*/
    public Veiculos insert(Veiculos veiculo) {
        return rep.save(veiculo);
    }
    public Veiculos update(Veiculos veiculo, String placa){
        Optional<Veiculos>optional=getVeiculosByPlaca(placa);
        if(optional.isPresent()){
        Veiculos veiculos=optional.get();


            veiculo.setId(veiculo.getId());
            veiculo.setTag(veiculo.getTag());
            veiculo.setLoja(veiculo.getLoja());
            veiculo.setPlaca(veiculo.getPlaca());
            veiculo.setAno_fabricacao(veiculo.getAno_fabricacao());
            veiculo.setCor(veiculo.getCor());
            veiculo.setMarca(veiculo.getMarca());
            veiculo.setModelo(veiculo.getModelo());
            rep.save(veiculo);

            return veiculo;
        }else{
            throw new RuntimeException("Nao foi possivel atualizar o registro");
        }
    }
}




	