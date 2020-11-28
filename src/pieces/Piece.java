package pieces;

import enums.Colour;
import enums.Direction;
import things.Board;
import things.GridSquare;
import things.Player;
import things.Vec2;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    private static int count=0;
    private int id;
    private Player player;
    private GridSquare currentSquare;

    public Piece(Player player){
        this.player = player;
        count++;
        id =count;
        player.addPiece(this);
    }

    public void setCurrentSquare(GridSquare gridSquare){
        currentSquare = gridSquare;
    }

    public GridSquare getCurrentSquare() {
        return currentSquare;
    }

    public boolean isColour(Colour color){
        return color.equals(this.player.getColour());
    }

    public String toFullString(){
        return "id: " + id + ", square: " + currentSquare.toString();
    }

    public void taken(){
        return;
    }

    abstract List<Vec2> possibleMoves();

    public abstract boolean canMove(int x, int y);



    protected List<Vec2> attemptTraverse(Direction direction, List<Vec2> moves) {

    }

    // public Pattern getMovementPattern();

}
