package de.rnschk.camunda.process1;

import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.camunda.spin.plugin.variable.SpinValues.jsonValue;

@Configuration
public class DelegatesConfig {
    private static final Logger log = LoggerFactory.getLogger(DelegatesConfig.class);

    @Bean
    public JavaDelegate delegate1() {
        return execution -> log.info("Hello from delegate1!");
    }

    @Bean
    public JavaDelegate generateSubprocesses() {
        return execution -> execution.setVariable("subprocesses", jsonValue("[\"subprocess1\", \"subprocess2\"]"));
    }
}
