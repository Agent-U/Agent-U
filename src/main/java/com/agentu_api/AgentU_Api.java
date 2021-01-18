package com.agentu_api;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
public class AgentU_Api {

    public static void main(String... args){
        SpringApplication.run(AgentU_Api.class, args);
    }

    @Bean
    @Autowired
    public CommandLineRunner demo(EtudiantRepository repository) {
        return (args) -> {
            var Bob = new Etudiant("Bob710");
            var Chuck = new Etudiant("Chuck540");

            // save a couple of trainers
            repository.save(Bob);
            repository.save(Chuck);
        };
    }

}
