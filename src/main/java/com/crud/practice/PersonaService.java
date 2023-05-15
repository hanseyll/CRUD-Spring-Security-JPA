package com.crud.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonRepository personRepository;

    public List<Persona> getAllPersons() {
        return personRepository.findAll();
    }

    public Persona getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + id));
    }

    public Persona createPerson(Persona person) {
        return personRepository.save(person);
    }

    public Persona updatePerson(Long id, Persona person) {
        Persona existingPerson = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found with id: " + id));
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        return personRepository.save(existingPerson);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
