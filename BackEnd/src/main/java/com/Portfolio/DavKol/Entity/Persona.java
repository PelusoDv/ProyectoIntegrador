
package com.Portfolio.DavKol.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(max = 24, message = "No cumple con la longitud")
    private String nombre;
    @NotNull
    @Size(max = 32, message = "No cumple con la longitud")
    private String apellido;
    @Size(min = 23, max = 510)
    private String img;
    @NotNull
    private String titulo;
    @NotNull
    private String residencia;
    @Size(min = 1, max = 240, message = "Max 240 caracteres")
    private String descripcion;
    private Long numero;
    private String email;
    
    //Constructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String titulo, String residencia, String descripcion,
            Long numero, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
        this.residencia = residencia;
        this.descripcion = descripcion;
        this.numero = numero;
        this.email = email;
    }
}
