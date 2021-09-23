package com.industria.roupa.repositories;

import com.industria.roupa.entities.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor,Integer> {
}
