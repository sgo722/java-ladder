package model.line.generator;

import model.line.Bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BooleanSupplier;

public class RandomBridgeGenerator implements BridgeGenerator {

    private final BooleanSupplier booleanGenerator;

    public RandomBridgeGenerator() {
        booleanGenerator = () -> ThreadLocalRandom.current().nextBoolean();
    }

    public RandomBridgeGenerator(BooleanSupplier booleanGenerator) {
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
        bridges.add(Bridge.from(booleanGenerator.getAsBoolean()));
    }

    private boolean cannotConnectNextBridge(List<Bridge> bridges) {
        return !bridges.isEmpty() && bridges.get(bridges.size() - 1).isConnected();
    }
}
