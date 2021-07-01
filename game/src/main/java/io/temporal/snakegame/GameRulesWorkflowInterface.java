package io.temporal.snakegame;

import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface GameRulesWorkflowInterface {
    @WorkflowMethod(name = "BoardRules.new")
    public void exec(String gameInfoStr);

    @QueryMethod
    public int[] getX();

    @QueryMethod
    public int[] getY();

    @QueryMethod
    public int getDots();

    @SignalMethod
    public void init();

    @SignalMethod
    public void move();

    @SignalMethod
    public void moveLeft();

    @SignalMethod
    public void moveRight();

    @SignalMethod
    public void moveUp();

    @SignalMethod
    public void moveDown();

    @SignalMethod
    public void addDot();

    @SignalMethod
    public void exitGame();
}
