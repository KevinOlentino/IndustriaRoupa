package com.industria.roupa.repositories;

import com.industria.roupa.entities.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncaoRepositorio extends JpaRepository<Funcao,Integer> {
}
