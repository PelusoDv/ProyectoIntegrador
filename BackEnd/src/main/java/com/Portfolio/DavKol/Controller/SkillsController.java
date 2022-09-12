package com.Portfolio.DavKol.Controller;

import com.Portfolio.DavKol.Dto.dtoSkills;
import com.Portfolio.DavKol.Entity.Skills;
import com.Portfolio.DavKol.Service.SkillsService;
import com.Portfolio.DavKol.Utility.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@CrossOrigin (origins = "http://localhost:4200")
public class SkillsController {
    @Autowired
    SkillsService skillsService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!skillsService.existById(id))
            return new ResponseEntity(new Mensaje("no existe ID"), HttpStatus.NOT_FOUND);
        Skills skills = skillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!skillsService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        skillsService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad borrado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombreS()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        if(dtoskill.getPercent() == null)
            return new ResponseEntity(new Mensaje("Porcentage obligatorio"), HttpStatus.BAD_REQUEST);
        if(dtoskill.getPercent() > 100)
            return new ResponseEntity(new Mensaje("el porcentaje no puede ser mayor a 100"), HttpStatus.BAD_REQUEST);
        if(skillsService.existsByNombreS(dtoskill.getNombreS()))
            return new ResponseEntity(new Mensaje("La Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        Skills skills = new Skills(dtoskill.getNombreS(), dtoskill.getPercent());
        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskill) {
        if(!skillsService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(skillsService.existsByNombreS(dtoskill.getNombreS()) && skillsService.getByNombreS(dtoskill.getNombreS()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoskill.getNombreS()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        if(dtoskill.getPercent() == null)
            return new ResponseEntity(new Mensaje("Porcentage obligatorio"), HttpStatus.BAD_REQUEST);
        if(dtoskill.getPercent() > 100)
            return new ResponseEntity(new Mensaje("el porcentaje no puede ser mayor a 100"), HttpStatus.BAD_REQUEST);
        
        Skills skills = skillsService.getOne(id).get();
        skills.setNombreS(dtoskill.getNombreS());
        skills.setPercent(dtoskill.getPercent());
        
        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
