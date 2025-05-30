package model.mapper;

import model.dto.PersonNameDto;
import model.person.PersonName;
import model.person.PersonNames;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    public List<PersonNameDto> toDto(PersonNames personNames) {
        List<PersonNameDto> personNameDtos = new ArrayList<>();

        for(PersonName personName : personNames.getPersonNames()) {
            personNameDtos.add(toDto(personName));
        }
        return personNameDtos;

    }

    private PersonNameDto toDto(PersonName personName) {
        return new PersonNameDto(personName.exportNameForView());
    }
}
