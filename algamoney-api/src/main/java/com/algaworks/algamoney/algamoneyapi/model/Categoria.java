package com.algaworks.algamoney.algamoneyapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Categoria
 */
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;

    public Categoria() {
    }

    public Categoria(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria codigo(Long codigo) {
        this.codigo = codigo;
        return this;
    }

    public Categoria nome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " codigo='" + getCodigo() + "'" + ", nome='" + getNome() + "'" + "}";
    }

}