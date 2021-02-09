package net.dahanne.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Service
public class DemoApplication {


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
      System.out.println(
          this.webClient
              .get()
              .uri("/")
              .retrieve()
              .bodyToMono(String.class)
              .block()
      );
    } catch (RuntimeException e) {
      System.err.println(e.getMessage());
    }
  }

}
