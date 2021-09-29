package com.industria.roupa.repositories;

import com.industria.roupa.views.ViewQuantidadeTecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewQuantidadeTecidoRepository extends JpaRepository <ViewQuantidadeTecido,Integer>{
}
