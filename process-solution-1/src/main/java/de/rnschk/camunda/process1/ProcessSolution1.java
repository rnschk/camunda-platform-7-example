package de.rnschk.camunda.process1;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("process-solution-1")
public class ProcessSolution1 {

  public static void main(String[] args) {
    SpringApplication.run(ProcessSolution1.class, args);
  }
}
