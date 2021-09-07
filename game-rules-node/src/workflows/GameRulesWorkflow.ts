import { Trigger } from '@temporalio/workflow';
import { GameRulesWorkflowInterface } from '../interfaces/workflows';

let x: number[];
let y: number[];
let dots = 3;
let allDots: number;
let dotSize: number;
let exit: boolean;
let trigger: Trigger<void>;

async function main(iAllDots: number, iDotSize: number): Promise<void> {
  allDots = iAllDots;
  dotSize = iDotSize;
  while (!exit) {
    await (trigger = new Trigger<void>())
  }
}

function getX(): number[] { return x; }

function getY(): number[] { return y; }

function getDots(): number { return dots; }

function init(): void {
  x = new Array<number>(allDots).fill(0);
  y = new Array<number>(allDots).fill(0);
  for (let i = dots; --i >= 0; ) {
    x[i] = 50 - i * 10;
    y[i] = 50;
  }
  trigger.resolve();
}

function move(): void {
  for (let i = dots; --i >= 0; ) {
    x[i + 1] = x[i];
    y[i + 1] = y[i];
  }
  trigger.resolve();
}

function moveLeft(): void {
  x[0] -= dotSize;
  trigger.resolve();
}

function moveRight(): void {
  x[0] += dotSize;
  trigger.resolve();
}

function moveUp(): void {
  y[0] -= dotSize;
  trigger.resolve();
}

function moveDown(): void {
  y[0] += dotSize;
  trigger.resolve();
}

function addDot(): void {
  dots++;
  trigger.resolve();
}

function exitGame(): void {
  exit = true;
  trigger.resolve();
}

export const workflow: GameRulesWorkflowInterface = {
  main,
  queries: {
    getX,
    getY,
    getDots
  },
  signals: {
    init,
    move,
    moveLeft,
    moveRight,
    moveUp,
    moveDown,
    addDot,
    exitGame
  }
}
