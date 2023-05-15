package com.crud.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaService personService;

    @GetMapping("/")
    public List<Persona> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Persona getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/")
    public Persona createPerson(@RequestBody Persona person) {
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public Persona updatePerson(@PathVariable("id") Long id, @RequestBody Persona person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }
}
