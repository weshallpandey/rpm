package com.crossasyst.rpm.controller;

import com.crossasyst.rpm.entity.PersonEntity;
import com.crossasyst.rpm.model.Enterprise;
import com.crossasyst.rpm.model.Person;
import com.crossasyst.rpm.response.EnterpriseResponse;
import com.crossasyst.rpm.response.PersonResponse;
import com.crossasyst.rpm.service.PersonService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Create Person", description = "Create person")
@RequestMapping(path = "v1")
@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<PersonResponse> createPerson(@RequestBody @Valid Person person) {
        PersonResponse personResponse = personService.createPerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Person>> getAllPersons() {
        List<Person> personList = personService.findAllPersons();
        return new ResponseEntity<>(personList, HttpStatus.OK);

    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Person> getPersonById(@PathVariable Long personId) {
        Person person = personService.getPersonById(personId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/persons/{personId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> updatePerson(@PathVariable Long personId, @RequestBody Person person) {
        personService.updatePerson(personId, person);
        return new ResponseEntity("Person updated successfully", HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @DeleteMapping(path = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> removePerson(@PathVariable Long personId) {
        personService.removePerson(personId);
        return new ResponseEntity<>("remove person successfully", HttpStatus.OK);
    }


}
