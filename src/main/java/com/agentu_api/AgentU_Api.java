package com.agentu_api;

import com.agentu_api.bo.Agent;
import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Evenement;
import com.agentu_api.bo.Incident;
import com.agentu_api.repository.AgentRepository;
import com.agentu_api.repository.EtudiantRepository;
import com.agentu_api.repository.EvenementRepository;
import com.agentu_api.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
public class AgentU_Api {

    public static void main(String... args){
        SpringApplication.run(AgentU_Api.class, args);
    }

    @Bean
    @Autowired
    public CommandLineRunner demo(EtudiantRepository repository, IncidentRepository incidentRepository,
                                  AgentRepository agentRepository, EvenementRepository evenementRepository) {
        return (args) -> {
            var Bob = new Etudiant("1");
            var Chuck = new Etudiant("2");



            repository.save(Bob);
            repository.save(Chuck);




            Incident incident = new Incident();
            incident.setId("Incident10");
            incident.setMotif("probleme eau");
            incident.setEtudiant(Bob);


            Incident incident1 = new Incident();
            incident1.setId("Incident11");
            incident1.setMotif("probleme");
            incident1.setEtudiant(Bob);


            incidentRepository.save(incident);
            incidentRepository.save(incident1);




            var a = new Agent();
            var b = new Agent();
            var c = new Agent();
            var d = new Agent();
            var e = new Agent();
            var f = new Agent();
            var g = new Agent();







            // ajouter des agents


            agentRepository.save(a);
            agentRepository.save(b);
            agentRepository.save(c);
            agentRepository.save(d);
            agentRepository.save(e);
            agentRepository.save(f);
            agentRepository.save(g);

            //ajouter des évenements
            Evenement evenement1 = new Evenement();
            evenement1.setTitre("Soirée dance");

            Evenement evenement2 = new Evenement();
            evenement2.setTitre("Youga");
            evenementRepository.save(evenement1);
            evenementRepository.save(evenement2);
        };
    }

}
