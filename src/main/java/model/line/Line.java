package model.line;

import java.util.List;

public class Line {
    private final List<Bridge> bridges;

    public Line(List<Bridge> bridges) {
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
}