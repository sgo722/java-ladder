package model.person;

import model.dto.PersonNameDto;

public class PersonName {
    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public PersonName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotBlank(name);
        validateLength(name);
    }

    private void validateNotBlank(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이나 공백을 입력할 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름은 최대 5글자 까지 입력 가능합니다.");
        }
    }

    public String exportNameForView(){
        return name;
    }
}
