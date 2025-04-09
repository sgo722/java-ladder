package model.game;

import model.Height;
import model.line.Ladder;
import model.line.LadderFactory;
import model.person.PersonNames;
import model.result.Rewards;

public class LadderGameFactory {

    private final LadderFactory ladderFactory;

    public LadderGameFactory(LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public LadderGame create(String personNamesStr, String resultsStr, String heightStr) {
        PersonNames personNames = new PersonNames(personNamesStr);
        Rewards rewards = new Rewards(resultsStr);
        Height height = new Height(heightStr);
        Ladder ladder = ladderFactory.create(personNames, height);

        return new LadderGame(personNames, rewards, ladder);
    }
}
