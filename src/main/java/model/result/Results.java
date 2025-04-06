package model.result;

import java.util.*;

public class Results {

    private final List<Result> results;

    public Results(String input){
        validate(input);
        results = parseResults(input);
    }

    private void validate(String input){
        validateNotBlank(input);
    }
    private void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이나 공백을 입력할 수 없습니다.");
        }
    }

    private List<Result> parseResults(String input) {
        String[] results = input.split(",");

        ArrayList<Result> parseResults = new ArrayList<>();
        for (String result : results) {
            parseResults.add(new Result(result));
        }

        return parseResults;
    }
}
