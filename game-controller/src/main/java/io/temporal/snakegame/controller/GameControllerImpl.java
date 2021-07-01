package io.temporal.snakegame.controller;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;

import java.time.Duration;

public class GameControllerImpl implements GameController {

    private final GameControllerActivities activities =
            Workflow.newActivityStub(
                    GameControllerActivities.class,
                    ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(5)).build());

    private GameInfo gameInfo;
    private boolean exit;
    private Logger logger = Workflow.getLogger("GameControllerImpl");

    @Override
    public void startGame() {
        logger.info("Getting Game Info");
        gameInfo = activities.getGameInfo();

        Workflow.await(() -> exit == true);
    }

    @Override
    public void exitGame() {
        exit = true;
    }

    @Override
    public GameInfo getGameInfo() {
        return gameInfo;
    }
}
