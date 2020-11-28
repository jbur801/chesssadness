package things;

import enums.Colour;
import enums.Direction;
import pieces.Piece;

public class GridSquare {
    private final Board board;
    private Piece piece = null;
    private boolean occupied;
    private GridSquare left;
    private GridSquare right;
    private GridSquare up;
    private GridSquare down;
    private int xpos;
    private int ypos;
    private String colour;
    public GridSquare(int i,int j,Board board){
        occupied = false;
        this.board = board;
        xpos = j;
        ypos = i;
    }

    @Override
    public String toString(){
        char c = (char)(xpos +65);
        return String.valueOf(c) + (ypos+1);
    }

    public void setNeighbours(){
        left = board.getSquare(xpos-1,ypos);
        right = board.getSquare(xpos+1,ypos);
        up = board.getSquare(xpos,ypos+1);
        down = board.getSquare(xpos,ypos-1);
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

    public boolean moveHere(Piece newPiece){
        if(piece ==null){
            occupied=true;
        }else if(!piece.isColour(newPiece.getColour())){
            piece.taken();
        }else{
            System.out.println(piece.toFullString());
            System.out.println(this.xpos + " " + this.ypos);
            return false;
        }
        piece = newPiece;
        GridSquare wah = newPiece.getCurrentSquare();
        if(wah!= null){
            wah.empty();
        }
        newPiece.setCurrentSquare(this);
        return true;
    }


    private GridSquare getNeighbour(Direction direction){
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
        return newSquare;
    }
    //private GridSquare ree(getSquare)

    protected GridSquare attemptTraverse(Direction direction,Colour color) {
        GridSquare newSquare = getNeighbour(direction);

        //TODO CARE BUG ALERT
        if(!newSquare.legal(color)){
            newSquare =null;
        }
        return newSquare;
    }

    private boolean legal(Colour color) {
        //TODO CARE BUG ALERT
        return occupied|!piece.isColour(color);
    }

    public String output(){
        String content = "   ";
        if(occupied){
            return piece.getFont() +colour+ " " + piece.toString() + " " + Colours.RESET;
        }
        return colour + content + Colours.RESET;
    }


    public void setColour(int i) {
        if(i ==0){
            colour = Colours.PURPLE_BACKGROUND;
        }
        else{
            colour = Colours.YELLOW_BACKGROUND;
        }
    }


    public GridSquare traverse(int d, Direction direction) {
        GridSquare next = getNeighbour(direction);
        System.out.println(next.toString());

        if(d>0){
            d--;
            try{return next.traverse(d,direction);}
            catch(NullPointerException e){
                System.out.println("Traverse: " + d);
                return null;
            }
        }
        return this;
    }

    public void empty() {
        piece=null;
        occupied=false;
    }
}
