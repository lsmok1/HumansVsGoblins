import java.util.Scanner;

public class CreateChar {
    public static String characterCreation() {
        Human h1 = new Human();
        Goblin g1 = new Goblin();
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
}
