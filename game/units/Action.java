package units;

import java.util.ArrayList;

public interface Action {
    void step(ArrayList<BaseHero> enemies,ArrayList<BaseHero> ours);
    String getInfo();
}

