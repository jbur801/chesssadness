package things;

import enums.Colour;
import pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private Colour colour;
    private List<Piece> deadPieces;
    private List<Piece> livePieces;

    public Player(Colour color) {
        this.colour = color;
        this.deadPieces = new ArrayList<>();
        this.livePieces = new ArrayList<>();
    }

    public String liveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(colour+":\n------\n");

        for(Piece piece: livePieces){
            sb.append(piece.toFullString() +"\n");
        }
        return sb.toString();
    }

    public void addPiece(Piece piece){
        livePieces.add(piece);
    }

    public void move(){
        boolean success = false;
        Scanner input = new Scanner(System.in);
        while(success == false) {
            System.out.println("make ur move");
            String move = input.nextLine();
            if(move.matches());
        }
    }

    public void killPiece(Piece piece){
        livePieces.remove(piece);
        deadPieces.add(piece);
    }

    public Colour getColour(){
        return colour;
    }
}
