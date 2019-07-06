import java.time.Year;

public class MinutesToYearsDaysCalculator {

    private static final String INVALID_MESSAGE = "Invalid Value";

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0)
            System.out.println(INVALID_MESSAGE);
        else {
            long hour, year, day;
            year = minutes / (365 * 24 * 60);
            day = minutes % (365 * 24 * 60) / (24 * 60);

            System.out.println(minutes + " min = " + year + " y and " + day + " d");
        }
    }
}
