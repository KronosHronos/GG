package game;

import units.*;

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

    public static ArrayList<BaseHero> unitedTeam = new ArrayList<>();
    public static ArrayList<BaseHero> team1 = new ArrayList<>();
    public static ArrayList<BaseHero> team2 = new ArrayList<>();

    public static void main(String[] args) {

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

                    team2.add(new Сultist(getName2(), 10, count));
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


        View.view();


        for (BaseHero item : unitedTeam) {
            if (team1.contains(item)) {
                item.step(team1, team2);
            } else {
                item.step(team2, team1);
            }

        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to proceed to the next turn.");
        while (scanner.nextLine().isEmpty()) {
            for (int round = 1; round <= 1; round++) {
                for (BaseHero hero : team1) {
                    hero.step(team2, team1);
                }
                for (BaseHero hero : team2) {
                    hero.step(team1, team2);
                }
                View.view();

                if (team1.stream().allMatch(hero -> hero.getHp() <= 0) || team2.stream().allMatch(hero -> hero.getHp() <= 0)) {
                    break;
                }
            }

            if (team1.stream().allMatch(hero -> hero.getHp() <= 0) || team2.stream().allMatch(hero -> hero.getHp() <= 0)) {
                break;
            }

            System.out.println("Turn finished. Press Enter to proceed to the next turn or enter 'exit' to end the game.");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
        }

        int team1LivingHeroes = (int) team1.stream().filter(hero -> hero.getHp() > 0).count();
        int team2LivingHeroes = (int) team2.stream().filter(hero -> hero.getHp() > 0).count();
        if (team1LivingHeroes > team2LivingHeroes) {
            System.out.println("Game ended. Team 1 Human wins!");
        } else if (team2LivingHeroes > team1LivingHeroes) {
            System.out.println("Game ended. Team 2 Demon wins!");
        } else {
            System.out.println("Game ended. It's a draw!");
        }

        scanner.close();
    }
}

