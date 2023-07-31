package com.mygdx.game.g1.units;

import java.util.ArrayList;

public class Sniper extends Range{
    private int headShot;
    public Sniper(String name,int x, int y) {
        super(70, name, "Sniper", 12, 5, 60,25,x,y);
        this.headShot=40;
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> ours) {
        for (BaseHero item : ours) {
            if (item.type.contains("Farmer") && !((Farmer) item).busy && item.hp > 0) {
                ((Farmer) item).busy = true;
                return;
            }
        }
        this.ammo--;
        BaseHero temp = findNearestEnemy(enemies, ours);
        if (temp != null) {
            temp.hp = temp.hp - this.baseAttack;
        }
    }
    @Override
    public String getInfo() {
        return name + "  " + type +", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative + ", mp: " + 60 +", Spell: HeadShot " + headShot + " " + "Ammo = " + ammo ;

    }
}
