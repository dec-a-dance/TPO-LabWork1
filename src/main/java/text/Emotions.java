package text;

import lombok.Getter;

public enum Emotions {
    CALM("спокойный"),
    PANIC("паника"),
    FEAR("страх"),
    ANGER("злость"),
    HAPPINESS("радость");
    @Getter
    private final String name;

    Emotions(String name){
        this.name = name;
    }
}
