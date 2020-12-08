package Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouseListener implements MouseListener {
    private final int GameSquareSize;
    GameBoard TheGameBoard;
    GameVisual TheGamesVisual;

    public GameMouseListener(int squareSize, GameBoard Board, GameVisual GameVisual) {
        GameSquareSize = squareSize;
        TheGameBoard=Board;
        TheGamesVisual =GameVisual;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        TheGameBoard.changeCellState((e.getY()-30)/GameSquareSize, (e.getX()-9)/GameSquareSize );
        TheGamesVisual.Refresh();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
