package com.jasonferraz.jason_ferraz_os.repository;

import com.jasonferraz.jason_ferraz_os.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    // O JpaRepository já nos dá os métodos: save(), findAll(), delete(), etc.
}