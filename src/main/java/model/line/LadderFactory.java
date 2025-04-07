package model.line;

import model.Height;
import model.line.generator.LineGenerator;
import model.person.PersonNames;

public class LadderFactory {

    public Ladder create(PersonNames personNames, Height height, LineGenerator lineGenerator) {
        Ladder ladder = new Ladder();

        while(height.canInstall()) {
            ladder = ladder.addLine(personNames.getCount(), lineGenerator);
            height = height.install();
        }

        return ladder;
    }
}
