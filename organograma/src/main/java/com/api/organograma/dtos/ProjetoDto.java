package com.api.organograma.dtos;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class ProjetoDto {
    @NotNull
    private Integer cliente;

    @NotNull
    private Integer membro;

    @NotBlank
    private String nome;

    @NotBlank
    private String status;

    @NotBlank
    private Double preco;

    private Integer id;
}
