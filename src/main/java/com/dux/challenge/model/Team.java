package com.dux.challenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
    @SequenceGenerator(name = "team_seq", sequenceName = "team_seq", allocationSize = 1, initialValue = 25)
    Long id;

    @Column(name = "name", nullable = false)
    String nombre;

    @Column(name = "league", nullable = false)
    String liga;

    @Column(name = "country", nullable = false)
    String pais;
}
