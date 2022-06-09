package com.api.organograma.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;

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

//    @OneToOne
//    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
//    private ClienteModel cliente_id;
}
