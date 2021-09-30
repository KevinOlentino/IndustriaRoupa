package com.industria.roupa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.industria.roupa.views.ViewSetorFuncionarioQuantidade;

@Repository
public interface ViewSetorFuncionarioQuantidadeRepository extends JpaRepository<ViewSetorFuncionarioQuantidade, Integer>{

}
