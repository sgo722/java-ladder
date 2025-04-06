package model.mapper;

import model.dto.LineDto;
import model.line.Line;
import model.line.Ladder;

import java.util.ArrayList;
import java.util.List;

public class LineMapper {
    public List<LineDto> toDto(Ladder ladder){
        List<LineDto> lineDtos = new ArrayList<>();
        for (Line line : ladder.getLines()) {
            lineDtos.add(toDto(line));
        }

        return lineDtos;
    }

    private LineDto toDto(Line line){
        return new LineDto(line.exportBridgesForView());
    }
}
