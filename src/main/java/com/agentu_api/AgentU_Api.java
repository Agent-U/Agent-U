package com.agentu_api;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Incident;
import com.agentu_api.repository.EtudiantRepository;
import com.agentu_api.repository.IncidentRepository;
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
    public CommandLineRunner demo(EtudiantRepository repository, IncidentRepository incidentRepository) {
        return (args) -> {
            var Bob = new Etudiant("Bob710");
            var Chuck = new Etudiant("Chuck540");

            Incident incident = new Incident();
            incident.setId("Incident10");
            incident.setMotif("probleme eau");
            Bob.setIncidents(incident);

            Incident incident1 = new Incident();
            incident1.setId("Incident11");
            incident1.setMotif("probleme");
            Bob.setIncidents(incident1);

            incidentRepository.save(incident);
            incidentRepository.save(incident1);
            // save a couple of trainers
            repository.save(Bob);
            repository.save(Chuck);
        };
    }

}
