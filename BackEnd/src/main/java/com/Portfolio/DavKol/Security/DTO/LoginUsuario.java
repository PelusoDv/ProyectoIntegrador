
package com.Portfolio.DavKol.Security.DTO;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    
    //Getters & Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
