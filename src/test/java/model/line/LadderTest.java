package model.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @DisplayName("사다리_게임을_실행한_결과가_일치하는지_확인한다")
    @Test
    void validatePlay(){
        //given
        int personCount = 4;
        Line line1 = new Line(List.of(Bridge.CONNECTED,Bridge.NOT_CONNECTED,Bridge.CONNECTED));
        Line line2 = new Line(List.of(Bridge.NOT_CONNECTED,Bridge.CONNECTED,Bridge.NOT_CONNECTED));
        Line line3 = new Line(List.of(Bridge.CONNECTED,Bridge.NOT_CONNECTED,Bridge.CONNECTED));
        Ladder ladder = new Ladder(List.of(line1,line2,line3));
        //when
        List<Integer> result = ladder.play(personCount);

        //then
        assertThat(result).containsExactly(3,1,2,0);
    }

    @DisplayName("사다리_게임을_실행한_결과가_일치하는지_확인한다")
    @Test
    void validatePlayNotConnected(){
        //given
        int personCount = 4;
        Line line1 = new Line(List.of(Bridge.NOT_CONNECTED,Bridge.NOT_CONNECTED,Bridge.NOT_CONNECTED));
        Line line2 = new Line(List.of(Bridge.NOT_CONNECTED,Bridge.NOT_CONNECTED,Bridge.NOT_CONNECTED));
        Line line3 = new Line(List.of(Bridge.NOT_CONNECTED,Bridge.NOT_CONNECTED,Bridge.NOT_CONNECTED));
        Ladder ladder = new Ladder(List.of(line1,line2,line3));
        //when
        List<Integer> result = ladder.play(personCount);

        //then
        assertThat(result).containsExactly(0,1,2,3);
    }

}