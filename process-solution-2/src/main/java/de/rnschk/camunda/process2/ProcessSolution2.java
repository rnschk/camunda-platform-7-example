package de.rnschk.camunda.process2;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("process-solution-2")
public class ProcessSolution2 {

  public static void main(String[] args) {
    SpringApplication.run(ProcessSolution2.class, args);
  }
}
