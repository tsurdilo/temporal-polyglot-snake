package io.temporal.snakegame.controller;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class GameControllerActivitiesImpl implements GameControllerActivities {
    public static final String GAME_INFO_TASK_QUEUE = "InfoTaskQueue";
    public static final String GAME_INFO_WORKFLOW_TYPE = "GameInfoWorkflow";
    private static final WorkflowServiceStubs SERVICE = WorkflowServiceStubs.newInstance();
    private static final WorkflowClient CLIENT = WorkflowClient.newInstance(SERVICE);
    private static final WorkflowOptions GAME_INFO_WORKFLOW_OPTIONS = WorkflowOptions.newBuilder()
            .setWorkflowId("temporalSnakeGameInfoWorkflow")
            .setTaskQueue(GAME_INFO_TASK_QUEUE)
            .build();

    @Override
    public GameInfo getGameInfo() {
        WorkflowStub gameInfoStub = CLIENT.newUntypedWorkflowStub(GAME_INFO_WORKFLOW_TYPE, GAME_INFO_WORKFLOW_OPTIONS);
        gameInfoStub.start();

        return gameInfoStub.getResult(GameInfo.class);

    }
}
