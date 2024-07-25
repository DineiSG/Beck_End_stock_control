package com.autoshopping.stock_control.api.acesso;


import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface AcessosRepository extends CrudRepository<Acessos, Integer> {

    List<Acessos> findByIdVeiculoAcessante(Integer idVeiculoAcessante);
}
