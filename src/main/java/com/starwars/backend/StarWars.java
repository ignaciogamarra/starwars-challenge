package com.starwars.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.starwars.backend")
public class StarWars {
  public static void main(String[] args) {
    SpringApplication.run(StarWars.class,args);
  }
}