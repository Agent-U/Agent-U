package com.agentu_api.repository;

import com.agentu_api.bo.Evenement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement,String> {

}
