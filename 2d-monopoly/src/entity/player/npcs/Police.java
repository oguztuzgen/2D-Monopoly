package entity.player.npcs;

import entity.Character;
import entity.player.Player;

public class Police extends Character {
    public boolean deal;

    Police(){
        setName("Police");
        setLocation(1);
        deal = false;
    }

    public boolean getAtSameLoc(){
        // todo
        return true;
    }

    public void arrestMafia(){
        //todo
    }

    public void arrestPlayer(Player player){
        //todo
    }

    public boolean isDeal(){
        return deal;
    }
}
