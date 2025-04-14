package model.game;

import model.line.Ladder;
import model.person.PersonNames;
import model.result.Rewards;

import java.util.List;
import java.util.Map;

public class LadderGame {
    // 사다리 게임을 실행한다.
    static final String NOT_FOUND_USER = "존재하지 않는 이름입니다.";

    private final PersonNames personNames;
    private final Rewards rewards;
    private final Ladder ladder;

    private Map<String, String> personNameToResult;

    public LadderGame(PersonNames personNames, Rewards rewards, Ladder ladder) {
        validate(personNames, rewards);
        this.personNames = personNames;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    private void validate(PersonNames personNames, Rewards rewards) {
        validateCount(personNames, rewards);
    }

    private void validateCount(PersonNames personNames, Rewards rewards) {
        if(personNames.getCount() != rewards.getCount()){
            throw new IllegalArgumentException("[ERROR] 사람 수와 보상의 개수는 일치해야합니다");
        }
    }

    public void play() {
        List<Integer> play = ladder.play(this.personNames.getCount());
        personNameToResult = rewards.calculate(play, personNames);
    }

    public String getResultFor(String targetName) {
        if(personNameToResult == null){
            throw new IllegalArgumentException("[ERROR] 게임이 아직 실행되지 않았습니다");
        }
        if(!personNameToResult.containsKey(targetName)){
            return NOT_FOUND_USER;
        }

        return personNameToResult.get(targetName);
    }

    public Map<String, String> getAllResults() {
        if(personNameToResult == null){
            throw new IllegalArgumentException("[ERROR] 게임이 아직 실행되지 않았습니다");
        }

        return personNameToResult;
    }

    public PersonNames getPersonNames() {
        return personNames;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
