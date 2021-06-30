package io.temporal.snakegame.controller;

import io.temporal.activity.ActivityInterface;
import com.fasterxml.jackson.databind.JsonNode;

@ActivityInterface
public interface GameControllerActivities {
    JsonNode getGameInfo();
}
