package com.autoshopping.stock_control.api.acesso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AcessosService {

    @Autowired
    private AcessosRepository rep;

    public Iterable<Acessos> getAcessos(){return rep.findAll(); }

}
