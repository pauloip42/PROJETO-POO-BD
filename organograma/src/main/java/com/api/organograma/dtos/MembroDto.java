package com.api.organograma.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MembroDto {

    @NotBlank
    @Size(max=30)
    private String nome;

    @NotBlank
    @Size(max = 30)
    private String email;

    @NotBlank
    @Size(max = 3)
    private String curso;

    @NotBlank
    @Size(max = 10)
    private String cargo;

    @NotNull
    private Integer nucleo;

    public Integer getNucleo() {
        return nucleo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setNucleo(Integer nucleo) {
        this.nucleo = nucleo;
    }
}
