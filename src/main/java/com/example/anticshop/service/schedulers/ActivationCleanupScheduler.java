package com.example.anticshop.service.schedulers;

import com.example.anticshop.service.UserActivationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ActivationCleanupScheduler {

    private final UserActivationService userActivationService;

    public ActivationCleanupScheduler(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    @Scheduled(cron = "0 30 23 L * ?")
    public void cleanUp() {
        System.out.println("Trigger cleanup." + LocalDateTime.now());
        userActivationService.cleanUpActivation();
    }

}

