import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main extends GameLogic{


    public static void main (String[] args) {
        boolean playAgain = true;
        Scanner scan = new Scanner(System.in);
        while (playAgain) {
            //init the hum and gob
            Human h1 = new Human();
            Goblin g1 = new Goblin();
            //init the gameBoard

            String[][] gameBoard = {
                    {" ", " ", " ", " ", " "},
                    {"-", " ", "-", " ", "-"},
                    {" ", " ", " ", " ", " "},
                    {"-", " ", "-", " ", "-"},
                    {" ", " ", " ", " ", " "},
                    {"-", " ", "-", " ", "-"}
            };
            int currentHumPos;
            int currentGobPos;
            gameBoard[h1.humPosition[0]][h1.humPosition[1]] = h1.HumUnicode;
            gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = g1.GobUnicode;


            for (; ; ) {
                new GameLogic();
                new GameBoard();
                System.out.println(characterCreation(h1, g1));
                GameBoard.printGameBoard(gameBoard, h1, g1);
                for (; ;) {
                    charMovement(gameBoard, h1, g1);
                    //GameBoard.printGameBoard(gameBoard, h1, g1);
                    if (h1.HP == 0) {
                        break;
                    }
                }
                System.out.println("Would you like to play again?");
                //init the char for scanning the answer
                char playAgainAnswer = scan.nextLine().charAt(0);
                // if true, break the for loop, play again will still be true, for loop starts again
                if (playAgainAnswer == 'y') {
                    break;
                } else if (playAgainAnswer == 'n') { //playAgain will be false and end the code.
                    playAgain = false;
                    break;
                }
            }
        }
    }
}
