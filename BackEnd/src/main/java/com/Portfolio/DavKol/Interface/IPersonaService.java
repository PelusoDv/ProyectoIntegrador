
package com.Portfolio.DavKol.Interface;

import com.Portfolio.DavKol.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //LLamar a la lista de Usuarios
    public List<Persona> getPersona();
    
    //Guardar un nuevo Usuario
    public void savePersona(Persona persona);
    
    //Eliminar un Usuario existente por su ID
    public void deletePersona(Long id);
    
    //Buscar Usuario por su ID
    public Persona findPersona(Long id);
}
