package de.rnschk.camunda.webapp;

import de.rnschk.camunda.webapp.branding.CustomBrandingProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({CustomBrandingProperties.class})
public class CamundaWebapp {

  // Custom Branding: https://github.com/viadee/camunda-platform-7-examples/tree/main/cockpit/custom-branding

  public static void main(String[] args) {
    SpringApplication.run(CamundaWebapp.class, args);
  }
}
