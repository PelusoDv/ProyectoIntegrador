package com.Portfolio.DavKol.Service;

import com.Portfolio.DavKol.Entity.Skills;
import com.Portfolio.DavKol.Repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService {
    @Autowired
    ISkillsRepository iskillsRepository;
    
    public List<Skills> list() {
        return iskillsRepository.findAll();
    }
    
    public Optional<Skills> getOne(int id) {
        return iskillsRepository.findById(id);
    }
    
    public Optional<Skills> getByNombreS(String nombreS){
        return iskillsRepository.getByNombreS(nombreS);
    }
       
    public void save(Skills skills) {
        iskillsRepository.save(skills);
    }
    
    public void delete(int id) {
        iskillsRepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return iskillsRepository.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS) {
        return iskillsRepository.existsByNombreS(nombreS);
    }
}
