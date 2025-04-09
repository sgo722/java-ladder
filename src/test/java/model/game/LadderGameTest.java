package model.game;

import model.line.LadderFactory;
import model.line.generator.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class LadderGameTest {

    @DisplayName("사람수와_보상수가_다를_경우_예외가_발생한다")
    @Test
    void differentCount(){
        //given
        LadderGameFactory ladderGameFactory = new LadderGameFactory(new LadderFactory(), new RandomLineGenerator());
        String PersonNameStr = "양,준";
        String resultStr = "꽝";
        String heightStr = "4";
        //when
        assertThrows(IllegalArgumentException.class, () -> {
            ladderGameFactory.create(PersonNameStr, resultStr, heightStr);
        });
    }

    @DisplayName("게임시작_전에_사용자_결과_출력_시_예외가_발생한다")
    @Test
    void beforePlayResultForException(){
        //given
        LadderGameFactory ladderGameFactory = new LadderGameFactory(new LadderFactory(), new RandomLineGenerator());
        String PersonNameStr = "양,준";
        String resultStr = "꽝,5000";
        String heightStr = "4";
        LadderGame ladderGame = ladderGameFactory.create(PersonNameStr, resultStr, heightStr);

        //when
        assertThrows(IllegalArgumentException.class, () ->{
            ladderGame.getResultFor("양");
        });
    }

    @DisplayName("게임시작_전에_전체사용자_결과_출력_시_예외가_발생한다")
    @Test
    void beforePlayResultAllException(){
        //given
        LadderGameFactory ladderGameFactory = new LadderGameFactory(new LadderFactory(), new RandomLineGenerator());
        String PersonNameStr = "양,준";
        String resultStr = "꽝,5000";
        String heightStr = "4";
        LadderGame ladderGame = ladderGameFactory.create(PersonNameStr, resultStr, heightStr);

        //when
        assertThrows(IllegalArgumentException.class, ladderGame::getAllResults);
    }

    @DisplayName("게임시작_후_게임결과가_캐시에_저장된다")
    @Test
    void afterPlaySaveResult(){
        //given
        LadderGameFactory ladderGameFactory = new LadderGameFactory(new LadderFactory(), new RandomLineGenerator());
        String PersonNameStr = "양,준";
        String resultStr = "꽝,5000";
        String heightStr = "4";
        LadderGame ladderGame = ladderGameFactory.create(PersonNameStr, resultStr, heightStr);

        //when
        ladderGame.play();

        assertThat(ladderGame.getAllResults().size()).isEqualTo(2);
    }
}