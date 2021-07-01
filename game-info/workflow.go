package gameinfo

import (
	"go.temporal.io/sdk/workflow"
)

type GameInfo struct {
	BWidth          int
	BHeight         int
	DotSize         int
	AllDots         int
	RandPos         int
	Delay           int
	Resizable       bool
	Title           string
	DotImg          string
	AppleImg        string
	HeadImg         string
	TemporalImg     string
	Focusable       bool
	GameOverMessage string
	FontName        string
	FontSize        int
}

func GameInfoWorkflow(ctx workflow.Context) (*GameInfo, error) {
	workflow.GetLogger(ctx).Info("Game Info workflow started.", "StartTime", workflow.Now(ctx))

	return &GameInfo{
		BWidth:          300,
		BHeight:         300,
		DotSize:         10,
		AllDots:         900,
		RandPos:         29,
		Delay:           140,
		Resizable:       false,
		Title:           "Temporal Snake Game",
		DotImg:          "src/main/resources/dot.png",
		AppleImg:        "src/main/resources/apple.png",
		HeadImg:         "src/main/resources/head.png",
		TemporalImg:     "src/main/resources/temporal-logo.png",
		Focusable:       true,
		GameOverMessage: "Game Over",
		FontName:        "Helvetica",
		FontSize:        14,
	}, nil
}
