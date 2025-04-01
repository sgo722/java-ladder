package controller;

import model.person.Name;
import model.ladder.Height;
import model.ladder.Lines;
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
        Name personName = new Name(inputView.inputPersonName());
        Height height = new Height(inputView.inputLadderMaxHeight());

        Lines lines = new Lines(personName, height);
    }
}
