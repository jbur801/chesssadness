package pieces;

import enums.Colour;
import things.Board;
import things.Player;
import things.Vec2;

import java.util.List;

public class Rook extends Piece{


    public Rook(Player player) {
        super(player);
    }

    @Override
    public String toFullString(){
        return super.toFullString() + ", Type: Rook";
    }

    @Override
    List<Vec2> possibleMoves() {
        return null;
    }

    @Override
    public String toString(){
        return "r";
    }

    @Override
    public boolean canMove(int x, int y) {
        return false;
    }
}
