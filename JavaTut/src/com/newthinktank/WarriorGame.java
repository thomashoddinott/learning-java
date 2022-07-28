package com.newthinktank;

public class WarriorGame {
    public static void main(String[] args) throws InterruptedException {
        Warrior Thor = new Warrior("Thor", 800, 130, 40);
        Warrior Loki = new DodgeWarrior("Loki", 800, 85, 40, 0.25);
        Battle.startFight(Thor, Loki);

        System.out.println("Loki " + Loki.teleport());
        Loki.setTeleportAbility(new CanTeleport());;
        System.out.println("Loki " + Loki.teleport());

    }
}
