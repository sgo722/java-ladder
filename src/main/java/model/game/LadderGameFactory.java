package model.game;

import model.Height;
import model.line.Ladder;
import model.line.LadderFactory;
import model.line.generator.LineGenerator;
import model.person.PersonNames;
import model.result.Rewards;

public class LadderGameFactory {

    private final LadderFactory ladderFactory;
    private final LineGenerator lineGenerator;

    public LadderGameFactory(LadderFactory ladderFactory, LineGenerator lineGenerator) {
        this.ladderFactory = ladderFactory;
        this.lineGenerator = lineGenerator;
    }

    public LadderGame create(String personNamesStr, String resultsStr, String heightStr) {
        PersonNames personNames = new PersonNames(personNamesStr);
        Rewards rewards = new Rewards(resultsStr);
        Height height = new Height(heightStr);
        Ladder ladder = ladderFactory.create(personNames, height, lineGenerator);

        return new LadderGame(personNames, rewards, ladder);
    }
}
