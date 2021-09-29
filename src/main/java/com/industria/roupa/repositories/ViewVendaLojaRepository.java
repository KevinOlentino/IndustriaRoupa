package com.industria.roupa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.industria.roupa.views.ViewVendaLoja;

@Repository
public interface ViewVendaLojaRepository extends JpaRepository<ViewVendaLoja, Integer>{

}
