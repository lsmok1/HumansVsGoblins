public class Land {
    public Land(char[][] gameWorld) {
        for(char[] row : gameWorld) {
            //for each character in the row
            for(char c : row) {
                System.out.print(c);
            }
            //printing a line for each row
            System.out.println();
        }
    }
}
