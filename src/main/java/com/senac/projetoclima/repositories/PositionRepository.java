package com.senac.projetoclima.repositories;

import com.senac.projetoclima.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position getById(long l);
}
