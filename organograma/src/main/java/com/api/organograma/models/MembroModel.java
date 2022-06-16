package com.api.organograma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MEMBRO")
public class MembroModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 30)
    private String nome;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, length = 3)
    private String curso;

    @Column(nullable = false, length = 10)
    private String cargo;

    @JsonIgnore
    @ManyToMany(mappedBy = "membro")
    private Set<ProjetoModel> projetos = new HashSet<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nucleo_id", referencedColumnName = "id")
    private NucleoModel nucleo;

    public NucleoModel getNucleo() {
        return nucleo;
    }

    public void registerNucleo(NucleoModel nucleo) {
        this.nucleo = nucleo;
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

    public Set<ProjetoModel> getProjetos() {
        return projetos;
    }

    public void setProjetos(Set<ProjetoModel> projetos) {
        this.projetos = projetos;
    }

    public void setNucleo(NucleoModel nucleo) {
        this.nucleo = nucleo;
    }
}