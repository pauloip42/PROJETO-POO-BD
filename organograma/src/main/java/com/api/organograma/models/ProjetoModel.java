package com.api.organograma.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PROJETO")
public class ProjetoModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String preco;

    @OneToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private ClienteModel cliente;

    @ManyToMany
    @JoinTable(name = "projeto_membro",
        joinColumns = @JoinColumn(name = "projeto_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "membro_id", referencedColumnName = "id"))
    private Set<MembroModel> membro = new HashSet<>();


    public void addMembro(MembroModel membro) {
        this.membro.add(membro);
    }
}
