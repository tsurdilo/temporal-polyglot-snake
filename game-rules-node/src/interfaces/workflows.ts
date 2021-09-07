import { Workflow } from '@temporalio/workflow';

export interface GameRulesWorkflowInterface extends Workflow {
  // FIXME: @WorkflowMethod(name = "BoardRules.new")
  main(allDots: number, dotSize: number): Promise<void>;
  queries: {
    getX(): number[];
    getY(): number[];
    getDots(): number;
  }
  signals: {
    init(): void;
    move(): void;
    moveLeft(): void;
    moveRight(): void;
    moveUp(): void;
    moveDown(): void;
    addDot(): void;
    exitGame(): void;
  }
}
