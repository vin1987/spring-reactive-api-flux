package com.reactiveapi.demo;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.stream.Stream;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RestClient {

  private final WebClient client;

  public RestClient(WebClient.Builder builder) {
    this.client = builder.baseUrl("http://localhost:8080").build();
  }
  
  public Flux<String> getNewMessage(){
    return this.client.get().uri("/count").accept(MediaType.TEXT_EVENT_STREAM)  
          .retrieve()
          .bodyToFlux(String.class)
          .map(S -> String.valueOf(S));      
  }

}
