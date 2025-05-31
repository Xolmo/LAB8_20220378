package com.example.lab8_20220378.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "expedition_crew")
public class ExpeditionCrew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expedition_id")
    private int expeditionId;
    @ManyToOne
    @JoinColumn(name = "crew_member_id")
    private CrewMembers crewMember;
}
