package app;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static final String GREEN = "\u001B[32m";


    public static final int FULL_HEALTH = 100;

    private Monster monster;
    private Player player;

    public void startGame() {
        monster = new Monster("Big Head");
        player = new Player("Human");

        buildPlayer();
        buildMonster();

        do {
            startAttacks();
            resetHealths();


        } while (shouldContinue());
    }

    private void resetHealths() {
        monster.resetHealth();
        player.resetHealth();
    }

    private void startAttacks() {


        int round = 1;
        while (monster.isAlive() && player.isAlive()) {

            System.out.println(RED + "************* ROUND: " + round + " ***************" + RESET);
            int playerDamage = player.getAttackPoint(new NormalAttack());
            System.out.println(player.getName() + " attacks for " + playerDamage);
            monster.decreaseHealth(playerDamage);
            System.out.println(monster.getType() + " health: " + monster.getHealth());
            if (!monster.isAlive()) {
                break;
            }


            if (round == 3) {
                int monsterCriticalDamage = monster.getAttackPoint(new CriticalAttack());
                System.out.println(monster.getType() + " super attacks for: "+ monsterCriticalDamage);
                player.decreaseHealth(monsterCriticalDamage);
            }else {
                int monsterDamage = monster.getAttackPoint(new NormalAttack());
                System.out.println(monster.getType() + " attacks for " + monsterDamage);
                player.decreaseHealth(monsterDamage);
            }
            System.out.println(player.getName() + " health: " + player.getHealth());

            round++;


        }
       printOutcome();
    }

    private void buildMonster() {
        InputHandle input = new InputHandle();

        String type = InputHandle.getStringInput("Enter a type for monster");

        monster = new Monster(type);
    }

    private void buildPlayer() {
        InputHandle input = new InputHandle();

        String name = InputHandle.getStringInput("Enter a name for player");

        player = new Player(name);

    }

    private boolean shouldContinue() {
        String answer = InputHandle.getStringInput("Do you want to continue ? Y/N");
        return answer.trim().toLowerCase().equals("y");
    }

    private void printOutcome(){
        System.out.print(RED + "Game ended" + RESET + GREEN + "\nWINNER: " + RESET);

        System.out.println(player.isAlive() ?
                GREEN + player.getName() + RESET :
                GREEN + monster.getType() + " wins!!!"+RESET );

    }

}



