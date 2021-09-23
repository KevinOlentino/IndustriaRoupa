package com.industria.roupa.repositories;

import com.industria.roupa.entities.Tecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecidoRepository extends JpaRepository<Tecido,Integer> {
}
