package com.senac.projetoclima.repositories;

import com.senac.projetoclima.models.Forecast;
import com.senac.projetoclima.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {
}
