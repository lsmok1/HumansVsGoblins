import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.util.ArrayList;

public class GameBoard {
    public static void printGameBoard (String[][] gameBoard, Human h1, Goblin g1) {
        String hum = h1.HumUnicode;
        String gob = g1.GobUnicode;
        //creating 2 randomly generated x & y coordinates in increments of 2
//        int randomX = (int) Math.ceil(Math.random() * gameBoard.length-1) * 2;
//        int randomY = (int) Math.ceil(Math.random() * gameBoard.length-1) * 2;
//        int randomX2 = (int) Math.ceil(Math.random() * gameBoard.length-1) * 2;
//        int randomY2 = (int) Math.ceil(Math.random() * gameBoard.length-1) * 2;
//
//
//        while (randomX >= 6 || randomY >= 6 || randomX2 >= 6 || randomY2 >= 6) {
//            randomX = (int) Math.ceil(Math.random() * gameBoard.length - 1) * 2;
//            randomY = (int) Math.ceil(Math.random() * gameBoard.length - 1) * 2;
//            randomX2 = (int) Math.ceil(Math.random() * gameBoard.length - 1) * 2;
//            randomY2 = (int) Math.ceil(Math.random() * gameBoard.length - 1) * 2;
//            if (g1.gobPosition == h1.humPosition) {
//                randomX = (int) Math.ceil(Math.random() * gameBoard.length - 1) * 2;
//                randomY = (int) Math.ceil(Math.random() * gameBoard.length - 1) * 2;
//                randomX2 = (int) Math.ceil(Math.random() * gameBoard.length - 1) * 2;
//                randomY2 = (int) Math.ceil(Math.random() * gameBoard.length - 1) * 2;
//
//            } else {
//                g1.gobPosition.add(new Point(randomX, randomY));
//                h1.humPosition.add(new Point(randomX2, randomY2));
//            }
//        }
//        gameBoard[randomX][randomY] = gob;
//        gameBoard[randomX2][randomY2] = hum;
        gameBoard[h1.humPosition[0]][h1.humPosition[1]] = hum;
        gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = gob;
        for(String[] row : gameBoard) {
            for (String c : row) {
                System.out.print(c);
            }
            //printing a line for each row
            System.out.println();
        }

    }
}
