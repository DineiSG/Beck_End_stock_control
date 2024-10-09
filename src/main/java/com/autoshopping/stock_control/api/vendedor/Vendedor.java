package com.autoshopping.stock_control.api.vendedor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "vendedor", schema = "venda")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String unidade;
    @Column(name = "data_registro")
    private Timestamp dataRegistro;
}

