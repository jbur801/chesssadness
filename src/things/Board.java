package things;

public class Board {
    private GridSquare[][] squares;

    public Board(){
        squares = new GridSquare[8][8];
        for(int i =0;i<8;i++){
            for(int j =0;j<8;j++){
                squares[i][j] = new GridSquare(i,j);
            }
        }
    }

    public void printState(){
        StringBuilder sb = new StringBuilder();
        sb.append("BOARD\n-------------\n  A B C D E F G H\n");
        for(int i =0;i<8;i++){
            char c = (char)(i+65);
            sb.append(i+1);

            for(int j =0;j<8;j++){
                sb.append(" ");
                sb.append(squares[i][j].toString());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
