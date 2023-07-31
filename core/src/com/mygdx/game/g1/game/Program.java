package com.mygdx.game.g1.game;

import com.mygdx.game.g1. units.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Program {
    private static String getName() {
        Humannames[] names = Humannames.values();
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex].toString();
    }

    private static String getName2() {
        Demonnames[] names = Demonnames.values();
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex].toString();
    }

    public ArrayList<BaseHero> unitedTeam = new ArrayList<>();
    public ArrayList<BaseHero> team1 = new ArrayList<>();
    public ArrayList<BaseHero> team2 = new ArrayList<>();

    public Program() {
        for (int count = 1; count < 11; count++) {
            int newChar = new Random().nextInt(0, 6);
            switch (newChar) {
                case 0:
                    team1.add(new Mage(getName(), 1, count));

                    break;
                case 1:
                    team1.add(new Monk(getName(), 1, count));

                    break;
                case 2:
                    team1.add(new Rouge(getName(), 1, count));

                    break;
                case 3:
                    team1.add(new Sniper(getName(), 1, count));

                    break;
                case 4:
                    team1.add(new Archer(getName(), 1, count));

                    break;
                case 5:
                    team1.add(new Spearman(getName(), 1, count));

                    break;
                default:
                    team1.add(new Farmer(getName(), 1, count));

                    break;
            }
        }
        for (int count = 1; count < 11; count++) {
            int newChar = new Random().nextInt(0, 6);
            switch (newChar) {
                case 0:

                    team2.add(new Demon(getName2(), 10, count));
                    break;
                case 1:

                    team2.add(new Cultist(getName2(), 10, count));
                    break;
                case 2:

                    team2.add(new Shadow(getName2(), 10, count));
                    break;
                case 3:

                    team2.add(new Succubus(getName2(), 10, count));
                    break;
                case 4:

                    team2.add(new LivingEmber(getName2(), 10, count));
                    break;
                case 5:

                    team2.add(new Hound(getName2(), 10, count));
                    break;
                default:

                    team2.add(new Imp(getName2(), 10, count));
                    break;
            }
        }


        unitedTeam.addAll(team1);
        unitedTeam.addAll(team2);

        unitedTeam.sort((o1, o2) -> o2.getInitiative() - o1.getInitiative());


//        View.view();


        for (BaseHero item : unitedTeam) {
            if (team1.contains(item)) {
                item.step(team1, team2);
            } else {
                item.step(team2, team1);
            }

        }

    }


    public boolean step() {

        int deadCountteam1 = 0;
        int deadCountteam2 = 0;
        boolean endGame = false;

//        Scanner scan = new Scanner(System.in);

//        while (!endGame) {
//            scan.nextLine();
        for (BaseHero item : unitedTeam) {
            if (team1.contains(item)) {
                if (item.getHp() <= 0) {
                    deadCountteam1 += 1;
                }
                item.step(team2, team1);
            } else {
                if (item.getHp() <= 0) {
                    deadCountteam2 += 1;
                }
                item.step(team1, team2);
            }
        }

//            View.view();

        if (deadCountteam1 == team1.size()) {
            System.out.println("GAME OVER\nHumans wins");
            return true;
        }
        if (deadCountteam2 == team2.size()) {
            System.out.println("GAME OVER\nDemons wins");
            return true;
        }

        System.out.println("Statistics:\nHumans killed: " + deadCountteam1);
        System.out.println("Demons killed: " + deadCountteam2);
        deadCountteam1 = 0;
        deadCountteam2 = 0;

        return false;
    }
}


