package model.line.generator;

import model.line.Bridge;
import model.util.BooleanGenerator;
import model.util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomBridgeGenerator implements BridgeGenerator {

    private final BooleanGenerator booleanGenerator;

    public RandomBridgeGenerator() {
        this.booleanGenerator = new RandomBooleanGenerator();
    }

    public RandomBridgeGenerator(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public List<Bridge> generate(int personCount) {
        List<Bridge> bridges = new ArrayList<>();

        while(bridges.size() < personCount - 1){
            addBridge(bridges);
        }
        return bridges;
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
