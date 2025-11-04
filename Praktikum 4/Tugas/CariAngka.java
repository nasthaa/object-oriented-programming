public class CariAngka {
    public static void main(String[] args) {
        int[][] arrayOfInts = {
            {32, 87, 3, 589},
            {12, 1076, 2000, 8},
            {622, 127, 77, 955}
        };

        int searchfor = 12;
        boolean foundIt = false;

        search:
        for (int row = 0; row < arrayOfInts.length; row++) {
            for (int column = 0; column < arrayOfInts[row].length; column++) {
                if (arrayOfInts[row][column] == searchfor) {
                    foundIt = true;
                    System.out.println("Found "+ searchfor + " at " + row + ", " + column);
                    break search;
                }
            }
        }

        if (!foundIt) {
            System.out.println(searchfor + " not found in the array.");
        }
    }
}