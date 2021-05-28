package com.senac.projetoclima.repositories;

import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.models.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RootRepository extends JpaRepository<Root, Long> {
}
