package Game;


public class Main {


    public static void main(String[] args)  {

	    GameBoard Board = new GameBoard( 25, 25);

        new GameFrame(Board, "Game1", 25);

    }

}