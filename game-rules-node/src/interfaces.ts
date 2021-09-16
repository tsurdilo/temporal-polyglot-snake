export type GameRulesWorkflowInterface = (allDots: number, dotSize: number) => {
  // FIXME: @WorkflowMethod(name = "BoardRules.new")
  execute(): Promise<void>;
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
