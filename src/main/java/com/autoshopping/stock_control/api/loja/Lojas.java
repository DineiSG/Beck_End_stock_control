package com.autoshopping.stock_control.api.loja;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "unidade", schema = "unidade")
public class Lojas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String descricao;
    private Integer box;
    private String telefone;
    private String email;
    private String vagas;
    @Column(name = "data_registro")
    private Timestamp dataRegistro;
    @Column(name = "qtd_veiculos")
    private String qtdVeiculos;


}
