package com.asama.staffmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asama.staffmanager.model.Depart;

@Repository
public interface DepartRepository extends CrudRepository<Depart, Integer>{
    
}
