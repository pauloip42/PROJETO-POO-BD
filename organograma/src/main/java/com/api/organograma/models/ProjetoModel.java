package com.api.organograma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROJETO")
public class ProjetoModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Double preco;

    @OneToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private ClienteModel cliente;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "projeto_membro",
        joinColumns = @JoinColumn(name = "projeto_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "membro_id", referencedColumnName = "id"))
    private Set<MembroModel> membro = new HashSet<>();

    public void addMembro(MembroModel membro) {
        this.membro.add(membro);
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

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Set<MembroModel> getMembro() {
        return membro;
    }

    public void setMembro(Set<MembroModel> membro) {
        this.membro = membro;
    }
}
