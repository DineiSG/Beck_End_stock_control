package com.autoshopping.stock_control.api.acesso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class AcessosService {

    @Autowired
    private AcessosRepository rep;

    public Iterable<Acessos> getAcessos(){return rep.findAll(); }

    public List<Acessos> getAcessosByIdVeiculoAcessante(Integer idVeiculoAcessante) {
        return rep.findByIdVeiculoAcessante(idVeiculoAcessante);
    }

    @Transactional
    public boolean delete(Integer idVeiculoAcessante) {
        if(rep.existsById(idVeiculoAcessante)){
            rep.deleteByIdVeiculoAcessante(idVeiculoAcessante);
            return true;
        }
        return false;
    }
}
