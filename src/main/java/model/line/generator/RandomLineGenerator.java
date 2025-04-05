package model.line.generator;

import model.line.Bridge;
import model.line.Line;
import model.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {

    private final BooleanGenerator booleanGenerator;

    public RandomLineGenerator(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Line generate(int personCount) {
        List<Bridge> bridges = new ArrayList<>();

        while(bridges.size() < personCount - 1){
            addBridge(bridges);
        }
        return new Line(bridges);
    }

    private void addBridge(List<Bridge> bridges) {
        if(cannotConnectNextBridge(bridges)){
            bridges.add(Bridge.NOT_CONNECTED);
            return;
        }
        bridges.add(Bridge.from(booleanGenerator.nextBoolean()));
    }

    private boolean cannotConnectNextBridge(List<Bridge> bridges) {
        return !bridges.isEmpty() && bridges.get(bridges.size() - 1).isConnected();
    }
}
