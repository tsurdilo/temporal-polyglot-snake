import { Trigger } from '@temporalio/workflow'
import { GameRulesWorkflowInterface } from '../interfaces'

export const workflow: GameRulesWorkflowInterface = (allDots: number, dotSize: number) => {
  const exit = new Trigger<void>()
  let x: number[]
  let y: number[]
  let dots = 3
  return {
    async execute(): Promise<void> {
      return await exit
    },
    queries: {
      getX(): number[] {
        return x
      },
      getY(): number[] {
        return y
      },
      getDots(): number {
        return dots
      },
    },
    signals: {
      init(): void {
        x = new Array<number>(allDots).fill(0)
        y = new Array<number>(allDots).fill(0)
        for (let i = dots; --i >= 0; ) {
          x[i] = 50 - i * 10
          y[i] = 50
        }
      },
      move(): void {
        for (let i = dots; --i >= 0; ) {
          x[i + 1] = x[i]
          y[i + 1] = y[i]
        }
      },
      moveLeft(): void {
        x[0] -= dotSize
      },
      moveRight(): void {
        x[0] += dotSize
      },
      moveUp(): void {
        y[0] -= dotSize
      },
      moveDown(): void {
        y[0] += dotSize
      },
      addDot(): void {
        dots++
      },
      exitGame(): void {
        exit.resolve()
      }
    }
  }
}
