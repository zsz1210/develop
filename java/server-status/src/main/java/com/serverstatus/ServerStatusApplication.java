package com.serverstatus;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerStatusApplication implements CommandLineRunner{

    public static void main(String[] args) {
        System.out.println("STARTING THE APPLICATION");
        SpringApplication.run(ServerStatusApplication.class, args);
        System.out.println("APPLICATION FINISHED");
    }
  
    @Override
    public void run(String... args) {
        System.out.println("EXECUTING : command line runner");
        System.out.println("INIT!!");
    }

}
