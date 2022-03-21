package text;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmotionsTest {
    @ParameterizedTest
    @CsvSource(value = {
            "CALM, спокойный",
            "PANIC, паника",
            "FEAR, страх",
            "ANGER, злость",
            "HAPPINESS, радость"
    })
    void checkEmotionsDescription(String name, String description) {
        assertEquals(description, Emotions.valueOf(name).getName());
    }
}
