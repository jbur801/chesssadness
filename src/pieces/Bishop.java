package pieces;

import enums.Colour;
import things.Board;
import things.Player;
import things.Vec2;

import java.util.List;

public class Bishop extends Piece{


    public Bishop(Player player) {
        super(player);
    }

    @Override
    public String toFullString(){
        return super.toFullString() + ", Type: Bishop";
    }

    @Override
    List<Vec2> possibleMoves() {
        return null;
    }

    @Override
    public String toString(){
        return "b";
    }

    @Override
    public boolean canMove(int x, int y) {
        return false;
    }
}
