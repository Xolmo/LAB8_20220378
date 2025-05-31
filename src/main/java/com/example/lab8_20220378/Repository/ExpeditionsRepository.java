package com.example.lab8_20220378.Repository;

import com.example.lab8_20220378.Entity.Expeditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpeditionsRepository extends JpaRepository<Expeditions, Long> {
}
