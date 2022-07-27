package com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura;

import com.bosonit.Eje2Crud.Eje2Crud.Persona.aplicacion.PersonaService;
import com.bosonit.Eje2Crud.Eje2Crud.Persona.dominio.Persona;
import com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.dto.PersonInPutDTO;
import com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.dto.PersonOutPutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona/crud")
public class PersonController {
    @Autowired
    PersonaService personaService;

    //Insertar personas en la base de datos
    @PostMapping("/addPersona")
    public String insertarPersona(@RequestBody PersonInPutDTO personInPutDTO) throws  Exception{
       PersonOutPutDTO personaOutPutDTO =  personaService.addPerson(personInPutDTO);
        return "Persona agregada correctamente " + personaOutPutDTO;
    }

//Ver todos los registros de la tabla

    @GetMapping("/usuarios")
    public List<Persona> getUsuarios(){
        return personaService.findAll();
    }

    //Usuarios por parametros id
    @GetMapping("/usuarios/{id}")
    public PersonOutPutDTO getPersonaByID(@PathVariable String id) throws Exception{
        return personaService.findById(id);
    }

    //Usuarios por parametros nombre
    @GetMapping("/usuarios/name/{name}")
    public ResponseEntity<?> getPersonaByName(@PathVariable String name){
        try{
            //return personaService.findByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findByName(name));
        }catch ( Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el usario");
        }

    }
    @PutMapping("/update/{id}")
    public void Actualizar(@PathVariable String id, @RequestBody Persona persona) throws Exception{
            personaService.Actualizar(id,persona);
    }

}
