package model.line;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("연속된_연결이_있는_경우_예외가_발생한다")
    @Test
    void overlap(){
        //given
        ArrayList<Bridge> bridges = new ArrayList<>();
        bridges.add(Bridge.CONNECTED);
        bridges.add(Bridge.CONNECTED);

        assertThrows(IllegalArgumentException.class, () -> new Line(bridges));
    }

}