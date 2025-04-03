package model.person;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PersonNameTest {

    @Test
    void 빈_이름이_들어올_경우_예외가_발생한다(){
        //given
        String input = "";
        //when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PersonName(input));
    }

    @Test
    void 글자길이가_6인_경우_예외가_발생한다(){
        //given
        String input = "abcdef";
        //when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PersonName(input));
    }

    @Test
    void 글자길이가_5인_경우_생성된다(){
        //given
        String input = "abcde";
        //when
        PersonName personName = new PersonName(input);
        //then
        Assertions.assertEquals(input, personName.exportNameForView());
    }

}