package text;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Character extends WorldObject {
    private String name;

    @Getter
    @Setter
    private Coordinates coordinates;

    @Getter
    @Setter
    private Movement movement;

    @Getter
    @Setter
    private Emotions emotion;
}
