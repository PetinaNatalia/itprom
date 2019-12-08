package it.prom.itprom.repository;

import it.prom.itprom.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends JpaRepository <Profession, Integer> {
}
