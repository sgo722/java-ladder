package model.line.generator;

import model.line.Line;
import model.util.BooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomLineGeneratorTest {

    @DisplayName("연결지점은_참여자보다_1개_적은_수만큼_생성된다")
    @Test
    void connectPointlessThanPersonCount(){
        //given
        BooleanGenerator booleanGenerator = () -> true;
        RandomLineGenerator randomLineGenerator = new RandomLineGenerator();
        int personCount = 5;
        //when

        Line line = randomLineGenerator.generate(personCount);
        //then
        assertThat(line.exportBridgesForView()).size().isEqualTo(personCount - 1);
    }

    @DisplayName("true만_반환할경우_상태는_교차로_생성된다")
    @Test
    void toggleBridgeStatus(){
        //given
        BooleanGenerator booleanGenerator = () -> true;
        RandomLineGenerator randomLineGenerator = new RandomLineGenerator(booleanGenerator);
        int personCount = 5;
        //when

        Line line = randomLineGenerator.generate(personCount);
        //then
        assertThat(line.exportBridgesForView()).containsExactly(true,false,true,false);
    }

    @DisplayName("false만_반환할경우_상태는_교차로_생성된다")
    @Test
    void noBridge(){
        //given
        BooleanGenerator booleanGenerator = () -> false;
        RandomLineGenerator randomLineGenerator = new RandomLineGenerator(booleanGenerator);
        int personCount = 5;
        //when

        Line line = randomLineGenerator.generate(personCount);
        //then
        assertThat(line.exportBridgesForView()).containsExactly(false,false,false,false);
    }
}