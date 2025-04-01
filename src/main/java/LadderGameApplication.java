import controller.LadderGameController;
import view.InputView;
import view.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new InputView(), new OutputView());
    }
}
