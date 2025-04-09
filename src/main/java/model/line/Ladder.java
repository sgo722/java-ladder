package model.line;

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

    public Ladder addLine(int personCount) {
        List<Line> newLines = new ArrayList<>(this.lines);
        newLines.add(new Line(personCount));
        return new Ladder(newLines);
    }

    public List<Line> getLines(){
        return lines;
    }

    public List<Integer> play(int personCount) {
        List<Integer> results = new ArrayList<>();

        for (int playerIdx = 0; playerIdx < personCount; playerIdx++) {
            results.add(calculateArrivalIndex(playerIdx));
        }

        return results;
    }

    private int calculateArrivalIndex(int startIndex) {
        int currentIndex = startIndex;

        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }

        return currentIndex;
    }
}
