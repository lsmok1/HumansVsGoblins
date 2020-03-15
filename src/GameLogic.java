import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {
//    ArrayList<Point> walkArea = new ArrayList<>();
    public static String characterCreation(Human h1, Goblin g1) {
        //creating the instances of a human and goblin in characterCreation so that whenever u play again, u have to choose ur stats
        //again and the goblin gets new randomized stats as well.
//        Human h1 = new Human();
//        Goblin g1 = new Goblin();
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
//        String hum = h1.HumUnicode;
//        String gob = g1.GobUnicode;
        ArrayList<Point> walkArea = new ArrayList<>();
        //iterates thru the gameboard and adds every other point to the walkable area
        for (int i = 0; i <= gameBoard.length; i+=2) {
            for (int j = 0; j < gameBoard.length; j+=2) {
                walkArea.add(new Point(i, j));
            }
        }
//        //creating 2 randomly generated x & y coordinates in increments of 2
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

        while (true) {
            Scanner scan = new Scanner(System.in);
            while (h1.HP > 0) {
                char wasd = scan.nextLine().charAt(0);
                for (Point point : walkArea) {
                    if (point == h1.humPosition.get(0)) {
                        switch (wasd) {
                            case 'w':
                                h1.humPosition.get(0).setLocation(h1.humPosition.get(0).getX(), h1.humPosition.get(0).getY()+2);
                                break;
                            case 'a':
                                h1.humPosition.get(0).setLocation(h1.humPosition.get(0).getX()-2, h1.humPosition.get(0).getY());
                                System.out.println(gameBoard);
                                break;
                            case 's':
                                h1.humPosition.get(0).setLocation(h1.humPosition.get(0).getX(), h1.humPosition.get(0).getY()-2);
                                System.out.println(gameBoard);
                                break;
                            case 'd':
                                h1.humPosition.get(0).setLocation(h1.humPosition.get(0).getX()+2, h1.humPosition.get(0).getY());
                                System.out.println(gameBoard);
                                break;
                            default:
                                System.out.println("USE 'WASD' ONLY!");
                        }
                        System.out.println(gameBoard);
                    }

                }


            }
        }
    }
}
