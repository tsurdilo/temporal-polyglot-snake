<?php

declare(strict_types=1);

namespace Temporal\SnakeGame\Rules;

use Temporal\Workflow\QueryMethod;
use Temporal\Workflow\WorkflowInterface;
use Temporal\Workflow\WorkflowMethod;
use Temporal\Workflow\SignalMethod;

#[WorkflowInterface]
interface GameRulesWorkflowInterface
{
    #[WorkflowMethod(name: "BoardRules.new")]
    public function exec(
        int $allDots, int $dotSize
    );

    #[QueryMethod]
    public function getX(): array;

    #[QueryMethod]
    public function getY(): array;

    #[QueryMethod]
    public function getDots(): int;

    #[SignalMethod]
    public function init(): void;

    #[SignalMethod]
    public function move(): void;

    #[SignalMethod]
    public function moveLeft(): void;

    #[SignalMethod]
    public function moveRight(): void;

    #[SignalMethod]
    public function moveUp(): void;

    #[SignalMethod]
    public function moveDown(): void;

    #[SignalMethod]
    public function addDot(): void;

    #[SignalMethod]
    public function exitGame(): void;

}