package com.api.organograma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NUCLEO")
public class NucleoModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, length = 5, unique = true)
    private String sigla;

    @Column(nullable = false, unique = true)
    private String area;

    @JsonIgnore
    @OneToMany(mappedBy = "nucleo")
    private Set<MembroModel> membros = new HashSet<>();

    public Set<MembroModel> getMembros() {
        return membros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public void setMembros(Set<MembroModel> membros) {
        this.membros = membros;
    }
}
