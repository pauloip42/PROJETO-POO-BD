package com.api.organograma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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
}
