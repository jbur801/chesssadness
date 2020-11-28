package pieces;

import enums.Axis;
import enums.Colour;
import enums.Direction;
import things.*;

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
    public Colour getColour(){
        return player.getColour();
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


    public boolean move(int x, int y){
        Direction xDir = Direction.RIGHT;
        Direction yDir = Direction.UP;
        if(x<0){
            xDir = Direction.LEFT;
            x=-x;
        }
        if(y<0){
            yDir = Direction.DOWN;
            y=-y;
        }
        try{
            GridSquare destination = currentSquare.traverse(x,xDir).traverse(y,yDir);
            System.out.println(destination.toString());
            return destination.moveHere(this);
        } catch(NullPointerException e){
            System.out.println("move");
            return false;}
    }

    protected List<Vec2> attemptTraverse(Direction direction, List<Vec2> moves) {
        return null;
    }

    public String getFont(){
        String font = Colours.BLACK_BOLD;
        if (isColour(Colour.WHITE)) {
            font = Colours.RED_BOLD;
        }
        return font;
    }

    public boolean is(int id){
        if(this.id==id){
            return true;
        }
        return false;
    }
    // public Pattern getMovementPattern();

}
