package controller;

import model.ladder.Height;
import model.ladder.Lines;
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

        Lines lines = new Lines(personNames.getCount(), height.getHeight());

        print(personNames, lines);
    }

    private void print(PersonNames personNames, Lines lines) {
        outputView.printPersonNames(personNames.toDto());

        outputView.printLadder(lines.toDto());
    }
}
