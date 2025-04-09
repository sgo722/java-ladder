package controller;

import model.game.LadderGame;
import model.game.LadderGameFactory;
import model.line.LadderFactory;
import model.line.generator.RandomLineGenerator;
import model.mapper.LineMapper;
import model.mapper.PersonMapper;
import model.mapper.RewardsMapper;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGameFactory ladderGameFactory;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGameFactory = new LadderGameFactory(new LadderFactory(), new RandomLineGenerator());
    }

    public void run() {
        // 사다리 생성
        LadderGame ladderGame = ladderGameFactory.create(inputView.inputPersonNames(), inputView.inputResults(), inputView.inputLadderMaxHeight());

        // 사다리 출력
        printStatus(ladderGame);

        // 사다리 게임 실행
        ladderGame.play();

        // 사다리 결과 출력
        while(true){
            String targetName = inputView.inputTargetName();
            if(printAll(targetName)) {
                outputView.printResultAll(ladderGame.getAllResults());
                return;
            }
            outputView.printResultTargetName(ladderGame.getResultFor(targetName));
        }
    }

    private void printStatus(LadderGame ladderGame) {
        outputView.printPersonNames(new PersonMapper().toDto(ladderGame.getPersonNames()));
        outputView.printLadder(new LineMapper().toDto(ladderGame.getLadder()));
        outputView.printRewards(new RewardsMapper().toDto(ladderGame.getRewards()));
    }

    private static boolean printAll(String targetName) {
        return targetName.equals("all");
    }
}
