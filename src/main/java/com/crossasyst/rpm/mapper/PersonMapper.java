package com.crossasyst.rpm.mapper;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import com.crossasyst.rpm.entity.PersonEntity;
import com.crossasyst.rpm.model.Enterprise;
import com.crossasyst.rpm.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity modelToEntity(Person person);

    List<Person> entityToModel(List<PersonEntity> personEntities);
    Person entityToModel(PersonEntity personEntity);
}
