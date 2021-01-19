package com.agentu_api.repository;

import com.agentu_api.bo.RendezVous;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends CrudRepository<RendezVous,String> {
}
