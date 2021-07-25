package com.hospital.hospital_universitario.repositories;

import java.util.List;

import com.hospital.hospital_universitario.models.Laudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaudoRepository extends JpaRepository<Laudo, Long>{
    Laudo findById(int id);
    List<Laudo> findByResidenteConectado(String residenteConectado);
    List<Laudo> findByStatus(String status);
    List<Laudo> findByPacienteConectado(String pacienteConectado);

}