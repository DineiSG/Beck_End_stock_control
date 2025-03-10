package com.autoshopping.stock_control.api.veiculo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "veiculo", schema = "vaga", uniqueConstraints = {@UniqueConstraint(name = "uk_placa__veiculo", columnNames = {"placa"})})

public class Veiculos extends RepresentationModel<Veiculos> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    @Column(name = "id_unidade")
    private Integer idUnidade ;
    private String ano;
    private String cor;
    private String modelo;
    private String marca;
    @Column(name="valor_meio_acesso") /*ALTERADO. TESTAR PARA VER SE NAO IRA INFLUENCIAR EM OUTRAS PARTES DO CODIGO NO FRONT END*/
    private String valorMeioAcesso;
    private String veiculo_status;
    private String unidade;
    private String renavan;
    private String observacoes;
    private Timestamp data_registro;
    private Timestamp data_alteracao;
    private String ano_modelo;
    private String tag;
    private String fipe;

    public void save(Veiculos veiculo) {
    }

    public boolean isEmpty() {
        return false;
    }

    public Object get() {
        return null;
    }

}