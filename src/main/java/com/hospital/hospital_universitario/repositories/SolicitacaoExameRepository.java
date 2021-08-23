package com.hospital.hospital_universitario.repositories;


import java.util.List;

import com.hospital.hospital_universitario.models.SolicitacaoExame;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoExameRepository extends JpaRepository<SolicitacaoExame, Long>{
    SolicitacaoExame findById(int id);

    List<SolicitacaoExame> findByPacienteId(int pacienteId);

}