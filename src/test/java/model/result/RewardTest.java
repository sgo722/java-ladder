package model.result;

import model.person.PersonNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RewardTest {

    @DisplayName("보상에_빈칸이_오면_예외가_발생한다")
    @Test
    void rewardNameNotEmpty(){
        //given
        String name = "";

        assertThrows(IllegalArgumentException.class, () -> new Reward(name));
    }

    @DisplayName("보상에_빈칸이_오면_예외가_발생한다")
    @Test
    void rewardNameNotNull(){
        //given
        String name = null;

        assertThrows(IllegalArgumentException.class, () -> new Reward(name));
    }

    @Test
    @DisplayName("사람순으로_보상의_인덱스와_매핑한다")
    void mappingPersonToReward() {
        PersonNames names = new PersonNames("a,b,c");

        Rewards rewards = new Rewards("꽝,1000원,5000원");

        List<Integer> mapping = List.of(1, 2, 0);

        Map<String, String> result = rewards.calculate(mapping, names);

        assertThat(result)
                .containsExactlyInAnyOrderEntriesOf(Map.of(
                        "a", "1000원",
                        "b", "5000원",
                        "c", "꽝"
                ));
    }

}