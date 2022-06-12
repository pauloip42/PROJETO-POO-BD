package com.api.organograma.dtos;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class NucleoDto {

    @NotBlank
    private String nome;

    @NotBlank
    @Size(max=5)
    private String sigla;

    @NotBlank
    @Size(max=30)
    private String area;

}
