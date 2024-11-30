package com.autoshopping.stock_control.api.acesso;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AcessosRepository extends CrudRepository<Acessos, Integer> {

    List<Acessos> findByIdVeiculoAcessante(Integer idVeiculoAcessante);


    void deleteByIdVeiculoAcessante(Integer idVeiculoAcessante);
}

