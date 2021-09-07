package io.temporal.snakegame;

import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface GameRulesWorkflowInterface {
    // FIXME: Node SDK uses workflow filename as name
    @WorkflowMethod(name = "GameRulesWorkflow")
    // FIXME: Node SDK requires main function
    void main(int allDots, int dotSize);

    @QueryMethod
    int[] getX();

    @QueryMethod
    int[] getY();

    @QueryMethod
    int getDots();

    @SignalMethod
    void init();

    @SignalMethod
    void move();

    @SignalMethod
    void moveLeft();

    @SignalMethod
    void moveRight();

    @SignalMethod
    void moveUp();

    @SignalMethod
    void moveDown();

    @SignalMethod
    void addDot();

    @SignalMethod
    void exitGame();
}
