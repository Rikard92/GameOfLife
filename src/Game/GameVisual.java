package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class GameVisual extends JPanel {
    GameBoard TheGameBoard;
    int SquareSize;

    public GameVisual(GameBoard Board, int SizeOfSquares){

        TheGameBoard=Board;
        SquareSize = SizeOfSquares;

    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, TheGameBoard.getBoardMaxX()*25, TheGameBoard.getBoardMaxY()*25);
        g2d.setColor(Color.BLACK);

        for(int Y= 0; Y< TheGameBoard.MaxY; Y++){
            for(int X= 0; X< TheGameBoard.MaxX; X++){
                if(TheGameBoard.isAlive(Y,X)){
                    g2d.fillRect(X*SquareSize, Y*SquareSize, SquareSize, SquareSize);
                }else{
                    g2d.drawRect(X*SquareSize, Y*SquareSize, SquareSize, SquareSize);
                }

            }
        }
    }
    public void Refresh(){
        repaint();
    }

}
