package com.autoshopping.stock_control.api.Lojas;


import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface LojasRepository extends CrudRepository<Lojas, String> {




    Optional<Lojas> getLojasById(Integer id);
}
