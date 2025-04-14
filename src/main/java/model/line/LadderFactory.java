package model.line;

import model.Height;
import model.person.PersonNames;

public class LadderFactory {

    public Ladder create(PersonNames personNames, Height height) {
        Ladder ladder = new Ladder();

        while(height.canInstall()) {
            ladder = ladder.addLine(personNames.getCount());
            height = height.install();
        }

        return ladder;
    }
}
