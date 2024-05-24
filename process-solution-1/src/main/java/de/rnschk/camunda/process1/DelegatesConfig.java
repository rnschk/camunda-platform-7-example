package de.rnschk.camunda.process1;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.camunda.spin.plugin.variable.SpinValues.jsonValue;

@Slf4j
@Configuration
public class DelegatesConfig {

    @Bean
    public JavaDelegate someDelegate() {
        return execution -> log.info("Hello from some delegate!");
    }

    @Bean
    public JavaDelegate generateSubprocesses() {
        return execution -> execution.setVariable("subprocesses", jsonValue("[\"subprocess1\", \"subprocess2\"]"));
    }
}
