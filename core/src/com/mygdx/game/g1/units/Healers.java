package com.mygdx.game.g1.units;

import java.util.ArrayList;

import java.util.ArrayList;

public abstract class Healers extends BaseHero {
    protected int heal;

    public Healers(int hp, String name, String type, int baseAttack, int initiative, int mp, int heal, int x, int y) {
        super(hp, name, type, baseAttack, initiative, mp, x, y);
        this.heal = heal;
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> ours) {
        if (this.hp > 0) {
            boolean hasHealed = false;

            for (BaseHero item : ours) {
                if (item.hp > 0 && item.hp < 100) {
                    item.hp = Math.min(item.hp + this.heal, 100);
                    System.out.println("Heal: " + item.getName() + " (+" + this.heal + ")");
                    hasHealed = true;
                    break;
                }
            }

            if (!hasHealed) {
                BaseHero nearestEnemy = findNearestEnemy(enemies, ours);
                if (nearestEnemy != null && nearestEnemy.getHp() > 0) {
                    attack(nearestEnemy);
                }
            }
        }
    }

    private void attack(BaseHero enemy) {
        int damage = getBaseAttack();
        enemy.takeDamage(damage);
        System.out.println(getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
    }

    @Override
    public String getInfo() {
        return name + " " + type + ", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative +
                ", mp: " + mp + ", Heal: " + heal;
    }
}


