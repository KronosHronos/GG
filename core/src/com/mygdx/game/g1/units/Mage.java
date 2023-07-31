package com.mygdx.game.g1.units;

import java.util.ArrayList;

public class Mage extends Wizard {
    public Mage(String name, int x, int y) {
        super(90, name, "Mage", 8, 3, 150, 20, 15, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> ours) {
        if (hp <= 0) {
            return;
        }
        BaseHero nearestEnemy = findNearestEnemy(enemies, ours);

        if (nearestEnemy != null && nearestEnemy != this) {
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

    @Override
    public String getInfo() {
        return name + "  " + type +", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative + ", mp: " + mp + ", Spell: FireBall " + FireBall + ", Spell: Lighting " + Lighting ;
    }
}

