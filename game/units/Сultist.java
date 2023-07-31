package units;

import java.util.ArrayList;

public class Сultist extends Healers {
    public Сultist(String name, int x, int y) {
        super(100, name, "Сultist", 5, 4, 130, 6, x, y);
    }




    @Override
    public String getInfo() {
        return name + "  " + type + ", ♡ : " + hp + ", Attack: " + baseAttack + ", Init: " + initiative + ", mp: " + mp + ", Spell: Heal " + heal ;
    }
}



