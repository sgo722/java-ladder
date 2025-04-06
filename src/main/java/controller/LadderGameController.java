package controller;

import model.ExecuteResult;
import model.Height;
import model.result.Results;
import model.line.generator.LineGenerator;
import model.line.Ladder;
import model.line.generator.RandomLineGenerator;
import model.mapper.LineMapper;
import model.mapper.PersonMapper;
import model.person.PersonNames;
import model.util.RandomBooleanGenerator;
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
        Results results = new Results(inputView.inputExecuteResult());
        LineGenerator lineGenerator = new RandomLineGenerator(new RandomBooleanGenerator());

        Ladder ladder = setLadder(height, personNames, lineGenerator);
        ladder.play();

        print(personNames, ladder);
    }

    private static Ladder setLadder(Height height, PersonNames personNames, LineGenerator lineGenerator) {
        Ladder ladder = new Ladder();

        while(height.canInstall()) {
            ladder = ladder.addLine(personNames.getCount(), lineGenerator);
            height = height.install();
        }

        return ladder;
    }

    private void print(PersonNames personNames, Ladder ladder) {
        outputView.printPersonNames(new PersonMapper().toDto(personNames));
        outputView.printLadder(new LineMapper().toDto(ladder));
    }
}
