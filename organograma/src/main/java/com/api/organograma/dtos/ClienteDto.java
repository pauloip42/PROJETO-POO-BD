package com.api.organograma.dtos;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClienteDto {

    @NotBlank
    private String nomeEmpresa;

    @NotBlank
    private String responsavel;

    @NotBlank
    @Size(max=12)
    private String telefone;

    @NotBlank
    @Size(max=30)
    private String email;

    @NotBlank
    @Size(max=14)
    private String cnpj;
}
