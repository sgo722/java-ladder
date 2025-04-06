package controller;

import model.Height;
import model.person.PersonName;
import model.result.Result;
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

import java.util.Map;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        PersonNames personNames = new PersonNames(inputView.inputPersonNames());
        Results results = new Results(inputView.inputExecuteResult());
        Height height = new Height(inputView.inputLadderMaxHeight());
        LineGenerator lineGenerator = new RandomLineGenerator(new RandomBooleanGenerator());

        Ladder ladder = setLadder(height, personNames, lineGenerator);

        print(personNames, ladder, results);

        Map<Integer, Integer> personIdxToResultsIdx = ladder.play(personNames.getCount());
        Map<String, String> personNameToResult = results.calculate(personIdxToResultsIdx, personNames);

        boolean flag = true;
        while(flag){
            String targetName = inputView.inputTargetName();
            if(targetName.equals("all")){
                flag = false;
                outputView.printResultAll(personNameToResult);
            }
            if(!targetName.equals("all")) {
                outputView.printResultTargetName(personNameToResult.get(targetName));
            }
        }
    }

    private static Ladder setLadder(Height height, PersonNames personNames, LineGenerator lineGenerator) {
        Ladder ladder = new Ladder();

        while(height.canInstall()) {
            ladder = ladder.addLine(personNames.getCount(), lineGenerator);
            height = height.install();
        }

        return ladder;
    }

    private void print(PersonNames personNames, Ladder ladder, Results results) {
        outputView.printPersonNames(new PersonMapper().toDto(personNames));
        outputView.printLadder(new LineMapper().toDto(ladder));
        outputView.printResult(results.exportResultForView());
    }
}
