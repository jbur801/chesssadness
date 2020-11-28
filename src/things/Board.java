package things;

import enums.Colour;
import pieces.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {
    private static final String pathToCsv = "Resources/initBoardState.csv";


    private GridSquare[][] squares;
    private Player black;
    private Player white;

    public Board(){
        squares = new GridSquare[8][8];
        for(int i =0;i<8;i++){
            for(int j =0;j<8;j++){
                squares[i][j] = new GridSquare(i,j,this);
            }
        }
        black = new Player(Colour.BLACK);
        white = new Player(Colour.WHITE);
    }

    public void init(){
        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader(pathToCsv));

            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] pieces = row.split(",");
                for(String piece:pieces){
                    String[] data = piece.split(":");
                    Player owner = checkOwner(data[0]);
                    int xpos = Integer.parseInt(data[1]);
                    int ypos = Integer.parseInt(data[2]);
                    Piece thePiece = getPiece(data[3],owner);
                    squares[ypos][xpos].moveHere(thePiece);
                }
            }
            csvReader.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Player checkOwner(String datum) {
        switch(datum){
            case("BLACK"):
                return black;
            case("WHITE"):
                return white;
        }
        return null;
    }


    public void printState(){
        StringBuilder sb = new StringBuilder();
        sb.append("BOARD\n-------------\n  A B C D E F G H\n");
        for(int i =7;i>=0;i--){
            char c = (char)(i+65);
            sb.append(i+1);

            for(int j =0;j<8;j++){
                sb.append(" ");
                sb.append(squares[i][j].output());
            }
            sb.append("\n");
        }
        sb.append(white.liveString());
        System.out.println(sb);
    }

    public GridSquare getSquare(int xpos, int ypos) {
        return squares[ypos][xpos];
    }

    private static Piece getPiece(String datum,Player player) {
        switch(datum){
            case("Pawn"):
                return new Pawn(player);
            case("Rook"):
                return new Rook(player);
            case("Bishop"):
                return new Bishop(player);
            case("Knight"):
                return new Knight(player);
            case("Queen"):
                return new Queen(player);
            case("King"):
                return new King(player);
        }
        return null;
    }
}
