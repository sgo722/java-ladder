package model.line;

import model.line.generator.LineGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Integer> play(int personCount) {
        List<Integer> results = new ArrayList<>();

        for(int playerIdx = 0; playerIdx < personCount; playerIdx++) {
            int arriveIdx = playerIdx;
            int height = 0;
            while(height < lines.size()){
                arriveIdx = lines.get(height).move(arriveIdx);
                height++;
            }
            results.add(arriveIdx);
        }

        return results;
    }
}
