package com.autoshopping.stock_control.api.venda;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "veiculo", schema = "venda")
public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String unidade;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private String renavam;
    private String vendedor;
    private String comprador;
    private String nascimento;
    private String telefone;
    private String cep;
    private String rua;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String email;
    private String cpf;
    private String rg;
    @Column(name = "valor_venda")
    private String valorVenda;
    @Column(name = "valor_fipe")
    private String valorFipe;
    @Column(name = "valor_entrada")
    private String valorEntrada;
    @Column(name = "valor_financiamento")
    private String valorFinanciamento;
    @Column(name = "tipo_venda")
    private String tipoVenda;
    private String instituicao;
    private String observacoes;
    @Column(name = "data_registro")
    private Timestamp dataRegistro;
}
