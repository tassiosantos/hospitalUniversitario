package com.hospital.hospital_universitario.repositories;

import java.util.List;

import com.hospital.hospital_universitario.models.MedicosLaudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicosLaudoRepository extends JpaRepository<MedicosLaudo, Long>{
 
    List<MedicosLaudo> findByLaudoId(int laudoId);
    List<MedicosLaudo> findByMedicoResidenteId(int medicoResidenteId);
    List<MedicosLaudo> findByMedicoDocenteId(int medicoDocenteId);

}
