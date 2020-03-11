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
    public static void main(String[] args) {
        char[][] gameWorld = {
                {'H', ' ', ' ', ' ', ' '},
                {'-', ' ', '-', ' ', '-'},
                {' ', ' ', ' ', ' ', ' '},
                {'-', ' ', '-', ' ', '-'},
                {' ', ' ', ' ', ' ', 'G'},
                {'-', ' ', '-', ' ', '-'}
        };
        Land land1 = new Land(gameWorld);
        Humans h1 = new Humans();
        System.out.println("Enter your name: ");
        Scanner scan = new Scanner(System.in);
        while (true) {
            h1.name = scan.nextLine();
            System.out.println("Your name is... " + h1.name + "? (Y/N)");
            char yOrN = scan.nextLine().charAt(0);
            int attPoints = 10;
            while (yOrN == 'n' || yOrN == 'N') {
                System.out.println("Enter your correct name!");
                break;
            }
            System.out.println("Nice! " + h1.name + ", you're going to have to fight some goblins... Choose your stats.");
            while (yOrN == 'y' || yOrN == 'Y') {

                System.out.println("Points Left: " + attPoints);
                System.out.println("HP: " + h1.HP);
                System.out.println("STR: " + h1.STR);
                System.out.println("What would you like to increase? (HP/STR)");
                String statChoose = scan.nextLine().toUpperCase();

                if (statChoose.equals("HP")) {
                    System.out.println("How much would you like to increase HP by?");
                    int inc = scan.nextInt();
                    if (inc > 10) {
                        System.out.println("You don't have that many points!");
                    } else if (inc == 10) {
                        System.out.println("You can't use all your points on one stat!");
                    } else {
                        attPoints -= inc;
                        h1.HP += inc;
                        System.out.println("Points Left: " + attPoints);
                        System.out.println("You now have " + h1.HP + " HP! Are you sure? (Y/N)");
                        yOrN = scan.next().charAt(0);
                        if (yOrN == 'n' || yOrN == 'N') {
                            attPoints += inc;
                            h1.HP -= inc;
                            System.out.println("Points Left: " + attPoints);
                        }
                        System.out.println("Nice, " + h1.name + ". You have " + h1.HP + "HP!");
                    }
                    
                }

            }

        }
    }
}

