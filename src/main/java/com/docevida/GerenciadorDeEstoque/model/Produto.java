package com.docevida.GerenciadorDeEstoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private Integer quantidade;
    private BigDecimal precoCompra;
    private BigDecimal precoVenda;

    @Override
    public String toString() {
        return nome + " (ID: " + id + ")";
    }
}
