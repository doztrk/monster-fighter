package app;

public class Monster extends GameElements{


    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Monster(String type){
        setType(type);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Monster)) {
            return false;
        }
        Monster other = (Monster) obj;
        return type.equalsIgnoreCase(other.type);
    }

    public int getAttackPoint(Attack attack) {
        return attack.calculateAttackPoints(AttackFormula.getRandomNumber(1,10));
    }


}
