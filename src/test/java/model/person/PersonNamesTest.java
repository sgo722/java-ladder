package model.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonNamesTest {

    @DisplayName("사람이름은_null이_포함될_수_없다")
    @Test
    void personNamesIsNull(){
        //given
        String personName = null;

        //when - then
        assertThrows(IllegalArgumentException.class, ()->{new PersonNames(personName);});
    }

    @DisplayName("사람이름은_중복될_수_없다")
    @Test
    void duplicatePersonNames(){
        //given
        String personName = "양,양";

        //when - then
        assertThrows(IllegalArgumentException.class, ()->{new PersonNames(personName);});
    }

    @DisplayName("중복되지_않는_이름을_가진_두명이_생성된다")
    @Test
    void notDuplicateTwoPersonName(){
        //given
        String personName = "양,준";

        //when
        PersonNames personNames = new PersonNames(personName);
        // then
        assertThat(personNames.getPersonNames()).hasSize(2);
    }

}