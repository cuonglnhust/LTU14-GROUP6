package player;

import constant.TeamType;
import entity.changed.Dice;
import entity.changed.HorseOrange;
import graphics.Constant;
import map.EntityPosition;

import java.awt.*;

public class PlayerOrange extends Player {
    public PlayerOrange() {
        Constant.initHorseOrange();
        initHorse();
        dice = new Dice(EntityPosition.ORANGE_DICE_PLACE_X, EntityPosition.ORANGE_DICE_PLACE_Y);
        team = TeamType.TEAM_ORANGE;
    }

    @Override
    protected void initHorse() {
        super.initHorse();
        for (int i = 0; i < 4; i++) {
            Point point = Constant.orangeHorseTeam.get(i);
            horses.add(new HorseOrange(i, point.x, point.y,this
            ));
        }
    }
}