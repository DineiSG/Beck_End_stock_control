package com.autoshopping.stock_control.api.loja;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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


}
