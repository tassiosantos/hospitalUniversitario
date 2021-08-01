package com.hospital.hospital_universitario.repositories;

import java.util.List;

// import com.hospital.hospital_universitario.models.Paciente;
import com.hospital.hospital_universitario.models.PacienteLaudo;
// import com.hospital.hospital_universitario.models.Laudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteLaudoRepository extends JpaRepository<PacienteLaudo, Long> {
        List<PacienteLaudo> findByPacienteId(int pacienteId);

}
