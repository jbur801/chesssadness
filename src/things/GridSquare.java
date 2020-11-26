package things;

public class GridSquare {
    private Piece piece;
    private boolean occupied;
    public GridSquare(int i,int j){
        occupied = false;
    }

    public boolean containsPiece(){
        return occupied;
    }

    @Override
    public String toString(){
        if(occupied){
            return piece.toString();
        }
        return "*";
    }
}
