package model.ladder;

import util.LineGenerator;
import util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;
    private final LineGenerator lineGenerator = new RandomBooleanGenerator();

    public Line(int personCount) {
        // 라인에 좌표 값 선이 있는 유무를 판단하는 로직 추가
        points = makePoints(personCount);
    }

    private List<Boolean> makePoints(int personCount) {
        List<Boolean> points = new ArrayList<>();

        for (int bridgeIndex = 0; bridgeIndex < personCount - 1; bridgeIndex++) {
            boolean isExist = bridgeIndex > 0 && points.get(bridgeIndex - 1);

            if (isExist) points.add(false);
            if (!isExist) points.add(lineGenerator.tryGenerate());
        }

        return points;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}