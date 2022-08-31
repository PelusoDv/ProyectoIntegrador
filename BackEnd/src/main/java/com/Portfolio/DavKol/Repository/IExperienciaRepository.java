package com.Portfolio.DavKol.Repository;

import com.Portfolio.DavKol.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository <Experiencia,Integer>{
    public Optional<Experiencia> getByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
