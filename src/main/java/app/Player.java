package app;

public class Player extends GameElements{

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Player(String name) {
        setName(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        Player other = (Player) obj;
        return name == other.name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int getAttackPoint(Attack attack) {
        return attack.calculateAttackPoints(AttackFormula.getRandomNumber(1,10));
    }
}
