package com.example.lab8_20220378.Repository;

import com.example.lab8_20220378.Entity.CrewMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewMembersRepository extends JpaRepository<CrewMembers, Long> {
}
