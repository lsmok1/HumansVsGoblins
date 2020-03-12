/*
1.	Everything must be objects: land/goblins/humans
2.	You must override the toString method to represent each of the object
3.	Create a grid for the game world
4.	Use UTF characters for the players and goblins and the land
5.	Game is turn based move: n/s/e/w
6.	Once a human and goblin collide combat is initiated
7.	Combat uses math.random
8.	Extras:
a.	human has inventory system
b.	goblins have drops
c.	stats can be modified by equipment
d.	map gen random treasure chest after each round of combat
e.	goblins pursue player

 */


import java.util.Scanner;

public class Main {

//    @Override
//    public String toString(){
//        return String.format();
//    }
    public static void characterCreation() {
        for (; ; ) {
            Humans h1 = new Humans();
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
                    System.out.println("And the Goblin is the 'G'! You can either try to avoid him or fight him!");
                    System.out.println("However, for now... You must prepare.");
                    while (h1.attPoints > 0) {
                        System.out.println("Points Left: " + h1.attPoints);
                        System.out.println("HP: " + h1.HP);
                        System.out.println("STR: " + h1.STR);
                        System.out.println("What attribute would you like to change? (1 - HP / 2 - STR)");
                        for (; ; ) {
                            int hpOrStr = scan.nextInt();
                            if (hpOrStr == 1) {
                                System.out.println("Points Left: " + h1.attPoints);
                                System.out.println("HP: " + h1.HP);
                                System.out.println("STR: " + h1.STR);
                                System.out.println("How many points would you like to put into HP? (1-10)");
                            } else if (hpOrStr == 2) {
                                System.out.println("Points Left: " + h1.attPoints);
                                System.out.println("HP: " + h1.HP);
                                System.out.println("STR: " + h1.STR);
                                System.out.println("How many points would you like to put into STR? (1-10)");
                            }

                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Land land1 = new Land();
        characterCreation();

    }
}

