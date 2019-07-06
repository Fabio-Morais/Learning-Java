public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature){
        if(summer) {
            return (temperature <= 45 && temperature >= 25);

        }else {
            return ((temperature >= 25 && temperature <= 35));

        }
    }
}
