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
            Piece piece=null;
            while(piece == null){
                System.out.println("pik ur piece");
                String inputRegex = "[-]{0,1}[12345678]{1,2}";//TODO 2 electric boogaloo
                //TODO may break me
                int id = Integer.parseInt(input.nextLine());
                for(Piece livePiece:livePieces){
                    if(livePiece.is(id)){
                        piece=livePiece;
                    }
                }
            }
            System.out.println("Selected piece: " + piece.toFullString());
            System.out.println("make ur move");
            System.out.println("x:");
            int x = Integer.parseInt(input.nextLine());
            System.out.println("y:");
            int y = Integer.parseInt(input.nextLine());

            success=piece.move(x,y);
            if(!success){
                System.out.println("NO");
            }
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
