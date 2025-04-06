package model.result;

import model.person.PersonName;
import model.person.PersonNames;

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

    public Map<String, String> calculate(Map<Integer, Integer> personNameIndexToResultIndex, PersonNames personNames) {
        Map<String, String> personNameToResult = new HashMap<>();

        for(Integer personIdx : personNameIndexToResultIndex.keySet()){
            String personName = personNames.getPersonNames().get(personIdx).exportNameForView();
            String result = results.get(personNameIndexToResultIndex.get(personIdx)).exportResultForView();
            personNameToResult.put(personName,result);
        }

        return personNameToResult;
    }

    public List<String> exportResultForView(){
        return results.stream()
                .map(Result::exportResultForView)
                .toList();
    }
}
