package player.remote;

import constant.TeamType;
import entity.changed.local.Dice;
import entity.changed.local.HorseOrange;
import entity.changed.remote.DiceCopy;
import entity.changed.remote.HorseCopyOrange;
import graphics.Constant;
import map.EntityPosition;

import java.awt.*;

public class PlayerCopyOrange extends PlayerCopy {

    public PlayerCopyOrange(int id) {
        super(id);
        Constant.initHorseOrange();
        initHorseCopy();
        diceCopy = new DiceCopy(EntityPosition.ORANGE_DICE_PLACE_X, EntityPosition.ORANGE_DICE_PLACE_Y);
        team = TeamType.TEAM_ORANGE;
    }

    @Override
    public void initHorseCopy() {
        super.initHorseCopy();
        for (int i = 0; i < 4; i++) {
            Point point = Constant.orangeHorseTeam.get(i);
            horseCopies.add(new HorseCopyOrange(i, point.x, point.y));
        }
    }
}