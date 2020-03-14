import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void printGameBoard (String[][] gameBoard) {
        for(String[] row : gameBoard) {
            for (String c : row) {
                System.out.print(c);
            }
            //printing a line for each row
            System.out.println();
        }
    }

    public static void main (String[] args) {
        boolean playAgain = true;
        Scanner scan = new Scanner(System.in);
        while (playAgain) {
            //init the gameBoard
            String[][] gameBoard = {
                    {" ", " ", " ", " ", " "},
                    {"-", " ", "-", " ", "-"},
                    {" ", " ", " ", " ", " "},
                    {"-", " ", "-", " ", "-"},
                    {" ", " ", " ", " ", " "},
                    {"-", " ", "-", " ", "-"}
            };
            for (; ; ) {
                new CreateChar();
                new GameBoard();
                System.out.println(CreateChar.characterCreation());
                printGameBoard(gameBoard);
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
