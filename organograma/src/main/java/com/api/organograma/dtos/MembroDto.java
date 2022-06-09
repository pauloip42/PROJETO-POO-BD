package com.api.organograma.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MembroDto {

    @NotBlank
    @Size(max=30)
    private String nome;

    @NotBlank
    @Size(max = 30)
    private String email;

    @NotBlank
    @Size(max = 3)
    private String curso;

    @NotBlank
    @Size(max = 10)
    private String cargo;
}
