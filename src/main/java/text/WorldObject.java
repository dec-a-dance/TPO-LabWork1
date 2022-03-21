package text;

import lombok.Getter;
import lombok.Setter;

abstract class WorldObject {
    private String name;

    @Getter
    @Setter
    private Movement movement;

    @Getter
    @Setter
    private Coordinates coordinates;

    void moveTo(WorldObject o, MovementType type){
        this.setMovement(new Movement());
        this.getMovement().setGoal(o);
        this.getMovement().setType(type);
        Coordinates cor = new Coordinates();
        cor.setX(o.getCoordinates().getX());
        cor.setY(o.getCoordinates().getY());
        this.getMovement().setDestination(cor);
        System.out.println(this.getMovement());
    }

    boolean moveTo(int x, int y, MovementType type){
        this.setMovement(new Movement());

        Coordinates cor = new Coordinates();
        if (!cor.setX(x)){
            return false;
        };
        if(!cor.setY(y)){
            return false;
        }
        this.getMovement().setGoal(null);
        this.getMovement().setType(type);
        this.getMovement().setDestination(cor);
        return false;
    }
}
