package com.Portfolio.DavKol.Repository;

import com.Portfolio.DavKol.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer> {
    public Optional<Educacion> getByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
