package com.bosonit.Eje2Crud.Eje2Crud.Persona.aplicacion;

import com.bosonit.Eje2Crud.Eje2Crud.Persona.dominio.Persona;
import com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.dto.PersonInPutDTO;
import com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.dto.PersonOutPutDTO;
import com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.repositorio.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements PersonaI{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public void Actualizar(String id, Persona persona){
        List<Persona> personas= personRepository.findAll();
        for (int  i =0; i < personas.size(); i++){
            Persona p= personas.get(i);
            if (p.getPerson_id().equals(id)){
                personas.set(i,persona);
                return;
            }
        }
    }
    @Override
    public PersonOutPutDTO addPerson(PersonInPutDTO personDTO) throws Exception {
        if (personDTO.getUsuario().length() < 0 || personDTO.getUsuario().length() > 10) {
            throw new Exception("El usuario debe tener entre 0 y 10 caracteres");
        } else {
            Persona person = new Persona(personDTO);
            personRepository.save(person);
            PersonOutPutDTO saveOutPutDTO = new PersonOutPutDTO(person);
            return saveOutPutDTO;
        }
    }

    @Override
    public List<PersonOutPutDTO> findByName(String name) throws Exception {
        try {
            List<PersonOutPutDTO> usuarioByName = personRepository.findByName(name);
            return usuarioByName;
        } catch (Exception e) {
            throw new Exception("No se ha podido encontrar el usuario");
        }
    }

    @Override
    public PersonOutPutDTO findById(String id) throws  Exception{
    Persona usuarioById = personRepository.findById(id).orElseThrow(
            () -> new Exception("No se há encontrado el Id"));
    return new PersonOutPutDTO(usuarioById);
    }

    @Override
    public List<Persona> findAll(){
        return personRepository.findAll();
    }

    @Override
    public String deleteById(String id) throws Exception {
        personRepository.findById(id)
                .orElseThrow(
                        () -> new Exception("No se encontro a la persona con Id : "));
        personRepository.deleteById(id);
        return "La persona con id : "+id +" há sido eleminada";
    }

}
