import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Land {
    Humans h1 = new Humans();
    Goblins g1 = new Goblins();
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
                                    if (pointAllocate >= 10) {
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



    public String[][] Land(Humans h1, Goblins g1) {
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

        //creating 2 randomly generated x & y coordinates in increments of 2
        int randomX = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
        int randomY = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
        int randomX2 = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
        int randomY2 = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
        //if the index is 6 or higher, re-roll
        while (randomX >= 6 || randomY >= 6 || randomX2 >= 6 || randomY2 >= 6) {
            randomX = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
            randomY = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
            randomX2 = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
            randomY2 = (int) Math.ceil(Math.random() * gameWorld.length-1) * 2;
        }
        //print the goblin and human chars in the randomly generated x/y coordinates
        gameWorld[randomX][randomY] = gob;
        gameWorld[randomX2][randomY2] = hum;
        HashSet<Arrays> hashGob = new HashSet<>();
//        h1.currentPos.get(0).add(gameWorld[randomX2][randomY2]);
//        System.out.println(h1.currentPos);
        //checking if the board contains human's positions... NOT FINISHED, HUMAN POSITION ISNT SET YET
        for(int x=0; x < gameWorld.length-1; x++) {
            for (int y=0; x < gameWorld.length-1; y++) {
                int [][] newArr = new int[x][y];
                if(newArr == h1.currentPos) {

                }
            }
        }

        //for each character in the row
        for(String[] row : gameWorld) {
            for(String c : row) {
                System.out.print(c);
            }
            //printing a line for each row
            System.out.println();
        }


    return gameWorld;
    }
    @Override
    public String toString(){
        return Arrays.toString(Land(h1, g1));
    }
}
