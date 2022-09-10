package com.Portfolio.DavKol.Repository;

import com.Portfolio.DavKol.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepository extends JpaRepository<Proyectos, Integer> {
    public Optional<Proyectos> getByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP);
}
