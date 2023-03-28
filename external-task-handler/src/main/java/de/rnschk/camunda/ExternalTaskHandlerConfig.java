package de.rnschk.camunda;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalTaskHandlerConfig {
    private static final Logger log = LoggerFactory.getLogger(ExternalTaskHandlerConfig.class);


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
