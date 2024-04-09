package app;

public class AttackFormula {
    public static int getRandomNumber(int min, int max){
        return min + (int) (Math.random() * max);
    }
}
