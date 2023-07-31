package com.mygdx.game.g1.units;

import java.util.ArrayList;

public class Cultist extends Healers{
    public Cultist (String name,int x, int y) {
        super(100, name, "Monk", 5, 4, 130, 6,x,y);
    }



    @Override
    public String getInfo() {
        return  name + " " + type +", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative + ", mp: " + mp +", Spell: Heal " + heal ;
    }
}