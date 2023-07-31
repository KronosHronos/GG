package units;

import java.util.ArrayList;

public abstract class Infantry extends BaseHero {
    public Infantry(int hp, String name, String type, int baseAttack, int initiative, int mp, int x, int y) {
        super(hp, name, type, baseAttack, initiative, mp, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> ours) {
        BaseHero nearestEnemy = findNearestEnemy(enemies, ours);

        if (getHp() <= 0) {
            return;
        }

        if (nearestEnemy != null && nearestEnemy.getHp() > 0) {

            int targetX = nearestEnemy.getPlace().x;
            int targetY = nearestEnemy.getPlace().y;

            int dx = targetX - getPlace().x;
            int dy = targetY - getPlace().y;


            if (Math.abs(dx) <= 1 && Math.abs(dy) <= 1) {
                attack(nearestEnemy);
            } else {

                move(dx, dy, enemies);
            }
        }
    }

    private void attack(BaseHero enemy) {
        int damage = getBaseAttack();
        enemy.takeDamage(damage);
        System.out.println(getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
    }

    private void move(int dx, int dy, ArrayList<BaseHero> ours) {
        int newX = getPlace().x + Integer.signum(dx);
        int newY = getPlace().y + Integer.signum(dy);


        for (BaseHero hero : ours) {
            if (hero.getPlace().x == newX && hero.getPlace().y == newY && hero.getHp() > 0) {

                return;
            }
        }


        getPlace().x = newX;
        getPlace().y = newY;
        System.out.println(getName() + " moves to (" + newX + ", " + newY + ")");
    }
}

