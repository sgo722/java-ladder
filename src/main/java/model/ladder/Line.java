package model.ladder;

import util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;
    private final RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();

    public Line(int personCount){
        // 라인에 좌표 값 선이 있는 유무를 판단하는 로직 추가
        points = makePoints(personCount);
    }

    private List<Boolean> makePoints(int personCount){
        List<Boolean> points = new ArrayList<>();
        for(int i=0; i<personCount-1; i++){
            if(i > 0 && points.get(i - 1)){
                points.add(false);
            }else {
                points.add(randomBooleanGenerator.getRandomBoolean());
            }
        }
        return points;
    }

    public List<Boolean> getPoints(){
        return Collections.unmodifiableList(points);
    }
}
