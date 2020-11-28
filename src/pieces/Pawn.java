package pieces;

import enums.Colour;
import things.Board;
import things.GridSquare;
import things.Player;
import things.Vec2;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{
    private boolean hasmoved;

    public Pawn(Player player) {
        super(player);
        hasmoved = false;
    }

    @Override
    public String toFullString(){
        return super.toFullString() + ", Type: Pawn";
    }

    @Override
    List<Vec2> possibleMoves() {
        List<Vec2> moves = new ArrayList<>();
        int limit=1;
        if(!hasmoved){
            limit =2;
        }
        //super.attemptTraverse(0,limit);
        return moves;
    }

    @Override
    public String toString(){
        return "p";
    }

    @Override
    public boolean canMove(int x, int y) {
        return false;
    }
}
