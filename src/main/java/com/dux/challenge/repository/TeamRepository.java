package com.dux.challenge.repository;

import com.dux.challenge.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findAllByOrderById();

    Team findByNombre(String nombre);
}
