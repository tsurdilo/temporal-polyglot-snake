package gameinfo

import (
	"context"
	"go.temporal.io/sdk/activity"
)

func GameInfoActivity(ctx context.Context) (string, error) {

	logger := activity.GetLogger(ctx)

	gi := `{
		"bWidth": 300,
		"bHeight":   300,
		"dotSize":   10,
		"allDots":   900,
		"randPos":   29,
		"delay":     140,
		"resizable": false,
		"title":     "Temporal Snake Game",
		"dotimg": "src/main/resources/dot.png",
        "appleimg": "src/main/resources/apple.png",
		"headimg": "src/main/resources/head.png",
        "temporalimg": "src/main/resources/temporal-logo.png",
		"focusable": true,
        "gameOverMessage": "Game Over",
        "fontName": "Helvetica",
        "fontSize": 14
	}`

	logger.Info("Returning Game Info")

	return gi, nil
}
