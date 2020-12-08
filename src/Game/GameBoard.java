package Game;

public class GameBoard {
    int MaxY;
    int MaxX;

    private Cell[][] CellGrid;


    public GameBoard( int MaxY,int MaxX ){
        this.MaxY = MaxY;
        this.MaxX = MaxX;
        CellGrid = new Cell[MaxY][MaxX];

        for (int Y=0; Y<MaxY; Y++){
            for (int X=0; X<MaxX; X++){
                CellGrid[Y][X] = new Cell();

            }
        }
    }

    public void loadGameBoard(boolean[][] BoardInput){
        for (int Y=0; Y<BoardInput.length; Y++){
            for (int X=0; X<BoardInput[Y].length; X++){
                CellGrid[Y][X].SetNextGeneration(BoardInput[Y][X]);
            }
        }
        enableNewGeneration();
    }

    public void nextGeneration(){
        determineNewGeneration();
        enableNewGeneration();
    }

    private void determineNewGeneration() {
        for (int Y=0; Y<MaxY; Y++){
            for (int X=0; X<MaxX; X++){
                int nr = neighbourSumAt(Y,X);
                if (nr < 2) { CellGrid[Y][X].SetNextGeneration(false);}
                else if (nr > 3) { CellGrid[Y][X].SetNextGeneration(false);}
                else if (nr == 3) { CellGrid[Y][X].SetNextGeneration(true);}
                else if (nr == 2) { CellGrid[Y][X].SetNextGeneration(CellGrid[Y][X].GetGenerationState());}
            }
        }
    }

    public int neighbourSumAt(int Y, int X) {
        int Sum=0;
        // Positions numbered as phone dial
        if (Y != 0 && X != 0){    //1
            if(isAlive(Y-1,X-1)){
                Sum++;
            }
        }

        if (Y != 0){
            if(isAlive(Y-1,X)){ //2
                Sum++;
            }
        }

        if (Y != 0 && X != MaxX-1){//3
            if(isAlive(Y-1,X+1)){
                Sum++;
            }
        }
        if (X != 0){
            if(isAlive(Y,X-1)){ //4
                Sum++;
            }
        }
        //self
        if (X != MaxX-1){
            if(isAlive(Y,X+1)){ //6
                Sum++;
            }
        }

        if (Y != MaxY-1 && X != 0){
            if(isAlive(Y+1,X-1)){ //7
                Sum++;
            }
        }

        if (Y != MaxY-1){
            if(isAlive(Y+1,X)){ //8
                Sum++;
            }
        }

        if (Y != MaxY-1 && X != MaxX-1){
            if(isAlive(Y+1,X+1)){ //9
                Sum++;
            }
        }

        return Sum;
    }

    public boolean isAlive(int Y, int X) {
        if(Y<MaxY && X<MaxX){
            return CellGrid[Y][X].GetGenerationState();
        }else{
            return false;
        }

    }

    private void enableNewGeneration() {
        for (int Y=0; Y<MaxY; Y++){
            for (int X=0; X<MaxX; X++){
                CellGrid[Y][X].UpdateGenerationState();
            }
        }
    }

    public void changeCellState( int Y,int X){
        if(Y<MaxY && X<MaxX){
            CellGrid[Y][X].ImmediateChangeState();
        }

    }

    public int getBoardMaxX(){
        return MaxX;
    }

    public int getBoardMaxY(){
        return MaxY;
    }

    public boolean[][] getCellGridValues(){
        boolean[][] ReturnValues = new boolean[MaxY][MaxX];
        for (int Y=0; Y<MaxY; Y++){
            for (int X=0; X<MaxX; X++){
                ReturnValues[Y][X] = CellGrid[Y][X].GetGenerationState();
            }
        }
        return ReturnValues;

    }


}
