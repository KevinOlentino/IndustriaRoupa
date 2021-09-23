package com.industria.roupa.repositories;

import com.industria.roupa.entities.Roupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoupaRepository extends JpaRepository<Roupa,Integer> {
}
