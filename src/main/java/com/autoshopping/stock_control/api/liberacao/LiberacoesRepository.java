package com.autoshopping.stock_control.api.liberacao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LiberacoesRepository extends CrudRepository<Liberacoes, String> {

    Optional<Liberacoes> getLiberacoesByPlaca(String placa);
}
