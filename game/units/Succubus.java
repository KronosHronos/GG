package units;

import java.util.ArrayList;

public class Succubus extends Range{
    private int Fleshexplosion;
    public Succubus(String name,int x, int y) {
        super(70, name, "Succubus", 12, 5, 60,25, x, y);
        this.Fleshexplosion=40;
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
        return  name + "  " + type +", ♡: " + hp + ", Attack: " + baseAttack + ", Init: " + initiative + ", mp: " + 60 +", Spell: Fleshexplosion " + Fleshexplosion + " " + "Ammo = " + ammo + "  " + "X = " + place.x +"  "+ "Y = " + place.y;

    }
}

