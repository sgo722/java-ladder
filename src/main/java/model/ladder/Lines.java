package model.ladder;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    // Line의 일급 컬렉션
    private final List<Line> lines;
    // 라인을 만든다. 라인을 체크한다.

    public Lines(int personCount, int height){
        lines = makeLines(personCount, height);
    }

    private List<Line> makeLines(int personCount, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(personCount));
        }
        return lines;
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }
    // 라인을 검사한다.
}
