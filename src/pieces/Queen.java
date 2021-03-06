package pieces;

import enums.Colour;
import things.Board;
import things.Player;
import things.Vec2;

import java.util.List;

public class Queen extends Piece{

    public Queen(Player player) {
        super(player);
    }

    @Override
    public String toFullString(){
        return super.toFullString() + ", Type: Queen";
    }

    @Override
    List<Vec2> possibleMoves() {
        return null;
    }

    @Override
    public String toString(){
        return "q";
    }

    @Override
    public boolean canMove(int x, int y) {
        return false;
    }
}
