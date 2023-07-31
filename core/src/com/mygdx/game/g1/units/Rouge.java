package com.mygdx.game.g1.units;

import java.util.ArrayList;

public class Rouge extends Infantry {
    private int assassination;

    public Rouge(String name, int x, int y) {
        super(130, name, "Rouge", 12, 8, 30, x, y);
        this.assassination = 60;
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> ours) {

        super.step(enemies, ours);


        BaseHero nearestEnemy = findNearestEnemy(enemies, ours);
        if (nearestEnemy != null) {
            nearestEnemy.takeDamage(this.baseAttack);
            System.out.println(getName() + " attacks " + nearestEnemy.getName() + " for " + this.baseAttack + " damage!");
        }
    }

    @Override
    public String getInfo() {
        return name + "  " + type + ", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative + ", mp: " + mp + ", Spell: Assassination: " + assassination;
    }
}

