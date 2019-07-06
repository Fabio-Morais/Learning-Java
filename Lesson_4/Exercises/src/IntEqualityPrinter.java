public class IntEqualityPrinter {
    private static final String INVALID_VALUE= "Invalid Value";
    public static void printEqual(int x, int y, int z){
        if(x<0 || y<0 || z<0)
            System.out.println(INVALID_VALUE);
        else {
            if (x == y || x == z || y == z) {
                if (x == z && x == y && y == z)
                    System.out.println("All numbers are equal");
                else
                    System.out.println("Neither all are equal or different");
            } else
                System.out.println("All numbers are different");
        }
    }
}
