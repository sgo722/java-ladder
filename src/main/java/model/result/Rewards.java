package model.result;

import model.person.PersonNames;

import java.util.*;

public class Rewards {

    private final List<Reward> rewards;

    public Rewards(String input){
        validate(input);
        rewards = parseResults(input);
    }

    private void validate(String input){
        validateNotBlank(input);
    }
    private void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이나 공백을 입력할 수 없습니다.");
        }
    }

    private List<Reward> parseResults(String input) {
        String[] results = input.split(",");

        ArrayList<Reward> parseRewards = new ArrayList<>();
        for (String result : results) {
            parseRewards.add(new Reward(result));
        }

        return parseRewards;
    }

    public Map<String, String> calculate(List<Integer> personNameIndexToResultIndex, PersonNames personNames) {
        Map<String, String> personNameToResult = new LinkedHashMap<>();

        for(Integer personIdx : personNameIndexToResultIndex){
            String personName = personNames.getPersonNames().get(personIdx);
            String result = rewards.get(personNameIndexToResultIndex.get(personIdx)).exportResultForView();
            personNameToResult.put(personName,result);
        }

        return personNameToResult;
    }

    public List<String> getRewards(){
        return rewards.stream()
                .map(Reward::exportResultForView)
                .toList();
    }

    public int getCount(){
        return rewards.size();
    }
}
