
package com.Portfolio.DavKol.Service;

import com.Portfolio.DavKol.Entity.Persona;
import com.Portfolio.DavKol.Repository.IPersonaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {
    @Autowired
    IPersonaRepository ipersonaRepository;

    public List<Persona> list() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    public void save(Persona persona) {
        ipersonaRepository.save(persona);
    }

    public void delete(int id) {
        ipersonaRepository.deleteById(id);
    }

    public Persona findPersona(int id) {
        return ipersonaRepository.findById(id).orElse(null);
    }
    
}
