package io.temporal.snakegame.controller;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface GameControllerActivities {
    GameInfo getGameInfo();
}
