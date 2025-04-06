package model.line;

import model.line.generator.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    // Line의 일급 컬렉션
    private final List<Line> lines;

    public Ladder(){
        this.lines = new ArrayList<>();
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder addLine(int personCount, LineGenerator lineGenerator) {
        List<Line> newLines = new ArrayList<>(this.lines);
        newLines.add(lineGenerator.generate(personCount));
        return new Ladder(newLines);
    }

    public List<Line> getLines(){
        return lines;
    }
}
