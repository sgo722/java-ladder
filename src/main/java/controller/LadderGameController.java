package controller;

import model.Height;
import model.line.generator.LineGenerator;
import model.line.Lines;
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
        LineGenerator lineGenerator = new RandomLineGenerator(new RandomBooleanGenerator());

        Lines lines = setLadder(height, personNames, lineGenerator);

        print(personNames, lines);
    }

    private static Lines setLadder(Height height, PersonNames personNames, LineGenerator lineGenerator) {
        Lines lines = new Lines();

        while(height.canInstall()) {
            lines = lines.addLine(personNames.getCount(), lineGenerator);
            height = height.install();
        }

        return lines;
    }

    private void print(PersonNames personNames, Lines lines) {
        outputView.printPersonNames(new PersonMapper().toDto(personNames));
        outputView.printLadder(new LineMapper().toDto(lines));
    }
}
