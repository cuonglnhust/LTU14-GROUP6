package teamGraphics;

import entity.unchanged.Cage;
import entity.unchanged.DicePlace;
import entity.unchanged.Rank;
import entity.unchanged.Step;
import graphics.CreateImage;
import map.EntityPosition;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Orange extends Team {

    private final Color ORANGE_RANK_BACKGROUND = Color.decode("#ffb163");
    private final int FIRST_POSITION = 28;
    private final int LAST_POSITION = 27;
    private final int FIRST_HORIZONTAL_POSITION = 34;
    private final int FIRST_VERTICAL_POSITION = 35;


    public Orange() {
        cage = new Cage(CreateImage.orangeBackground, EntityPosition.ORANGE_CAGE_X, EntityPosition.ORANGE_CAGE_Y);
        dicePlace = new DicePlace(CreateImage.orangeDice, EntityPosition.ORANGE_DICE_PLACE_X, EntityPosition.ORANGE_DICE_PLACE_Y);
        initialRank();
        initialStep();
    }

    @Override
    public void initialRank() {
        ranks = new ArrayList<>();
        int orangeYMax = EntityPosition.ORANGE_RANK_Y_MAX;
        for (int i = 0; i < NUMBER_OF_RANK; i++) {
            ranks.add(new Rank(CreateImage.orangeRanks.get(i), EntityPosition.ORANGE_RANK_X, orangeYMax, true, ORANGE_RANK_BACKGROUND));
            orangeYMax -= RANK_DISTANCE;
        }
    }

    @Override
    public void initialStep() {
        steps = new HashMap<>();
        steps.put(FIRST_POSITION,new Step(CreateImage.orangePoint, EntityPosition.ORANGE_FIRST_X, EntityPosition.ORANGE_FIRST_Y));
        steps.put(LAST_POSITION,new Step(CreateImage.orangeCircle, EntityPosition.ORANGE_END_X, EntityPosition.ORANGE_END_Y));
        int orangeHorizontalMinY = EntityPosition.ORANGE_STEP_HORIZONTAL_FIRST_Y;
        int orangeVerticalMinX = EntityPosition.ORANGE_STEP_VERTICAL_FIRST_X;
        int firstHorizontalPosition = FIRST_HORIZONTAL_POSITION;
        int firstVerticalPosition = FIRST_VERTICAL_POSITION;
        // dọc giảm, ngang tăng
        for (int i = 0; i < NUMBER_OF_STEP; i++) {
            steps.put(firstHorizontalPosition,new Step(CreateImage.orangeCircle, EntityPosition.ORANGE_STEP_HORIZONTAL_X, orangeHorizontalMinY));
            steps.put(firstVerticalPosition,new Step(CreateImage.orangeCircle, orangeVerticalMinX, EntityPosition.ORANGE_STEP_VERTICAL_Y));
            orangeHorizontalMinY += STEP_DISTANCE;
            orangeVerticalMinX += STEP_DISTANCE;
            firstHorizontalPosition--;
            firstVerticalPosition++;
        }
    }
}
