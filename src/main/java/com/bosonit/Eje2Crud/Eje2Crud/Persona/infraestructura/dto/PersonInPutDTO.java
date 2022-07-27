package com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.dto;

import com.bosonit.Eje2Crud.Eje2Crud.Persona.dominio.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonInPutDTO {
    private String person_id;

    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;

    public PersonInPutDTO(Persona person) {
        setPerson_id(person.getPerson_id());
        setActive(person.isActive());
        setCity(person.getCity());
        setCompany_email(person.getCompany_email());
        setImage_url(person.getImage_url());
        setName(person.getName());
        setSurname(person.getSurname());
        setPassword(person.getPassword());
        setPersonal_email(person.getPersonal_email());
        setUsuario(person.getUsuario());
        setTermination_date(person.getTermination_date());
    }

    public PersonInPutDTO(){}

}
