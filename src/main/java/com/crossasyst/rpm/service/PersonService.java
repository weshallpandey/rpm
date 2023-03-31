package com.crossasyst.rpm.service;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import com.crossasyst.rpm.entity.PersonEntity;
import com.crossasyst.rpm.mapper.PersonMapper;
import com.crossasyst.rpm.model.Enterprise;
import com.crossasyst.rpm.model.Person;
import com.crossasyst.rpm.repository.PersonRepository;
import com.crossasyst.rpm.response.EnterpriseResponse;
import com.crossasyst.rpm.response.PersonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonResponse createPerson(Person person) {
        PersonResponse personResponse = new PersonResponse();
        log.info("Creating Person");
        PersonEntity personEntity = personMapper.modelToEntity(person);
        personRepository.save(personEntity);
        log.info("Person details saved successfully.");
        personResponse.setPersonId(personEntity.getPersonId());
        log.info("Activity id {} ", personEntity.getPersonId());
        person = personMapper.entityToModel(personEntity);
        return personResponse;
    }

    public List<Person> findAllPersons() {
        log.info("Fetching all Enterprises.");
        List<PersonEntity> personEntities = personRepository.findByActiveTrue();
        List<Person> getAllPersons = personMapper.entityToModel(personEntities);
        return getAllPersons;
    }

    public Person getPersonById(Long personId) {
        log.info("Finding Person By Given Id");
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
        Person getPerson = new Person();
        if (personEntity.isPresent()) {
            getPerson = personMapper.entityToModel(personEntity.get());
            log.info("Person got successfully.");
        }
        return getPerson;
    }

    public void updatePerson(Long personId, Person person) {
        log.info("fetching persons");
        Optional<PersonEntity> personEntity = personRepository.findById(personId);

        if (personEntity.isPresent()) {
            PersonEntity personEntity1 = personMapper.modelToEntity(person);
            personEntity1.setPersonId(personEntity.get().getPersonId());
            personRepository.save(personEntity1);
            log.info("Person updated successfully.");
        }
    }

    public void removePerson(Long personId) {
        personRepository.deleteById(personId);
        log.info("person deleted succesfully");
    }
}
