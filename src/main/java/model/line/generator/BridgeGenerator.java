package model.line.generator;

import model.line.Bridge;

import java.util.List;

public interface BridgeGenerator {

    List<Bridge> generate(int personCount);
}
