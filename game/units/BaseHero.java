package units;

import java.util.ArrayList;

public abstract class BaseHero implements Action {
    int hp;
    String name;

    protected String type;
    int baseAttack;

    protected int initiative;
    int mp;

    public int getInitiative() {
        return initiative;
    }

    protected Coordinates place;

    public BaseHero(int hp, String name, String type, int baseAttack, int initiative, int mp, int x, int y) {
        this.hp = hp;
        this.name = name;
        this.type = type;
        this.baseAttack = baseAttack;
        this.initiative = initiative;
        this.mp = mp;
        place = new Coordinates(x, y);
    }

    protected Coordinates getPlace() {
        return place;
    }

    public int getHp() {
        return hp;
    }


    public String getName() {
        return name;
    }


    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }


    public int getBaseAttack() {
        return baseAttack;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName();
    }
    public abstract String getInfo();


    protected BaseHero findNearestEnemy(ArrayList<BaseHero> enemies, ArrayList<BaseHero> ours) {
        if (enemies.isEmpty()) {
            return null;
        }
        double minDist = Double.MAX_VALUE;
        BaseHero nearestEnemy = null;
        for (BaseHero enemy : enemies) {
            if (!ours.contains(enemy) && enemy.getHp() > 0) {
                double distance = place.calcDist(enemy.getPlace());
                if (distance < minDist) {
                    minDist = distance;
                    nearestEnemy = enemy;
                }
            }
        }
        return nearestEnemy;
    }
}

