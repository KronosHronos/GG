package units;

import java.util.ArrayList;

public class Farmer extends BaseHero{
    public Farmer(String name,int x,int y) {
        super(60, name, "Farmer", 6, 3, 0,x,y);
    }

    public boolean busy = false;

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> ours) {
        BaseHero nearestEnemy = findNearestEnemy(enemies, ours);
        if (this.hp > 0) this.busy=false;

    }

    @Override
    public String getInfo() {
        return name + "  " + type +", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative + ", mp: " + mp ;
    }
}
