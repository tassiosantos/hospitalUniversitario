package com.hospital.hospital_universitario.repositories;

// import java.util.List;

import com.hospital.hospital_universitario.models.Medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{
   Medico findById(int id);
   Medico findByCrmAndSenha(String crm, String senha);

}