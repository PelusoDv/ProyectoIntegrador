package com.Portfolio.DavKol.Security.repository;

import com.Portfolio.DavKol.Security.entity.Rol;
import com.Portfolio.DavKol.Security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
