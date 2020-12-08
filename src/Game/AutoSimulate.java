package Game;

public class AutoSimulate implements Runnable {
    private boolean running = true;
    private GameBoard Board;
    private GameVisual GV;

    public AutoSimulate(GameBoard Board, GameVisual GV){
        this.Board = Board;
        this.GV = GV;
    }

    @Override
    public void run() {
        while(true){
            if(running){
                try {
                    Thread.sleep(1000);
                    Board.nextGeneration();
                    GV.Refresh();
                } catch (InterruptedException e) {
                    running = false;
                }
            }else{
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    running = true;
                }
            }

        }

    }
}
