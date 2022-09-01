package com.Portfolio.DavKol.Repository;

import com.Portfolio.DavKol.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {
    public Optional<Persona> getByTitulo(String nombreE);
    public boolean existsByTitulo(String titulo);
}
