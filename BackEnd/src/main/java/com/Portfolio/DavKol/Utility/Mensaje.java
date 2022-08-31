package com.Portfolio.DavKol.Utility;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mensaje {

    private String mensaje;

    //Constructores
    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
