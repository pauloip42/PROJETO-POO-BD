package com.api.organograma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CLIENTE")
public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true, length = 30)
    private String responsavel;

    @Column(nullable = false, unique = true, length = 30)
    private String nomeEmpresa;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, unique = true, length = 12)
    private String telefone;

    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

    @JsonIgnore
    @OneToOne(mappedBy = "cliente")
    private ProjetoModel projeto;
}