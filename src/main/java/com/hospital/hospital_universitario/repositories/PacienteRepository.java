package com.hospital.hospital_universitario.repositories;

import java.util.List;

import com.hospital.hospital_universitario.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    Paciente findById(int id);

}