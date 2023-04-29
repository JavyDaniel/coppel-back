package com.coppel.back.repositories;

import com.coppel.back.models.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {

    public Denuncia findFirstByOrderByFolioDesc();
}
