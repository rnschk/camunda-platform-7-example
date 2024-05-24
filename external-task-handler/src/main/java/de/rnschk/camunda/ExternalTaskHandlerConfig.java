package de.rnschk.camunda;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.backoff.BackoffStrategy;
import org.camunda.bpm.client.backoff.ExponentialBackoffStrategy;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Map;

@Slf4j
@Configuration
public class ExternalTaskHandlerConfig {

    @Value("${camunda.bpm.client.worker-id}")
    private String workerId;

    @PostConstruct
    public void hello() {
        log.info("Hallo worker '{}'", shortMeIfYouCan(workerId));
    }

    @Bean
    public BackoffStrategy backoffStrategy() {
        return new ExponentialBackoffStrategy(1000L, 2, 300000L);
    }

    @Bean
    @ExternalTaskSubscription("topic1")
    public ExternalTaskHandler topic1() {
        return (task, service) -> {
            sleep();
            var who = shortMeIfYouCan(workerId);
            log.info("worker '{}' doing some work for topic1", who);
            service.complete(task, Map.of("workerId", who));
        };
    }

    @Bean
    @ExternalTaskSubscription("topic2")
    public ExternalTaskHandler topic2() {
        return (task, service) -> {
            sleep();
            var who = shortMeIfYouCan(workerId);
            log.info("worker '{}' doing some work for topic2", who);
            service.complete(task, Map.of("workerId", who));
        };
    }

    @SneakyThrows
    private static void sleep() {
        Thread.sleep(Duration.ofSeconds(2));
    }

    private static String shortMeIfYouCan(final String uuid) {
        return uuid.split("-")[0];
    }

}
