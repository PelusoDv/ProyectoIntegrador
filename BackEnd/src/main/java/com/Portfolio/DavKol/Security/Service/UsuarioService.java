
package com.Portfolio.DavKol.Security.Service;

import com.Portfolio.DavKol.Security.Entity.Usuario;
import com.Portfolio.DavKol.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByUserName(String userName) {
        return iusuarioRepository.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName) {
        return iusuarioRepository.existsByUserName(userName);
    }
    
    public boolean existsbyEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario) {
        iusuarioRepository.save(usuario);
    }
}
