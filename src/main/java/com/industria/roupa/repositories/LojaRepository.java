package com.industria.roupa.repositories;

import com.industria.roupa.entities.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja,Integer> {
}
