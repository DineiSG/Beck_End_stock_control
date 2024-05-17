package com.autoshopping.stock_control.api.Lojas;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="lojas")
public class Lojas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome_loja;
    private String box;
    private String telefone;
    private String email;
    private String vagas;


}
