package things;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        board.printState();
        board.init();
        board.printState();
        board.play();
    }
}
