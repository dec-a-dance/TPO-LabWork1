package text;

import lombok.Getter;

public enum MovementType {
    UNSTOPPABLE("неумолимо"),
    SLOW("медленно"),
    FAST("быстро");

    @Getter
    private final String name;

    MovementType(String name){
        this.name = name;
    }
}
