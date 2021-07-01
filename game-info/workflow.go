package gameinfo

import (
	"go.temporal.io/sdk/workflow"
)

type GameInfo struct {
	BWidth          int       `json:"bWidth"`
	BHeight         int       `json:"bHeight"`
	DotSize         int       `json:"dotSize"`
	AllDots         int       `json:"allDots"`
	RandPos         int       `json:"randPos"`
	Delay           int       `json:"delay"`
	Resizable       bool      `json:"resizable"`
	Title           string    `json:"title"`
	DotImg          string    `json:"dotImg"`
	AppleImg        string    `json:"appleImg"`
	HeadImg         string    `json:"headImg"`
	TemporalImg     string    `json:"temporalImg"`
	Focusable       bool      `json:"focusable"`
	GameOverMessage string    `json:"gameOverMessage"`
	FontName        string    `json:"fontName"`
	FontSize        int       `json:"fontSize"`
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
