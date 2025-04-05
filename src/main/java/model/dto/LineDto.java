package model.dto;

import java.util.List;

public class LineDto {
    private final List<Boolean> bridges;

    public LineDto(List<Boolean> bridges) {
        this.bridges = bridges;
    }

    public List<Boolean> getBridges() {
        return bridges;
    }
}