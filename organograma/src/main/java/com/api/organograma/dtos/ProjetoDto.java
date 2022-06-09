package com.api.organograma.dtos;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProjetoDto {
    @NotNull
    private Integer cliente;

    @NotBlank
    private String nome;

    @NotBlank
    private String status;

    @NotBlank
    private String preco;
}
