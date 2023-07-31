package units;

import java.util.ArrayList;

public class Hound extends Infantry{
    public Hound(String name,int x,int y) {
        super(150, name, "Hound", 20, 7, 0,x,y);
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
        return  name + "  " + type +", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative + ", mp: " + mp;
    }
}


