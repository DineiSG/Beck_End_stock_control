package com.autoshopping.stock_control.api.veiculo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VeiculosRepository extends CrudRepository<Veiculos, String>{

	Optional<Veiculos> getVeiculosByPlaca(String placa);

	Optional<Veiculos> findById(Integer id);

	Iterable<Veiculos> findByMarca(String marca);

	Iterable<Veiculos> findByModelo(String modelo);
};
