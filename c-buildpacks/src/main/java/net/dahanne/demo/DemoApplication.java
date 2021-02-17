package net.dahanne.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Service
@RestController
public class DemoApplication {

  private static final Log logger = LogFactory.getLog(DemoApplication.class);

  private final WebClient webClient;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }


  public DemoApplication(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://selfsigned.dahanne.net/").build();
  }

  @PostConstruct
  public void connectToService() {
    try {
      logger.info("Trying to fetch data from self signed cert website");
      logger.info(this.webClient.get().uri("/")
          .retrieve().bodyToMono(String.class).block());
    } catch (WebClientException e) {
      logger.error("Ouch, we could not trust this server certificate; make you sure you add it to your truststore");
      logger.error("Here's the exception message: " + e.getMessage());
    }
  }

  @GetMapping("/")
  public String helloWorld() {
    return "Bonjour monde !";
  }

}
