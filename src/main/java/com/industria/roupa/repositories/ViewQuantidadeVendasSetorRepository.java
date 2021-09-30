package com.industria.roupa.repositories;

import com.industria.roupa.views.ViewQuantidadeVendasSetor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewQuantidadeVendasSetorRepository extends JpaRepository<ViewQuantidadeVendasSetor,Integer> {
}
