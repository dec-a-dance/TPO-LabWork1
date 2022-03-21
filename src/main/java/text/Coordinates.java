package text;

import lombok.AllArgsConstructor;
import lombok.Getter;
public class Coordinates {
    @Getter
    private int x;
    @Getter
    private int y;

    public boolean setX(int x){
        if (x<=0) return false;
        this.x = x;
        return true;
    }
    public boolean setY(int y){
        if (y<=0) return false;
        this.y = y;
        return true;
    }
}
