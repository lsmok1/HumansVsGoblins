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


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Land land1 = new Land();
        System.out.println(land1);
        System.out.println("Please use 'WASD' to move.");
        Humans h1 = new Humans();
        Goblins g1 = new Goblins();
        //setting these new humans and gobs to the ones created in character creation
//        while (true) {
//            Scanner scan = new Scanner(System.in);
//            while (h1.HP > 0) {
//                char wasd = scan.nextLine().charAt(0);
//                switch (wasd) {
//                    case 'w':
////                        h1.humPosition.get(0).getLocation().setLocation();
//                        break;
//                    case 'a':
//                        break;
//                    case 's':
//                        break;
//                    case 'd' :
//                        break;
//                }
//            }
//        }
    }
}

