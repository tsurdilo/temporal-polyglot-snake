package io.temporal.snakegame;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import io.temporal.serviceclient.WorkflowServiceStubs;

import javax.swing.*;

public class SnakeGame extends JFrame {

    private static final WorkflowServiceStubs SERVICE = WorkflowServiceStubs.newInstance();
    private static final WorkflowClient CLIENT = WorkflowClient.newInstance(SERVICE);

    private static final String CONTROLLER_TASK_QUEUE = "ControllerTaskQueue";
    private static final String CONTROLLER_WORKFLOW_TYPE = "snakegamecontroller";
    private static final WorkflowOptions CONTROLLER_WORKFLOW_OPTIONS = WorkflowOptions.newBuilder()
            .setWorkflowId("temporalSnakeGameControllerWorkflow")
            .setTaskQueue(CONTROLLER_TASK_QUEUE)
            .build();

    private static final String BOARD_RULES_TASK_QUEUE = "RulesTaskQueue";
    //private static final String BOARD_RULES_WORKFLOW_TYPE = "BoardRules.new";
    private static final WorkflowOptions BOARD_RULES_WORKFLOW_OPTIONS = WorkflowOptions.newBuilder()
            .setWorkflowId("temporalSnakeGameBoardRulesWorkflow")
            .setTaskQueue(BOARD_RULES_TASK_QUEUE)
            .build();

    private WorkflowStub controllerStub;
    private GameRulesWorkflowInterface boardRulesWorkflow;

    public SnakeGame() {
        controllerStub = CLIENT.newUntypedWorkflowStub(CONTROLLER_WORKFLOW_TYPE, CONTROLLER_WORKFLOW_OPTIONS);
        controllerStub.start();

        boardRulesWorkflow = CLIENT.newWorkflowStub(GameRulesWorkflowInterface.class, BOARD_RULES_WORKFLOW_OPTIONS);

        //boardRulesStub = CLIENT.newUntypedWorkflowStub(BOARD_RULES_WORKFLOW_TYPE, BOARD_RULES_WORKFLOW_OPTIONS);
        //boardRulesStub.start();

        GameInfo gameInfo = null;
        boolean gotGameInfo = false;

        while (!gotGameInfo) {
            gameInfo = controllerStub.query("getGameInfo", GameInfo.class);
            if (gameInfo != null) {
                gotGameInfo = true;
            }
        }

        add(new GameBoard(gameInfo, boardRulesWorkflow));
        setResizable(gameInfo.isResizable());
        pack();

        setTitle(gameInfo.getTitle());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public WorkflowStub getControllerStub() {
        return controllerStub;
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(operation);
    }
}
