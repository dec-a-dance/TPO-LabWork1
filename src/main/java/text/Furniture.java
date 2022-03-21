package text;

import lombok.Getter;
import lombok.Setter;

public class Furniture extends WorldObject {
    private String name;

    @Getter
    @Setter
    private Coordinates coordinates;

    @Getter
    @Setter
    private Movement movement;
}
