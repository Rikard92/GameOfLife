package Game;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


class GameBoardTest {

    @Test
    void createGameBoard() {
        GameBoard TestBord = new GameBoard(25,25);

        Assert.assertThat(TestBord.MaxY, CoreMatchers.is(25));
        Assert.assertThat(TestBord.MaxX, CoreMatchers.is(25));
    }
    @Test
    void loadGameBoard() {

        GameBoard TestBord = new GameBoard( 5, 5);
        boolean[][] BoardInput = {{false,false,false,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,false,false,false}};
        TestBord.loadGameBoard(BoardInput);
        Assert.assertThat(TestBord.getCellGridValues(), CoreMatchers.is(BoardInput));

    }

    @Test
    void nextGeneration() {
        GameBoard TestBord = new GameBoard( 5, 5);
        boolean[][] BoardInput = {{false,false,false,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,false,false,false}};
        TestBord.loadGameBoard(BoardInput);
        TestBord.nextGeneration();
        boolean[][] Expectation = {{false,false,false,false,false},
                {false,false,false,false,false},
                {false,true,true,true,false},
                {false,false,false,false,false},
                {false,false,false,false,false}};

        Assert.assertThat(TestBord.getCellGridValues(), CoreMatchers.is(Expectation));
    }

    @Test
    void
    neighbourSumAt1() {
        GameBoard TestBord = new GameBoard( 5, 5);
        boolean[][] BoardInput = {{false,false,false,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,false,false,false}};
        TestBord.loadGameBoard(BoardInput);
        Assert.assertThat(TestBord.neighbourSumAt(2,2), CoreMatchers.is(2));
    }

    @Test
    void neighbourSumAt2() {
        GameBoard TestBord = new GameBoard( 5, 5);
        boolean[][] BoardInput = {{false,false,false,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false}};
        TestBord.loadGameBoard(BoardInput);
        Assert.assertThat(TestBord.neighbourSumAt(4,2), CoreMatchers.is(1));
    }

    @Test
    void isAlive1() {
        GameBoard TestBord = new GameBoard( 5, 5);
        boolean[][] BoardInput = {{false,false,false,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,false,false,false}};
        TestBord.loadGameBoard(BoardInput);
        Assert.assertThat(TestBord.isAlive(1,1), CoreMatchers.is(false));
    }

    @Test
    void isAlive2() {
        GameBoard TestBord = new GameBoard( 5, 5);
        boolean[][] BoardInput = {{false,false,false,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,false,false,false}};
        TestBord.loadGameBoard(BoardInput);
        Assert.assertThat(TestBord.isAlive(1,2), CoreMatchers.is(true));
    }

    @Test
    void isAliveOutOfBounds() {
        GameBoard TestBord = new GameBoard( 5, 5);

        Assert.assertThat(TestBord.isAlive(11,2), CoreMatchers.is(false));
    }

    @Test
    void changeCellState() {
        GameBoard TestBord = new GameBoard( 5, 5);
        TestBord.changeCellState(2,2);
        Assert.assertThat(TestBord.isAlive(2,2), CoreMatchers.is(true));
    }

}