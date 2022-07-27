package com.bosonit.Eje2Crud.Eje2Crud.Persona.aplicacion;

import com.bosonit.Eje2Crud.Eje2Crud.Persona.dominio.Persona;
import com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.dto.PersonInPutDTO;
import com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.dto.PersonOutPutDTO;

import java.util.List;

public interface PersonaI {
    void Actualizar(String id, Persona persona);

    PersonOutPutDTO addPerson(PersonInPutDTO personDTO) throws Exception;
   List<PersonOutPutDTO> findByName(String name) throws Exception;
   PersonOutPutDTO findById(String id) throws Exception;
   List<Persona> findAll();
   String deleteById(String id) throws  Exception;

}
