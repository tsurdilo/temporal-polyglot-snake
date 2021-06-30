package gameinfo

import (
	"time"

	"go.temporal.io/sdk/workflow"
)

func GameInfoWorkflow(ctx workflow.Context) (string, error) {
	ao := workflow.ActivityOptions{
		StartToCloseTimeout: 2 * time.Second,
	}

	ctx = workflow.WithActivityOptions(ctx, ao)

	gameInfo := "{}"
	err := workflow.ExecuteActivity(ctx, GameInfoActivity).Get(ctx, &gameInfo)

	return gameInfo, err
}
