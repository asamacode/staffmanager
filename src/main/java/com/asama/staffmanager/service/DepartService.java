package com.asama.staffmanager.service;

import java.util.List;
import java.util.Optional;

import com.asama.staffmanager.model.Depart;

public interface DepartService {

    void deleteAll();

    void deleteAll(List<Depart> entities);

    void delete(Depart entity);

    void deleteById(Integer id);

    long count();

    List<Depart> findAllById(Iterable<Integer> ids);

    List<Depart> findAll();

    boolean existsById(Integer id);

    Optional<Depart> findById(Integer id);

    List<Depart> saveAll(List<Depart> entities);

    Depart save(Depart entity);
    
}
