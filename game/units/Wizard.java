package units;

import java.util.ArrayList;

public abstract class Wizard extends BaseHero {
    public Wizard(int hp, String name, String type, int baseAttack, int initiative, int mp, int lighting, int fireBall, int x, int y) {
        super(hp, name, type, baseAttack, initiative, mp, x, y);
        this.Lighting = lighting;
        this.FireBall = fireBall;
    }

    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> ours) {
        BaseHero nearestEnemy = findNearestEnemy(enemies, ours);

        if (nearestEnemy != null) {
            if (mp >= 15) {
                useLighting(nearestEnemy);
                mp -= 15;
            } else if (mp >= 20) {
                useFireBall(nearestEnemy);
                mp -= 20;
            } else {

                nearestEnemy.hp -= this.baseAttack;
            }
        }
    }

    public int Lighting;
    public int FireBall;

    // Метод использования заклинания FireBall
    public void useFireBall(BaseHero nearestEnemy) {
        if (mp >= FireBall) {
            System.out.println(name + " casts FireBall on " + nearestEnemy.name + "!");
            int damage = 25;
            nearestEnemy.hp -= damage;
            System.out.println(nearestEnemy.name + " takes " + damage + " damage.");
            mp -= FireBall;
        } else {
            System.out.println(name + " tries to cast FireBall, but doesn't have enough mp!");
        }
    }

    // Метод использования заклинания Lighting
    public void useLighting(BaseHero nearestEnemy) {
        if (mp >= Lighting) {
            System.out.println(name + " casts Lighting on " + nearestEnemy.name + "!");
            int damage = 15;
            nearestEnemy.hp -= damage;
            System.out.println(nearestEnemy.name + " takes " + damage + " damage.");
            mp -= Lighting;
        } else {
            System.out.println(name + " tries to cast Lighting, but doesn't have enough mp!");
        }
    }
}


