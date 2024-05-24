package de.rnschk.camunda.process2;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OtherDelegate implements JavaDelegate {

  @Override
  public void execute(final DelegateExecution execution) {
    log.info("Hello from {}", this.getClass().getSimpleName());
  }
}
