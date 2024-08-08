package com.autoshopping.stock_control.api.liberacao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "liberacoes", schema = "vaga")
public class Liberacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String unidade;
    private String solicitante ;
    private String motivo;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private String observacoes;

    @Column(name = "data_registro")
    private Timestamp dataRegistro;



}

