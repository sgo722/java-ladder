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

    public List<Integer> play() {
        List<Integer> results = new ArrayList<>();
        for(int player = 0; player < this.lines.size(); player++) {
            int playerIdx = player;
            int height = 0;
            while(height < lines.size()){
                playerIdx = lines.get(height).move(playerIdx);
                height++;
            }
            results.add(playerIdx);
        }

        return results;
    }

    private Line getLine(int player) {
        return lines.get(player);
    }
}
