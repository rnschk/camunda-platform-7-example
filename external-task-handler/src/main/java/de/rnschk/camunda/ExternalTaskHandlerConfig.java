package de.rnschk.camunda;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.backoff.BackoffStrategy;
import org.camunda.bpm.client.backoff.ExponentialBackoffStrategy;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ExternalTaskHandlerConfig {

    @Bean
    public BackoffStrategy backoffStrategy() {
        return new ExponentialBackoffStrategy(1000L, 2, 300000L);
    }

    @Bean
    @ExternalTaskSubscription("topic1")
    public ExternalTaskHandler topic1() {
        return (task, service) -> {
            log.info("doing some work for topic1");
            service.complete(task);
        };
    }

    @Bean
    @ExternalTaskSubscription("topic2")
    public ExternalTaskHandler topic2() {
        return (task, service) -> {
            log.info("doing some work for topic2");
            service.complete(task);
        };
    }

}
