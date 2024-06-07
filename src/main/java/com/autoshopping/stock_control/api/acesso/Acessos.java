package com.autoshopping.stock_control.api.acesso;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "movimentacao_veiculo", schema = "acesso", uniqueConstraints = {
        @UniqueConstraint(name = "uk_data_movimentacao_veiculo_acessante_destino__movimentacao_veiculo",
        columnNames = {"data_movimentacao", "id_veiculo_acessante", "id_unidade_destino"})})
public class Acessos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp data_alteracao;
    private Timestamp data_registro;
    private Timestamp data_movimentacao;
    private String meio_acesso;
    private String sentido;
    private Integer id_unidade_destino;
    private Integer id_equipamento_acesso;
    private Integer id_veiculo_acessante;
}
