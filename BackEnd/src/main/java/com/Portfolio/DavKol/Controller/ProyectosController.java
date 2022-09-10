package com.Portfolio.DavKol.Controller;

import com.Portfolio.DavKol.Dto.dtoProyectos;
import com.Portfolio.DavKol.Entity.Proyectos;
import com.Portfolio.DavKol.Service.ProyectosService;
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
@RequestMapping("/proy")
@CrossOrigin (origins = "http://localhost:4200")
public class ProyectosController {
    @Autowired
    ProyectosService proyectosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosService.existById(id))
            return new ResponseEntity(new Mensaje("no existe ID"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!proyectosService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto borrado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproy){
        if(StringUtils.isBlank(dtoproy.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproy.getDescripcionP()))
            return new ResponseEntity(new Mensaje("Descripcion obligatoria"), HttpStatus.BAD_REQUEST);
        if(proyectosService.existsByNombreP(dtoproy.getNombreP()))
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos(dtoproy.getNombreP(), dtoproy.getDescripcionP(), dtoproy.getImgP(), dtoproy.getLinkP());
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproy) {
        if(!proyectosService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(proyectosService.existsByNombreP(dtoproy.getNombreP()) && proyectosService.getByNombreP(dtoproy.getNombreP()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese Titulo ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproy.getNombreP()))
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setNombreP(dtoproy.getNombreP());
        proyectos.setDescripcionP(dtoproy.getDescripcionP());
        proyectos.setImgP(dtoproy.getImgP());
        proyectos.setLinkP(dtoproy.getLinkP());
        
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
