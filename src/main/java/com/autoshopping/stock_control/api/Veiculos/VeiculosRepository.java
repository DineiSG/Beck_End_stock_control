package com.autoshopping.stock_control.api.Veiculos;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VeiculosRepository extends CrudRepository<Veiculos, String>{


	static Optional<Object> findByPlaca(String placa) {
        return Optional.empty();
    }

	Iterable<Veiculos> getVeiculosByLoja(String loja);

	Iterable<Veiculos> getVeiculosByMarca(String marca);

	Iterable<Veiculos> getVeiculosByModelo(String modelo);

	Optional<Veiculos> getVeiculosByPlaca(String placa);

};
