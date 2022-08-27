
package com.Portfolio.DavKol.Security.Service;

import com.Portfolio.DavKol.Security.Entity.Rol;
import com.Portfolio.DavKol.Security.Enums.RolName;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Portfolio.DavKol.Security.Repository.IRolRepository;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolName(RolName rolName) {
        return irolRepository.findByRolName(rolName);
    }
    
    public void save(Rol rol) {
        irolRepository.save(rol);
    }
}
