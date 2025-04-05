package model.line;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("연속된 연결이 있는 경우 예외가 발생한다")
    @Test
    void overlap(){
        //given
        ArrayList<Bridge> bridges = new ArrayList<>();
        bridges.add(Bridge.CONNECTED);
        bridges.add(Bridge.CONNECTED);

        assertThrows(IllegalArgumentException.class, () -> new Line(bridges));
    }

}