package model.ladder;

import model.dto.LineDto;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    // Line의 일급 컬렉션
    private final List<Line> lines;

    public Lines(){
        this.lines = new ArrayList<>();
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines addLine(int personCount) {
        this.lines.add(new Line(personCount));
        return new Lines(lines);
    }

    public List<LineDto> toDto(){
        return lines.stream()
                .map(Line::toDto)
                .toList();
    }
}
