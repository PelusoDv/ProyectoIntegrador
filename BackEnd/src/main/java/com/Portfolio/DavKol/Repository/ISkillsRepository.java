package com.Portfolio.DavKol.Repository;

import com.Portfolio.DavKol.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository<Skills, Integer> {
    public Optional<Skills> getByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
