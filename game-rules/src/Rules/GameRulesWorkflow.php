<?php

declare(strict_types=1);

namespace Temporal\SnakeGame\Rules;

use Temporal\Workflow;

class GameRulesWorkflow implements GameRulesWorkflowInterface
{

    private array $x = array();
    private array $y = array();
    private int $dots = 3;
    private mixed $gameInfoObj;
    private bool $exit = false;

    public function exec($gameInfoStr)
    {
        $this->gameInfoObj = json_decode($gameInfoStr);

        $this->x = array_fill(0, $this->gameInfoObj->{'allDots'}, 0);
        $this->x = array_fill(0, $this->gameInfoObj->{'allDots'}, 0);

        Workflow::await(fn() => $this->exit == true );
    }

    public function getX(): array
    {
        return $this->x;
    }

    public function getY(): array
    {
        return $this->y;
    }

    public function getDots(): int
    {
        return $this->dots;
    }

    public function init(): void
    {
        for($z = 0; $z < $this->dots; $z++) {
            $this->x[$z] = 50 - $z * 10;
            $this->y[$z] = 50;
        }
    }

    public function move(): void
    {
        for ($z = $this->dots; $z > 0; $z--) {
            $this->x[$z] = $this->x[($z - 1)];
            $this->y[$z] = $this->y[($z - 1)];
        }
    }

    public function moveLeft(): void
    {
        $this->x[0] -= $this->gameInfoObj->{'dotSize'};
    }

    public function moveRight(): void
    {
        $this->x[0] += $this->gameInfoObj->{'dotSize'};
    }

    public function moveUp(): void
    {
        $this->y[0] -= $this->gameInfoObj->{'dotSize'};
    }

    public function moveDown(): void
    {
        $this->y[0] += $this->gameInfoObj->{'dotSize'};
    }

    public function addDot(): void {
        $this->dots = $this->dots + 1;
    }

    public function exitGame(): void
    {
        $this->exit = true;
    }
}