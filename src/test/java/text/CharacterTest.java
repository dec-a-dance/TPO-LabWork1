package text;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    Character character = new Character();


    @Test
    void checkMovementToEmpty(){
        Furniture fur = new Furniture();
        assertThrows(NullPointerException.class, () -> character.moveTo(fur, MovementType.SLOW));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 10",
            "1, 2",
            "50, 100",
    })
    void checkMovementToCords(int x, int y){
        character.moveTo(x, y, MovementType.SLOW);
        assertAll(
                () -> assertEquals(x, character.getMovement().getDestination().getX()),
                () -> assertEquals(y, character.getMovement().getDestination().getY())
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-5, -10",
            "0, -2",
            "-3, 0",
    })
    void checkMovementToWrongCords(int x, int y){
        assertFalse(character.moveTo(x, y, MovementType.SLOW));
    }
}
