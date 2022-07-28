package com.newthinktank;

//utility class --> all methods will be static
public class Battle {
    public static void startFight(Warrior w1, Warrior w2) throws InterruptedException {
        while (true) {
            if (getAttackResult(w1, w2).equals("Game Over")) {
                System.out.println("Game over");
            }
            if (getAttackResult(w2, w1).equals("Game Over")) {
                System.out.println("Game over");
            }
        }
    }

    public static String getAttackResult(Warrior wAttacker, Warrior wBlocker) throws InterruptedException {
        int wAttackerAttackAmount = wAttacker.attack();
        int wBlockerBlockAmount = wBlocker.block();

        int dmgOnwBlocker = wAttackerAttackAmount - wBlockerBlockAmount;
        if (dmgOnwBlocker > 0) {
            wBlocker.health = wBlocker.health - dmgOnwBlocker;
        } else {
            dmgOnwBlocker = 0;
        }

        System.out.printf("%s Attacks %s and deals "
                + "%d Damage\n", wAttacker.getName(), wBlocker.getName(), dmgOnwBlocker);

        System.out.printf("%s Has %d Health\n\n",
                wBlocker.getName(), wBlocker.health);

        Thread.sleep(1500);


        if (wBlocker.health <= 0) {
            System.out.printf("%s has Died and %s is Victorious",
                    wBlocker.getName(), wAttacker.getName());
            return "Game over";
        } else {
            return "Fight Again";
        }
    }
}
