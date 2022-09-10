package com.Portfolio.DavKol.Service;

import com.Portfolio.DavKol.Entity.Proyectos;
import com.Portfolio.DavKol.Repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {
    @Autowired
    IProyectosRepository iproyectosrepository;
    
    public List<Proyectos> list() {
        return iproyectosrepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id) {
        return iproyectosrepository.findById(id);
    }
    
    public Optional<Proyectos> getByNombreP(String nombreP){
        return iproyectosrepository.getByNombreP(nombreP);
    }
    
    public void save(Proyectos proyectos) {
        iproyectosrepository.save(proyectos);
    }
    
    public void delete(int id) {
        iproyectosrepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return iproyectosrepository.existsById(id);
    }
    
    public boolean existsByNombreP(String nombreP) {
        return iproyectosrepository.existsByNombreP(nombreP);
    } 
}
