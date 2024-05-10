package com.autoshopping.stock_control.api.Veiculos;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Data
@Entity
@Table(name = "veiculos")
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String placa;
    private String tag;
    private String loja;
    private String ano_fabricacao;
    private String cor;
    private String modelo;
    private String marca;





    public void save(Veiculos veiculo) {
    }

    public boolean isEmpty() {
        return false;
    }

    public Object get() {
        return null;
    }
}