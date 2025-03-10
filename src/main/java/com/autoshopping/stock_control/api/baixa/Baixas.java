package com.autoshopping.stock_control.api.baixa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "baixas", schema = "vaga")
public class Baixas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private String renavan;
    private String unidade;
    private String motivo;
    @Column(name = "data_registro")
    private Timestamp dataRegistro;
    private String tag;
    private String observacoes;
}