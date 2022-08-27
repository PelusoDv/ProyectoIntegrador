
package com.Portfolio.DavKol.Security.Repository;

import com.Portfolio.DavKol.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUserName(String userName); 
    
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
