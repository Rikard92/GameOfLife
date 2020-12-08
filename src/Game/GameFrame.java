package Game;

import javax.swing.*;
import java.awt.*;

public class GameFrame {

    public GameFrame(GameBoard Board, String TitleName, int SquareSize) {
        JFrame GameFrame = new JFrame();
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameFrame.setSize(Board.MaxX*SquareSize+17, Board.MaxY*SquareSize+72);
        GameFrame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - GameFrame.getWidth())/2,(Toolkit.getDefaultToolkit().getScreenSize().height - GameFrame.getHeight())/2);
        GameFrame.setTitle(TitleName);

        GameVisual GV = new GameVisual(Board, SquareSize);
        GV.setLayout(null);
        JButton button1 = new JButton("Next Generation");
        button1.setBounds(GameFrame.getSize().width/2-65, Board.MaxY*SquareSize+2, 130, 30);
        button1.addActionListener(e -> {
            Board.nextGeneration();
            GV.Refresh();
        });
        GV.add(button1);


        GameMouseListener GML = new GameMouseListener(SquareSize, Board, GV);
        GameFrame.addMouseListener(GML);

        GameFrame.add(GV);
        GameFrame.setVisible(true);
    }


}
