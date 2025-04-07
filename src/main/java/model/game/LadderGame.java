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

    private Map<String, String> cachedPersonNameToResult;


    public LadderGame(PersonNames personNames, Rewards rewards, Ladder ladder) {
        this.personNames = personNames;
        this.rewards = rewards;
        this.ladder = ladder;
    }


    public void play() {
        List<Integer> play = ladder.play(this.personNames.getCount());
        cachedPersonNameToResult = rewards.calculate(play, personNames);
    }

    public String getResultFor(String targetName) {
        if(cachedPersonNameToResult == null){
            throw new IllegalStateException("[ERROR] 게임이 아직 실행되지 않았습니다");
        }
        if(!cachedPersonNameToResult.containsKey(targetName)){
            return NOT_FOUND_USER;
        }

        return cachedPersonNameToResult.get(targetName);
    }

    public Map<String, String> getAllResults() {
        if(cachedPersonNameToResult == null){
            throw new IllegalStateException("[ERROR] 게임이 아직 실행되지 않았습니다");
        }

        return cachedPersonNameToResult;
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
