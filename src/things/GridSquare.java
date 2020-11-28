package things;

import enums.Colour;
import enums.Direction;
import pieces.Piece;

public class GridSquare {
    private final Board board;
    private Piece piece;
    private boolean occupied;
    private GridSquare left;
    private GridSquare right;
    private GridSquare up;
    private GridSquare down;
    private int xpos;
    private int ypos;
    public GridSquare(int i,int j,Board board){
        occupied = false;
        this.board = board;
        xpos = i;
        ypos = j;
    }

    @Override
    public String toString(){
        char c = (char)(xpos +65);
        return String.valueOf(c) + (ypos+1);
    }

    public void setNeighbours(){
        left = board.getSquare(xpos-1,ypos);
        right = board.getSquare(xpos+1,ypos);
        up = board.getSquare(xpos,ypos-1);
        down = board.getSquare(xpos,ypos+1);
    }

    public boolean containsPiece(){
        return occupied;
    }

    public boolean containsPiece(Colour color){
        if(!occupied){
            return false;
        }
        return piece.isColour(color);
    }

    public void moveHere(Piece newPiece){
        if(piece ==null){
            occupied=true;
            piece = newPiece;
        }else {
            piece.taken();
            piece = newPiece;
        }
        newPiece.setCurrentSquare(this);
        System.out.println(piece);
    }

    protected GridSquare attemptTraverse(Direction direction,Colour color) {
        GridSquare newSquare;
        switch(direction){
            case UP:
                newSquare = up;
                break;
            case DOWN :
                newSquare =down;
                break;
            case LEFT :
                newSquare = left;
                break;
            case RIGHT :
                newSquare = right;
                break;
            default:
                newSquare=null;
        }
        //TODO CARE BUG ALERT
        if(newSquare!=null & newSquare.legal(color)){
            return newSquare;
        }
    }

    private boolean legal(Colour color) {
        //TODO CARE BUG ALERT
        return occupied|!piece.isColour(color);
    }

    public String output(){
        if(occupied){
            return piece.toString();
        }
        return "*";
    }
}
