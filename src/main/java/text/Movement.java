package text;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Movement{
    @Setter
    @Getter
    private WorldObject goal;
    @Setter
    @Getter
    private MovementType type;
    @Setter
    @Getter
    private Coordinates destination;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return Objects.equals(goal, movement.goal) && type == movement.type && Objects.equals(destination, movement.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goal, type, destination);
    }
}
