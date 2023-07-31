package com.mygdx.game.g1.units;

import java.util.ArrayList;

public class Imp extends BaseHero{
    public Imp(String name,int x,int y) {
        super(60, name, "Imp", 6, 3, 0,x,y);
    }

    public boolean busy = false;

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> ours) {
        BaseHero nearestEnemy = findNearestEnemy(enemies, ours);
        if (this.hp > 0) this.busy=false;

    }

    @Override
    public String getInfo() {
        return  name + "  " + type +", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative + ", mp: " + mp ;
    }
}

