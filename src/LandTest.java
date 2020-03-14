import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LandTest extends HumansTest {
    HumansTest h1 = new HumansTest();
    GoblinsTest g1 = new GoblinsTest();
    public void characterCreation() {
        boolean characterCreated = false;
        do {
            System.out.println("Welcome to Humans vs. Goblins. Please enter your name: ");
            Scanner scan = new Scanner(System.in);
            h1.name = scan.nextLine();
            System.out.println("Hello " + h1.name + "! Is this really your name? (Y/N)");
            for (; ; ) {
                char yOrN = scan.next().charAt(0);
                if (yOrN == 'n' || yOrN == 'N') {
                    break;
                } else if (yOrN == 'y' || yOrN == 'Y') {
                    System.out.println("Okay, " + h1.name + "! You are currently represented on the board by the '" + h1.H + "' symbol.");
                    System.out.println("And the Goblin is the '" + g1.G + "'! You can either try to avoid him or fight him!");
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
                System.out.println("You're ready to start!");
                break;
            }
        } while (!characterCreated);
    }





    public String[][] Land(HumansTest h1, GoblinsTest g1) {
        characterCreation();

        String gob = g1.G;
        String hum = h1.H;
        String[][] gameWorld = {
                {" ", " ", " ", " ", " "},
                {"-", " ", "-", " ", "-"},
                {" ", " ", " ", " ", " "},
                {"-", " ", "-", " ", "-"},
                {" ", " ", " ", " ", " "},
                {"-", " ", "-", " ", "-"}
        };

        System.out.println("Your turn!");
        walkableArea(gameWorld, gob, hum);

    return gameWorld;
    }
    public void walkableArea(String[][] gameWorld, String gob, String hum) {
        //creating 2 randomly generated x & y coordinates in increments of 2
        int randomX = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
        int randomY = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
        int randomX2 = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
        int randomY2 = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;


        while (randomX >= 6 || randomY >= 6 || randomX2 >= 6 || randomY2 >= 6) {
            randomX = (int) Math.ceil(Math.random() * gameWorld.length - 1) * 2;
            randomY = (int) Math.ceil(Math.random() * gameWorld.length - 1) * 2;
            randomX2 = (int) Math.ceil(Math.random() * gameWorld.length - 1) * 2;
            randomY2 = (int) Math.ceil(Math.random() * gameWorld.length - 1) * 2;
            if (g1.gobPosition == h1.humPosition) {
                randomX = (int) Math.ceil(Math.random() * gameWorld.length - 1) * 2;
                randomY = (int) Math.ceil(Math.random() * gameWorld.length - 1) * 2;
                randomX2 = (int) Math.ceil(Math.random() * gameWorld.length - 1) * 2;
                randomY2 = (int) Math.ceil(Math.random() * gameWorld.length - 1) * 2;

            } else {
                g1.gobPosition.add(new Point(randomX, randomY));
                h1.humPosition.add(new Point(randomX2, randomY2));
            }
        }
        //print the goblin and human chars in the randomly generated x/y coordinates
        gameWorld[randomX][randomY] = gob;
        gameWorld[randomX2][randomY2] = hum;
        // NEED NESTED FOR LOOP TO PRINT 2D ARRAY WITH A NEW LINE IN BETWEEN
        //for each character in the row
        for(String[] row : gameWorld) {
            for(String c : row) {
                System.out.print(c);
            }
            //printing a line for each row
            System.out.println();
        }
//        System.out.println(Arrays.deepToString(gameWorld));
        //creating a new ArrayList that iterates thru the gameworld and adds every other point to the walkable area
        ArrayList<Point> walkArea = new ArrayList<>();
        for (int i = 0; i <= gameWorld.length; i+=2) {
            for (int j = 0; j < gameWorld.length; j+=2) {
                walkArea.add(new Point(i, j));
            }
        }
        while (true) {
            Scanner scan = new Scanner(System.in);
            while (h1.HP > 0) {
                char wasd = scan.nextLine().charAt(0);
                for (Point point : walkArea) {
                    if (point == h1.humPosition.get(0)) {
                        switch (wasd) {
                            case 'w':
                                h1.humPosition.get(0).setLocation(h1.humPosition.get(0).getX(), h1.humPosition.get(0).getY()+2);
                                hum = h1.humPosition.get(0).toString();
                                System.out.println(hum);
                                break;
                            case 'a':
                                h1.humPosition.get(0).setLocation(h1.humPosition.get(0).getX()-2, h1.humPosition.get(0).getY());
                                System.out.println(gameWorld);
                                break;
                            case 's':
                                h1.humPosition.get(0).setLocation(h1.humPosition.get(0).getX(), h1.humPosition.get(0).getY()-2);
                                System.out.println(gameWorld);
                                break;
                            case 'd':
                                h1.humPosition.get(0).setLocation(h1.humPosition.get(0).getX()+2, h1.humPosition.get(0).getY());
                                System.out.println(gameWorld);
                                break;
                            default:
                                System.out.println("USE 'WASD' ONLY!");
                        }
                        System.out.println(gameWorld);
                    }

                }


            }
        }

    }

    @Override
    public String toString(){
        return Arrays.toString(Land(h1, g1));
    }
}
