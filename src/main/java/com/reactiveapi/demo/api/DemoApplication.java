package com.reactiveapi.demo.api;
import com.reactiveapi.demo.GreetingClient;
import com.reactiveapi.demo.RestClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
   SpringApplication.run(DemoApplication.class, args);
  }
} 