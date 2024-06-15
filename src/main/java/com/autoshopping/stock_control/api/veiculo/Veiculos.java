package com.autoshopping.stock_control.api.veiculo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@Entity
@Table(name = "veiculo", schema = "vaga", uniqueConstraints = {@UniqueConstraint(name = "uk_placa__veiculo", columnNames = {"placa"})})

public class Veiculos extends RepresentationModel<Veiculos> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    private Integer id_unidade;
    private String ano;
    private String cor;
    private String modelo;
    private String marca;
    private String valor_meio_acesso;
    private String veiculo_status;
    private String unidade;

    public void save(Veiculos veiculo) {
    }

    public boolean isEmpty() {
        return false;
    }

    public Object get() {
        return null;
    }
}