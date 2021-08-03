package com.hospital.hospital_universitario.repositories;

import java.util.List;

import com.hospital.hospital_universitario.models.Laudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaudoRepository extends JpaRepository<Laudo, Long>{
    Laudo findById(int id);
    List<Laudo> findByResidenteId(int residenteId);
    List<Laudo> findByDocenteId(int docenteId);
    List<Laudo> findByPacienteId(int pacienteId);
    List<Laudo> findByStatus(String status);
    

}