package com.autoshopping.stock_control.api;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VeiculosRepository extends CrudRepository<Veiculos, String>{




	Iterable<Veiculos> getVeiculosByLoja(String loja);

	Iterable<Veiculos> getVeiculosByMarca(String marca);

	Iterable<Veiculos> getVeiculosByModelo(String modelo);

	Optional<Veiculos> getVeiculosByPlaca(String placa);

	Optional<Veiculos> findById(Integer id);


};
