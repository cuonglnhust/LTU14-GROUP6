package player.remote;

import constant.TeamType;
import entity.changed.local.Dice;
import entity.changed.local.HorseViolet;
import entity.changed.remote.DiceCopy;
import entity.changed.remote.HorseCopyViolet;
import graphics.Constant;
import map.EntityPosition;

import java.awt.*;

public class PlayerCopyViolet extends PlayerCopy {

    public PlayerCopyViolet(int id) {
        super(id);
        Constant.initHorseViolet();
        initHorseCopy();
        diceCopy = new DiceCopy(EntityPosition.VIOLET_DICE_PLACE_X,EntityPosition.VIOLET_DICE_PLACE_Y);
        team = TeamType.TEAM_VIOLET;
    }

    @Override
    public void initHorseCopy() {
        super.initHorseCopy();
        for (int i = 0; i < 4; i++) {
            Point point = Constant.violetHorseTeam.get(i);
            horseCopies.add(new HorseCopyViolet(i, point.x, point.y));
        }
    }
}