package model.ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeightTest {

    @DisplayName("음수가_입력되면_예외가_발생한다")
    @Test
    void 음수가_입력되면_예외가_발생한다(){
        //given
        String input = "-1";
        //when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Height(input));
    }

    @DisplayName("숫자가_아닌_값이_입력되면_이외가_발생한다")
    @Test
    void 숫자가_아닌_값이_입력되면_이외가_발생한다(){
        //given
        String input = "a";
        //when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Height(input));
    }


    @DisplayName("빈칸이_입력되면_예외가_발생한다")
    @Test
    void 빈칸이_입력되면_예외가_발생한다(){
        //given
        String input = " ";
        //when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Height(input));
    }

    @DisplayName("null이_입력되면_예외가_발생한다")
    @Test
    void null이_입력되면_예외가_발생한다() {
        //given
        String input = null;
        //when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Height(input));
    }
}