
package com.Portfolio.DavKol.Service;

import com.Portfolio.DavKol.Entity.Persona;
import com.Portfolio.DavKol.Repository.IPersonaRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {
    @Autowired
    IPersonaRepository ipersonaRepository;

    public void save(Persona persona) {
        ipersonaRepository.save(persona);
    }

    public void delete(int id) {
        ipersonaRepository.deleteById(id);
    }

    public Optional<Persona> findPersona(int id) {
        return ipersonaRepository.findById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return ipersonaRepository.existsByTitulo(titulo);
    }
    
    public Optional<Persona> getByTitulo(String titulo){
        return ipersonaRepository.getByTitulo(titulo);
    }
}
