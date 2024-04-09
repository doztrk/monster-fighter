package app;

public abstract class GameElements {

    private int health;


    public GameElements() {
        setHealth(Game.FULL_HEALTH);
    }


    public void setHealth(int health) {
        if (health > Game.FULL_HEALTH) {
            throw new IllegalArgumentException("Health cannot exceed 100");
        }
        this.health = health;
    }

    public void resetHealth() {
        health = Game.FULL_HEALTH;
    }

    public void decreaseHealth(int points) {
        health -= points;
    }

    public int getHealth() {
        return health;
    }


    public boolean isAlive() {
        return health > 0;
    }

  public abstract int getAttackPoint(Attack attack);


}
