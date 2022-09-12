
package com.Portfolio.DavKol.Controller;

import com.Portfolio.DavKol.Dto.dtoPersona;
import com.Portfolio.DavKol.Entity.Persona;
import com.Portfolio.DavKol.Service.PersonaService;
import com.Portfolio.DavKol.Utility.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/persona")
@CrossOrigin (origins = "https://portfolio-dvkl.web.app")
public class PersonaController {
    @Autowired
    PersonaService personaService;
      
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoper){
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoper.getApellido()))
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoper.getResidencia()))
            return new ResponseEntity(new Mensaje("Lugar de residencia obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoper.getTitulo()))
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByTitulo(dtoper.getTitulo()))
            return new ResponseEntity(new Mensaje("Ese titulo ya esxiste"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(dtoper.getNombre(), dtoper.getApellido(), dtoper.getImg(), dtoper.getTitulo(),
                dtoper.getResidencia(), dtoper.getDescripcion(), dtoper.getNumero(), dtoper.getEmail());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable int id) {
        personaService.delete(id);
        return "La persona fue borrado correctamente";
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<Persona> editPersona(@PathVariable int id, @RequestBody dtoPersona dtoper){
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoper.getApellido()))
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoper.getResidencia()))
            return new ResponseEntity(new Mensaje("Lugar de residencia obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoper.getTitulo()))
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByTitulo(dtoper.getTitulo()) && personaService.getByTitulo(dtoper.getTitulo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese titulo ya esxiste"), HttpStatus.BAD_REQUEST);
           
        Persona persona = personaService.findPersona(id).get();
        persona.setNombre(dtoper.getNombre());
        persona.setApellido(dtoper.getApellido());
        persona.setImg(dtoper.getImg());
        persona.setTitulo(dtoper.getTitulo());
        persona.setResidencia(dtoper.getResidencia());
        persona.setDescripcion(dtoper.getDescripcion());
        persona.setNumero(dtoper.getNumero());
        persona.setEmail(dtoper.getEmail());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
    }
    
    @GetMapping("/show/perfil")
    public Persona findPerosna() {
        return personaService.findPersona((int) 1).get();
    }
}
