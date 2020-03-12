public class Land {
    public Land() {
        Humans h1 = new Humans();
        Goblins g1 = new Goblins();
        char gob = g1.G;
        char hum = h1.H;
        char[][] gameWorld = {
                {' ', ' ', ' ', ' ', ' '},
                {'-', ' ', '-', ' ', '-'},
                {' ', ' ', ' ', ' ', ' '},
                {'-', ' ', '-', ' ', '-'},
                {' ', ' ', ' ', ' ', ' '},
                {'-', ' ', '-', ' ', '-'}
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

        //for each character in the row
        for(char[] row : gameWorld) {
            for(char c : row) {
                System.out.print(c);
            }
            //printing a line for each row
            System.out.println();
        }



    }
}
