package org.netprime.component;

import org.netprime.service.impl.TaskServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomTaskScheduler {

    private final TaskServiceImpl taskService;

    public CustomTaskScheduler(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    // Run every hour to check for due tasks and update statuses
    @Scheduled(fixedRate = 3600000)
    public void scheduleTaskChecks() {
        taskService.scheduleTaskChecks();
    }
}
