package com.example.lab8_20220378.Repository;

import com.example.lab8_20220378.Entity.ExpeditionCrew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpeditionCrewRepository extends JpaRepository<ExpeditionCrew, Long> {
}
