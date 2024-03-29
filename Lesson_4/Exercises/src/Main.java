public class Main {

    public static void main(String[] args) {
        SpeedConverter.printConversion(10.25);
        MegaBytesConverter.printMegaBytesAndKiloBytes(2500);
        System.out.println(BarkingDog.shouldWakeUp(true, 8));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(3.1756, 3.17568));
        EqualSumChecker.hasEqualSum(1,1,2);
        System.out.println(TeenNumberChecker.hasTeen(1,15,199));
        System.out.println(AreaCalculator.area(5.0));
        MinutesToYearsDaysCalculator.printYearsAndDays(561600);
        IntEqualityPrinter.printEqual(2,1,1);
        System.out.println(PlayingCat.isCatPlaying(true,33));
    }
}

