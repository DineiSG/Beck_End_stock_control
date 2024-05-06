package com.autoshopping.stock_control.api.Veiculos;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.util.Optional;


@Entity
@Table(name = "veiculos")
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String placa;
    private String tag;
    private String loja;
    private String ano_fabricacao;
    private String cor;
    private String modelo;
    private String marca;

    public Veiculos(){
    }
    public Veiculos(Integer id, String tag, String loja, String placa, String ano_fabricacao, String cor, String modelo, String marca){
        this.id=id;
        this.tag=tag;
        this.loja=loja;
        this.placa=placa;
        this.ano_fabricacao=ano_fabricacao;
        this.cor=cor;
        this.modelo=modelo;
        this.marca=marca;
    }

    public static Optional<Object> findByPlaca(String placa) {

        return Optional.empty();
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(String ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public void save(Veiculos veiculo) {
    }

    public boolean isEmpty() {
        return false;
    }

    public Object get() {
        return null;
    }
}