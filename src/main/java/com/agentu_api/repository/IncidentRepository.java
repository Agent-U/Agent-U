package com.agentu_api.repository;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Incident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends CrudRepository<Incident, Long> {

}
