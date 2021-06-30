package io.temporal.snakegame.controller;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class ControllerStarter {

    public static final String CONTROLLER_TASK_QUEUE = "ControllerTaskQueue";

    public static void main(String[] args) {
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(CONTROLLER_TASK_QUEUE);

        worker.registerWorkflowImplementationTypes(GameControllerImpl.class);
        worker.registerActivitiesImplementations(new GameControllerActivitiesImpl());

        factory.start();
    }
}
