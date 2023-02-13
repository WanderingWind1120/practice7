package com.example.practice7.database;

import com.example.practice7.models.Product;
import com.example.practice7.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
   private static Logger logger = LoggerFactory.getLogger(Database.class);

   CommandLineRunner initDatabase (ProductRepository productRepository){
       return new CommandLineRunner(){

           @Override
           public void run(String... args) throws Exception {

           }
       };
   }
}
