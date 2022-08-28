package com.Portfolio.DavKol.Security.service;

import com.Portfolio.DavKol.Security.entity.Rol;
import com.Portfolio.DavKol.Security.enums.RolNombre;
import com.Portfolio.DavKol.Security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return  rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}