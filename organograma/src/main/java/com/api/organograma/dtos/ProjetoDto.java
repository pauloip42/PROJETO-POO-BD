package com.api.organograma.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProjetoDto {
    @NotNull
    private Integer cliente;

    @NotNull
    private Integer membro;

    @NotBlank
    private String nome;

    @NotBlank
    private String status;

    @NotNull
    private Double preco;

    private Integer id;

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getMembro() {
        return membro;
    }

    public void setMembro(Integer membro) {
        this.membro = membro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
