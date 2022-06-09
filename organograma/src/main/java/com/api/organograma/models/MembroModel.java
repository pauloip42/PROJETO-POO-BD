package com.api.organograma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MEMBRO")
public class MembroModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}