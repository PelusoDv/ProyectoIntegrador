package com.Portfolio.DavKol.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String descripcionP;
    @Size(max = 510)
    private String imgP;
    @Size(max = 510)
    private String linkP;
    
    //Constructores 
    public Proyectos() {
    }

    public Proyectos(String nombreP, String descripcionP, String imgP, String linkP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
        this.linkP = linkP;
    }
    
}
