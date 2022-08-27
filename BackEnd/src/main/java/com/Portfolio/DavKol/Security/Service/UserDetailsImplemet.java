
package com.Portfolio.DavKol.Security.Service;

import com.Portfolio.DavKol.Security.Entity.Usuario;
import com.Portfolio.DavKol.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImplemet implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Usuario usuario = usuarioService.getByUserName(userName).get();
       return UsuarioPrincipal.build(usuario);
    }
}
