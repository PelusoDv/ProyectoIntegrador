package com.Portfolio.DavKol.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido; 
    private String img;
    @NotBlank
    private String titulo;
    @NotBlank
    private String residencia;
    private String descripcion;
    private Long numero;
    private String email;
}
