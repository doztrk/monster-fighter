package app;

public class CriticalAttack implements Attack{
    @Override
    public int calculateAttackPoints(int attackPoints) {
        System.out.println("Critical Damage");
        return 5*AttackFormula.getRandomNumber(1,10);
    }
}
