package com.coppel.back.repositories;

import com.coppel.back.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
