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
        List<Line> newLines = new ArrayList<>(this.lines);
        newLines.add(new Line(personCount));
        return new Lines(newLines);
    }

    public List<Line> getLines(){
        return lines;
    }
}
