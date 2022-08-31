package com.Portfolio.DavKol.Service;

import com.Portfolio.DavKol.Entity.Experiencia;
import com.Portfolio.DavKol.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    IExperienciaRepository iexperienciaRepository;
    
    public List<Experiencia> list(){
        return iexperienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id) {
        return iexperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE){
        return iexperienciaRepository.getByNombreE(nombreE);
    }
    
    public void save(Experiencia experiencia) {
        iexperienciaRepository.save(experiencia);
    }
        
    public void delete(int id) {
        iexperienciaRepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return iexperienciaRepository.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE) {
        return iexperienciaRepository.existsByNombreE(nombreE);
    }
}
