package com.industria.roupa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.industria.roupa.views.ViewRoupaTecido;

@Repository
public interface ViewRoupaTecidoRepository extends JpaRepository<ViewRoupaTecido, Integer> {

}
