package main

import (
	"log"

	"go.temporal.io/sdk/client"
	"go.temporal.io/sdk/worker"

	"gameinfo.workflow/v1"
)

func main() {
	c, err := client.NewClient(client.Options{})
	if err != nil {
		log.Fatalln("Unable to create client", err)
	}
	defer c.Close()

	w := worker.New(c, "InfoTaskQueue", worker.Options{})
	w.RegisterWorkflow(gameinfo.GameInfoWorkflow)
	w.RegisterActivity(gameinfo.GameInfoActivity)

	err = w.Run(worker.InterruptCh())
	if err != nil {
		log.Fatalln("Unable to start worker", err)
	}
}
