package com.newthinktank;

import java.util.Random;

public class DodgeWarrior extends Warrior {
    double dodgePercent;
    Random rand = new Random();

    public DodgeWarrior(String name, int health, int attkMax, int blockMax, double dodgePercent) {
        super(name, health, attkMax, blockMax);
        this.dodgePercent = dodgePercent;

        teleportType = new CanTeleport();
    }

    public int block() {
        double chance = rand.nextDouble();
        if (chance <= dodgePercent) {
            System.out.printf("%s Dodged the Attack\n\n", this.getName());
            return 10000;
        } else {
            return 1 + (int) (Math.random() * ((blockMax - 1) + 1));
        }
    }
}
