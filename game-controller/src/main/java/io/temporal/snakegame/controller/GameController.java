package io.temporal.snakegame.controller;

import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface GameController {
    @WorkflowMethod(name = "snakegamecontroller")
    void startGame();

    @SignalMethod
    void exitGame();

    @QueryMethod
    GameInfo getGameInfo();
}
