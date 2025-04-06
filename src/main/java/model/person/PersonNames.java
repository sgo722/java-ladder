package model.person;

import model.result.Results;

import java.util.*;

public class PersonNames {

    private final List<PersonName> personNames;

    public PersonNames(String personNames) {
        validate(personNames);
        this.personNames = parseNames(personNames);
    }

    public void validate(String personNames) {
        validateNotBlank(personNames);
        validateNoDuplicates(personNames);
    }

    private void validateNotBlank(String personNames) {
        if (personNames == null || personNames.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이나 공백을 입력할 수 없습니다.");
        }
    }

    private void validateNoDuplicates(String input) {
        String[] personNames = input.split(",");

        Set<String> uniqueValues = new HashSet<>(Arrays.asList(personNames));
        if (uniqueValues.size() != personNames.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재할 수 없습니다.");
        }
    }

    private List<PersonName> parseNames(String personNames) {
        String[] splitPersonNames = personNames.split(",");

        ArrayList<PersonName> parseNames = new ArrayList<>();
        for (String name : splitPersonNames) {
            parseNames.add(new PersonName(name));
        }

        return parseNames;
    }

    public int getCount(){
        return personNames.size();
    }

    public List<PersonName> getPersonNames() {
        return Collections.unmodifiableList(personNames);
    }
}
