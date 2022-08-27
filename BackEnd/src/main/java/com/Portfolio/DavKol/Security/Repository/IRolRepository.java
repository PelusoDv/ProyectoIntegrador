package com.Portfolio.DavKol.Security.Repository;

import com.Portfolio.DavKol.Security.Entity.Rol;
import com.Portfolio.DavKol.Security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolName(RolName rolName);

}
