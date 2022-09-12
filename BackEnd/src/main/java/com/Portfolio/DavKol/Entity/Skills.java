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
