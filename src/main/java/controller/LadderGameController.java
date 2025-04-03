package controller;

import model.Height;
import model.ladder.Lines;
import model.mapper.LineMapper;
import model.mapper.PersonMapper;
import model.person.PersonNames;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void makeLadder() {
        PersonNames personNames = new PersonNames(inputView.inputPersonNames());
        Height height = new Height(inputView.inputLadderMaxHeight());

        Lines lines = setLines(height, personNames);

        print(personNames, lines);
    }

    private static Lines setLines(Height height, PersonNames personNames) {
        Lines lines = new Lines();

        while(!height.canInstall()) {
            lines = lines.addLine(personNames.getCount());
            height = height.install();
        }

        return lines;
    }

    private void print(PersonNames personNames, Lines lines) {
        outputView.printPersonNames(new PersonMapper().toDto(personNames));
        outputView.printLadder(new LineMapper().toDto(lines));
    }
}
