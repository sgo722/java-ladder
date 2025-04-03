package model.ladder;

import model.dto.LineDto;
import util.LineGenerator;
import util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> bridges;
    private final LineGenerator lineGenerator = new RandomBooleanGenerator();

    public Line(int personCount) {
        bridges = makePoints(personCount);
    }

    private List<Boolean> makePoints(int personCount) {
        List<Boolean> bridges = new ArrayList<>();

        for (int bridgeIndex = 0; bridgeIndex < personCount - 1; bridgeIndex++) {
            boolean isExist = bridgeIndex > 0 && bridges.get(bridgeIndex - 1);

            if (isExist) bridges.add(false);
            if (!isExist) bridges.add(lineGenerator.tryGenerate());
        }

        return bridges;
    }

    public List<Boolean> exportBridgesForView() {
        return Collections.unmodifiableList(bridges);
    }
}