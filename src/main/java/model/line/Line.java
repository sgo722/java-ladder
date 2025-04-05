package model.line;

import java.util.List;

public class Line {
    private final List<Bridge> bridges;

    public Line(List<Bridge> bridges) {
        validate(bridges);
        this.bridges = bridges;
    }

    private void validate(List<Bridge> bridges) {
        for (int i = 1; i < bridges.size(); i++) {
            if (bridges.get(i).isConnected() && bridges.get(i - 1).isConnected()) {
                throw new IllegalArgumentException("[ERROR] 연속된 연결은 불가능합니다");
            }
        }
    }

    public List<Boolean> exportBridgesForView() {
        return bridges.stream()
                .map(Bridge::isConnected)
                .toList();
    }
}