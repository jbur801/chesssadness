package pieces;

import enums.Colour;
import things.Board;
import things.Player;
import things.Vec2;

import java.util.List;

public class Knight extends Piece{


    public Knight(Player player) {
        super(player);
    }

    @Override
    public String toFullString(){
        return super.toFullString() + ", Type: Knight";
    }

    @Override
    List<Vec2> possibleMoves() {
        return null;
    }

    @Override
    public String toString(){
        return "k";
    }

    @Override
    public boolean canMove(int x, int y) {
        return false;
    }
}
