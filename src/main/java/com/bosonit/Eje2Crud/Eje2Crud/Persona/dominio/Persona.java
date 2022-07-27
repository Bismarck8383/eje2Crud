package com.bosonit.Eje2Crud.Eje2Crud.Persona.dominio;


import com.bosonit.Eje2Crud.Eje2Crud.Persona.infraestructura.dto.PersonInPutDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue
    private String person_id;
    @Column(length = 10, columnDefinition = "varchar", nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    private String surname;
    @Column(nullable = false)
    private String company_email;
    @Column(nullable = false)
    private String personal_email;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private boolean active;
    @Column(nullable = false)
    private Date created_date;
    private String image_url;
    private Date termination_date;


    public Persona(PersonInPutDTO personDTO) {
        if (personDTO == null) return;
        setPerson_id(personDTO.getPerson_id());
        setUsuario(personDTO.getUsuario());
        setPassword(personDTO.getPassword());
        setName(personDTO.getName());
        setSurname(personDTO.getSurname());
        setCompany_email(personDTO.getCompany_email());
        setPersonal_email(personDTO.getPersonal_email());
        setCity(personDTO.getCity());
        setActive(personDTO.isActive());
        setCreated_date(personDTO.getCreated_date());
        setImage_url(personDTO.getImage_url());
        setTermination_date(personDTO.getTermination_date());
    }
}
