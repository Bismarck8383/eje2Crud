package com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.repositorio;

import com.bosonit.Eje2Crud.Eje2Crud.Persona.dominio.Persona;
import com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.dto.PersonOutPutDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Persona, String> {
    List<PersonOutPutDTO> findByName(String usuario);
}
