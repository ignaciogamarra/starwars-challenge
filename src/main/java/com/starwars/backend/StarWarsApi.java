package com.starwars.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.starwars.backend")
public class StarWarsApi {
  public static void main(String[] args) {
    SpringApplication.run(StarWarsApi.class,args);
  }
}