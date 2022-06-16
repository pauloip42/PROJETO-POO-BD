package com.api.organograma.dtos;

import javax.validation.constraints.Size;

public class NucleoDto {

    private String nome;

    @Size(max=5)
    private String sigla;

    @Size(max=30)
    private String area;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
