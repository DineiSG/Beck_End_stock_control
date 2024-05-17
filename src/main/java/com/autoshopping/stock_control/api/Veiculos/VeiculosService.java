package com.autoshopping.stock_control.api.Veiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepository rep;
    private Iterable<Veiculos> optional;

    public Iterable<Veiculos> getVeiculosByLoja(String loja) {return rep.findByLoja(loja);}

    public Iterable<Veiculos> getVeiculosByMarca(String marca) {return rep.findByMarca(marca);}

    public Iterable<Veiculos> getVeiculosByModelo(String modelo) {return rep.findByModelo(modelo);}

    public Iterable<Veiculos> getVeiculos(){
        return rep.findAll();
    }

    Optional<Veiculos> getVeiculosById(Integer id) {return rep.findById(id);}

    public Optional<Veiculos> getVeiculosByPlaca(String placa) {return rep.getVeiculosByPlaca(placa); }




    /*Metodo para salvar um veículo*/
    public Veiculos insert(Veiculos veiculo) {
        return rep.save(veiculo);
    }

    /*Metodo para atualizar um veículo*/
    public Veiculos update(Veiculos veiculo, String placa){
        Optional<Veiculos>optional=getVeiculosByPlaca(placa);
        if(optional.isPresent()){
        Veiculos veiculos=optional.get();
            rep.save(veiculo);

            return veiculo;
        }else{
            throw new RuntimeException("Nao foi possivel atualizar o registro");
        }
    }

    /*Metodo para deletar um veículo*/
    public boolean delete(Integer id){
        if(getVeiculosById(id).isPresent()){
            rep.deleteById(String.valueOf(id));
            return true;
        }
        return false;
    }


}




	