package model.ladder;

import model.dto.LineDto;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    // Line의 일급 컬렉션
    private final List<Line> lines;

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

    public List<LineDto> toDto(){
        return lines.stream()
                .map(Line::toDto)
                .toList();
    }
}
