package text;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovementTypeTest {

    @ParameterizedTest
    @CsvSource(value = {
            "UNSTOPPABLE, неумолимо",
            "SLOW,медленно",
            "FAST, быстро"
    })
    void checkMovementTypeDescription(String name, String description) {
        assertEquals(description, MovementType.valueOf(name).getName());
    }
}
