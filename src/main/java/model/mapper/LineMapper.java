package model.mapper;

import model.dto.LineDto;
import model.ladder.Line;
import model.ladder.Lines;

import java.util.ArrayList;
import java.util.List;

public class LineMapper {
    public List<LineDto> toDto(Lines lines){
        List<LineDto> lineDtos = new ArrayList<>();
        for (Line line : lines.getLines()) {
            lineDtos.add(toDto(line));
        }

        return lineDtos;
    }

    private LineDto toDto(Line line){
        return new LineDto(line.exportBridgesForView());
    }
}
