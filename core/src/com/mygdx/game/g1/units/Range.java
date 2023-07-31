package com.mygdx.game.g1.units;

import java.util.ArrayList;

public abstract class Range extends BaseHero {
    protected int ammo;

    public Range(int hp, String name, String type, int baseAttack, int initiative, int mp, int ammo, int x, int y) {
        super(hp, name, type, baseAttack, initiative, mp, x, y);
        this.ammo = ammo;
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> ours) {
        if (this.hp <= 0 || this.ammo == 0) return;

        BaseHero nearestEnemy = findNearestEnemy(enemies, ours);

        if (nearestEnemy != null && nearestEnemy.getHp() > 0) {

            int dx = nearestEnemy.getPlace().x - getPlace().x;
            int dy = nearestEnemy.getPlace().y - getPlace().y;


            if (Math.abs(dx) <= 1 && Math.abs(dy) <= 1) {
                attack(nearestEnemy);
            }
        }
    }

    private void attack(BaseHero enemy) {
        int damage = getBaseAttack();
        enemy.takeDamage(damage);
        System.out.println(getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
        this.ammo--;
    }

    @Override
    public String getInfo() {
        return name + " " + type + ", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative +
                ", mp: " + mp + ", Ammo: " + ammo;
    }
}


