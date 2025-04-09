package model.line;

import model.line.generator.BridgeGenerator;
import model.line.generator.RandomBridgeGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Bridge> bridges;
    private final BridgeGenerator bridgeGenerator;

    public Line(int personCount){
        bridgeGenerator = new RandomBridgeGenerator();
        bridges = bridgeGenerator.generate(personCount);
        validate(bridges);
    }

    public Line(List<Bridge> bridges) {
        bridgeGenerator = new RandomBridgeGenerator();
        validate(bridges);
        this.bridges = bridges;
    }

    public Line(List<Bridge> bridges, BridgeGenerator bridgeGenerator) {
        this.bridgeGenerator = bridgeGenerator;
        validate(bridges);
        this.bridges = bridges;
    }

    private void validate(List<Bridge> bridges) {
        validateContinuous(bridges);
    }

    private static void validateContinuous(List<Bridge> bridges) {
        for (int bridgeIndex = 1; bridgeIndex< bridges.size(); bridgeIndex++) {
            validateBridgeIndex(bridges, bridgeIndex);
        }
    }

    private static void validateBridgeIndex(List<Bridge> bridges, int bridgeIndex) {
        if (bridges.get(bridgeIndex).isConnected() && bridges.get(bridgeIndex - 1).isConnected()) {
            throw new IllegalArgumentException("[ERROR] 연속된 연결은 불가능합니다");
        }
    }

    public List<Boolean> exportBridgesForView() {
        return bridges.stream()
                .map(Bridge::isConnected)
                .toList();
    }

    public int move(int playerIdx) {
        if(moveRight(playerIdx)){
            return playerIdx + 1;
        }
        if(moveLeft(playerIdx)){
            return playerIdx - 1;
        }

        return playerIdx;
    }

    private boolean moveRight(int playerIdx) {
        return playerIdx < bridges.size() && bridges.get(playerIdx).isConnected();
    }

    private boolean moveLeft(int playerIdx) {
        return playerIdx > 0 && bridges.get(playerIdx - 1).isConnected();
    }
}