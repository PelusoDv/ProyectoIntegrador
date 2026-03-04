package com.Portfolio.DavKol.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreS;
    private Integer percent;
    
    //Constructores
    public Skills() {
    }

    public Skills(String nombreS, Integer percent) {
        this.nombreS = nombreS;
        this.percent = percent;
    }
}
