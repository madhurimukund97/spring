package com.example.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

  private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataJpaApplication.class);
  }

  @Bean
  public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Customer("Madhuri", "M"));
      repository.save(new Customer("Sahithi", "S"));
      repository.save(new Customer("SSAI", "SS"));
      repository.save(new Customer("David", "Br"));
      repository.save(new Customer("Manchola", "Tessli"));

      // fetch all customers
      log.info("Customers info:");
      log.info("-------------------------------");
      for (Customer customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      Customer customer = repository.findById(1L);
      log.info("Customer findById-1");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Br'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Br").forEach(br -> {
        log.info(br.toString());
      });
      
      log.info("");
    };
  }

}