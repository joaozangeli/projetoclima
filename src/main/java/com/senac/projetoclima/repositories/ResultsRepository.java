package com.senac.projetoclima.repositories;

import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.models.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {

    Results findResultsByDate(String date);
}
