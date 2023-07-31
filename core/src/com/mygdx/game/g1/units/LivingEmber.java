package com.mygdx.game.g1.units;

import java.util.ArrayList;

public class LivingEmber extends Range{
    public LivingEmber(String name,int x,int y) {

        super(90, name, "LivingEmber", 10, 6, 0,30,x,y);
    }

    @Override
    public void step(ArrayList<BaseHero> enemies,ArrayList<BaseHero> ours) {
        for (BaseHero item: ours){
            if (item.type.contains("Imp") && !((Imp) item).busy && item.hp > 0) {
                ((Imp) item).busy = true;
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
        return  name + "  " + type +", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative + ", mp: " + mp + " " + "Ammo = " + ammo ;
    }
}