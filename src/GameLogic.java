import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    public static String characterCreation(Human h1, Goblin g1) {
        boolean characterCreated = false;
        do {
            System.out.println("Welcome to Humans vs. Goblins. Please enter your name: ");
            Scanner scan = new Scanner(System.in);
            h1.humName = scan.nextLine();
            System.out.println("Hello " + h1.humName + "! Is this really your name? (Y/N)");
            for (; ; ) {
                char yOrN = scan.next().charAt(0);
                if (yOrN == 'n' || yOrN == 'N') {
                    break;
                } else if (yOrN == 'y' || yOrN == 'Y') {
                    System.out.println("Okay, " + h1.humName + "! You are currently represented on the board by the '" + h1.HumUnicode + "' symbol.");
                    System.out.println("And the Goblin is the '" + g1.GobUnicode + "'! You can either try to avoid him or fight him!");
                    System.out.println("However, for now... You must prepare.");
                    while (h1.attPoints > 0) {
                        System.out.println("Points Left: " + h1.attPoints);
                        System.out.println("HP: " + h1.HP);
                        System.out.println("STR: " + h1.STR);
                        System.out.println("What attribute would you like to change? (1 - HP || 2 - STR)");
                        do {
                            int hpOrStr = scan.nextInt();
                            while (hpOrStr == 1) {
                                System.out.println("Points Left: " + h1.attPoints);
                                System.out.println("HP: " + h1.HP);
                                System.out.println("STR: " + h1.STR);
                                System.out.println("How many points would you like to put into HP? (1-10)");
                                for (; ; ) {
                                    int pointAllocate = scan.nextInt();
                                    if (pointAllocate > h1.attPoints) {
                                        System.out.println("You don't have that many points!");
                                        break;
                                    }
                                    if (pointAllocate >= 10) {
                                        System.out.println("Don't use all your points on one attribute!");
                                        break;
                                    } else {
                                        h1.attPoints -= pointAllocate;
                                        h1.HP += pointAllocate;
                                        System.out.println("Points Left: " + h1.attPoints);
                                        System.out.println("HP: " + h1.HP);
                                        System.out.println("STR: " + h1.STR);
                                        System.out.println("Are you fine with these changes? (Y/N)");
                                        yOrN = scan.next().charAt(0);
                                        if (yOrN == 'y' || yOrN == 'Y') {
                                            hpOrStr = 0;
                                            break;
                                        } else if (yOrN == 'n' || yOrN == 'N') {
                                            h1.attPoints += pointAllocate;
                                            h1.HP -= pointAllocate;
                                            break;
                                        }
                                    }
                                }
                                if (h1.attPoints == 0) {
                                    System.out.println("Points Left: " + h1.attPoints);
                                    System.out.println("HP: " + h1.HP);
                                    System.out.println("STR: " + h1.STR);
                                    characterCreated = true;
                                    break;
                                }
                            }
                            while (hpOrStr == 2) {
                                System.out.println("Points Left: " + h1.attPoints);
                                System.out.println("HP: " + h1.HP);
                                System.out.println("STR: " + h1.STR);
                                System.out.println("How many points would you like to put into STR? (1-10)");
                                int pointAllocate = scan.nextInt();
                                for (; ; ) {
                                    if (pointAllocate > h1.attPoints) {
                                        System.out.println("You don't have that many points!");
                                        break;
                                    }
                                    if (pointAllocate >= 10 || h1.HP == 10 || h1.STR == 10) {
                                        System.out.println("Don't use all your points on one attribute!");
                                        break;
                                    } else {
                                        h1.attPoints -= pointAllocate;
                                        h1.STR += pointAllocate;
                                        System.out.println("Points Left: " + h1.attPoints);
                                        System.out.println("HP: " + h1.HP);
                                        System.out.println("STR: " + h1.STR);
                                        System.out.println("Are you fine with these changes? (Y/N)");
                                        yOrN = scan.next().charAt(0);
                                        //setting it to 0 for if break to go back to the choosing your attribute loop
                                        if (yOrN == 'y' || yOrN == 'Y') {
                                            hpOrStr = 0;
                                            break;
                                        } else if (yOrN == 'n' || yOrN == 'N') {
                                            h1.attPoints += pointAllocate;
                                            h1.STR -= pointAllocate;
                                            break;
                                        }
                                    }
                                }
                                if (h1.attPoints == 0) {
                                    System.out.println("Points Left: " + h1.attPoints);
                                    System.out.println("HP: " + h1.HP);
                                    System.out.println("STR: " + h1.STR);
                                    characterCreated = true;
                                    break;
                                }
                            }
                            if (hpOrStr == 0) {
                                break;
                            }

                        } while (h1.attPoints != 0);
                    }
                }
                System.out.println("Ok, " + h1.humName + ", you're ready to start!");
                break;
            }
        } while (!characterCreated);
        return "";
    }
    public static void charMovement(String[][] gameBoard, Human h1, Goblin g1){
        String hum = h1.HumUnicode;
        String gob = g1.GobUnicode;

//        //iterates thru the gameboard and adds every other point to the walkable area
//        for (int i = 0; i <= gameBoard.length; i+=2) {
//            for (int j = 0; j < gameBoard.length; j+=2) {
//                walkArea.add(new Point(i, j));
//            }
//        }
        while (true) {
            Scanner scan = new Scanner(System.in);
            Random rand = new Random();
            //max = (4,4); min = (0,0)
            while (h1.humPosition[0] <= 4 && h1.humPosition[0] >= 0 && h1.humPosition[1] <= 4 && h1.humPosition[1] >= 0) {
                char wasd = scan.nextLine().charAt(0);
                switch(wasd) {
                    case 'w':
                        if (h1.humPosition[0]-2 < 0) {
                            System.out.println("Can't go that way! Try again!");
                        } else {
                            //clears the current position
                            gameBoard[h1.humPosition[0]][h1.humPosition[1]] = " ";
                            gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = " ";
                            //index 0 of humPosition is equal to humPosition-2
                            h1.humPosition[0] = h1.humPosition[0]-2;
                            //generating a random int from 0-1, multiplying by 2 and then by -1 or 1 randomly
                            g1.gobPosition[rand.nextInt(2)] = g1.gobPosition[0]+(rand.nextInt(2)*2*(rand.nextBoolean() ? 1 : -1));
                            while (g1.gobPosition[0] < 0 || g1.gobPosition[0] >  4 || g1.gobPosition[1] < 0 || g1.gobPosition[1] > 4) {
                                g1.gobPosition[rand.nextInt(2)] = g1.gobPosition[0]+(rand.nextInt(2)*2*(rand.nextBoolean() ? 1 : -1));
                            }

                            //prints the new position
                            gameBoard[h1.humPosition[0]][h1.humPosition[1]] = h1.HumUnicode;
                            gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = g1.GobUnicode;
                        }
                        break;
                    case 'a':
                        if (h1.humPosition[1]-2 < 0) {
                            System.out.println("Can't go that way! Try again!");
                        } else {
                            //clears the current position
                            gameBoard[h1.humPosition[0]][h1.humPosition[1]] = " ";
                            gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = " ";
                            //index 0 of humPosition is equal to humPosition-2
                            h1.humPosition[1] = h1.humPosition[1]-2;
                            g1.gobPosition[rand.nextInt(2)] = g1.gobPosition[0]+(rand.nextInt(2)*2*(rand.nextBoolean() ? 1 : -1));
                            while (g1.gobPosition[0] < 0 || g1.gobPosition[0] >  4 || g1.gobPosition[1] < 0 || g1.gobPosition[1] > 4) {
                                g1.gobPosition[rand.nextInt(2)] = g1.gobPosition[0]+(rand.nextInt(2)*2*(rand.nextBoolean() ? 1 : -1));
                            }
                            //prints the new position
                            gameBoard[h1.humPosition[0]][h1.humPosition[1]] = h1.HumUnicode;
                            gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = g1.GobUnicode;
                        }
                        break;
                    case 's':
                        if (h1.humPosition[0]+2 > 4) {
                            System.out.println("Can't go that way! Try again!");
                        } else {
                            //clears the current position
                            gameBoard[h1.humPosition[0]][h1.humPosition[1]] = " ";
                            gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = " ";
                            //index 0 of humPosition is equal to humPosition-2
                            h1.humPosition[0] = h1.humPosition[0]+2;
                            g1.gobPosition[rand.nextInt(2)] = g1.gobPosition[0]+(rand.nextInt(2)*2*(rand.nextBoolean() ? 1 : -1));
                            while (g1.gobPosition[0] < 0 || g1.gobPosition[0] >  4 || g1.gobPosition[1] < 0 || g1.gobPosition[1] > 4) {
                                g1.gobPosition[rand.nextInt(2)] = g1.gobPosition[0]+(rand.nextInt(2)*2*(rand.nextBoolean() ? 1 : -1));
                            }
                            //prints the new position
                            gameBoard[h1.humPosition[0]][h1.humPosition[1]] = h1.HumUnicode;
                            gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = g1.GobUnicode;
                        }
                        break;
                    case 'd':
                        if (h1.humPosition[1]+2 > 4) {
                            System.out.println("Can't go that way! Try again!");
                        } else {
                            //clears the current position
                            gameBoard[h1.humPosition[0]][h1.humPosition[1]] = " ";
                            gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = " ";
                            //index 0 of humPosition is equal to humPosition-2
                            h1.humPosition[1] = h1.humPosition[1]+2;
                            g1.gobPosition[rand.nextInt(2)] = g1.gobPosition[0]+(rand.nextInt(2)*2*(rand.nextBoolean() ? 1 : -1));
                            while (g1.gobPosition[0] < 0 || g1.gobPosition[0] >  4 || g1.gobPosition[1] < 0 || g1.gobPosition[1] > 4) {
                                g1.gobPosition[rand.nextInt(2)] = g1.gobPosition[0]+(rand.nextInt(2)*2*(rand.nextBoolean() ? 1 : -1));
                            }
                            //prints the new position
                            gameBoard[h1.humPosition[0]][h1.humPosition[1]] = h1.HumUnicode;
                            gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = g1.GobUnicode;
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + wasd);
                }
                combatInitiate(gameBoard, h1, g1);
                GameBoard.printGameBoard(gameBoard, h1, g1);
                System.out.println("Current HP: " + h1.HP);
                if (h1.HP <= 0) {
                    System.out.println("You died. Game over.");
                    break;
                }
                if (g1.HP <= 0) {
                    System.out.println("You killed the goblin!");
                    break;
                }
            }
            break;
        }
    }

    public static void combatInitiate(String[][] gameBoard, Human h1, Goblin g1) {
        if (gameBoard[h1.humPosition[0]][h1.humPosition[1]] == gameBoard[g1.gobPosition[0]][g1.gobPosition[1]]) {
            gameBoard[h1.humPosition[0]][h1.humPosition[1]] = "\u2694";
            gameBoard[g1.gobPosition[0]][g1.gobPosition[1]] = "\u2694";
            System.out.println("Combat initiated!");
            h1.HP = h1.HP - (int) Math.ceil(Math.random() * g1.STR);
            g1.HP = g1.HP - (int) Math.ceil(Math.random() * h1.STR);
        }
    }
}
